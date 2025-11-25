package com.movies2c.ui.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieSearchBarService {
    private final String API_KEY = "713c7af082f4b2056e2c56b2f14b9ef3";
    private final String BASE_URL = "https://api.themoviedb.org/3/search/movie";

    private final RestTemplate restTemplate = new RestTemplate();
     public String searchMovies(String query){
         String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                 .queryParam("api_key",API_KEY)
                 .queryParam("query",query)
                 .queryParam("language","en-US")
                 .toUriString();

     return restTemplate.getForObject(url,String.class);
     }
}
