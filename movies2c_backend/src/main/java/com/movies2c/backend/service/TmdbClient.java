package com.movies2c.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbClient {

    @Value("${tmdb.api.readToken}")
    private String readToken;

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.themoviedb.org/3/";

    public String getTrendingMovies(){
        String url = BASE_URL + "/trending/movie/week";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + readToken);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url,HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getMovieDetails(String id){
        String url = BASE_URL + "/movie/"+id;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + readToken);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url,HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String searchMovieByName(String name){
        String url = BASE_URL + "search/movie?query="+name;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + readToken);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url,HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String searchMovieByActor(String actor){
        String url = BASE_URL + "search/person?query="+actor;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + readToken);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url,HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
