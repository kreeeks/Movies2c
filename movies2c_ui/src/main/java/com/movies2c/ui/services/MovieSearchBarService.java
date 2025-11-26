package com.movies2c.ui.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies2c.ui.models.Movie;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieSearchBarService {

    private static final String API_KEY = "713c7af082f4b2056e2c56b2f14b9ef3";
    private static final String SEARCH_URL =
            "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY + "&query=";

    public List<Movie> searchMovies(String query) {
        List<Movie> movies = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(SEARCH_URL + query.replace(" ", "%20")))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            JsonNode results = root.get("results");

            if (results == null) return movies;

            for (JsonNode item : results) {
                String title = item.get("title").asText();
                String overview = item.get("overview").asText();
                String posterPath = item.get("poster_path").asText();

                String posterUrl = "https://image.tmdb.org/t/p/w500" + posterPath;

                Movie movie = new Movie(title, posterUrl, overview);
                movies.add(movie);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }
}