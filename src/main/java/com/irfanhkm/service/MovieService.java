package com.irfanhkm.service;

import com.irfanhkm.model.Movie;
import com.irfanhkm.model.MovieRepository;

import javax.inject.Inject;
import java.util.List;

public class MovieService {
    @Inject
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public List<Movie> getAll()
    {
        return movieRepository.findAll();
    }
}
