package com.movies2c.backend.controller;

import com.movies2c.backend.service.TmdbClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
     private final TmdbClient tmdbClient;

     public ActorController(TmdbClient tmdbClient){
         this.tmdbClient = tmdbClient;
     }

     @GetMapping("api/search/person")
    public String searchMovieByActor(@RequestParam(required = true) String actor){
         return this.tmdbClient.searchMovieByActor(actor);
     }


}
