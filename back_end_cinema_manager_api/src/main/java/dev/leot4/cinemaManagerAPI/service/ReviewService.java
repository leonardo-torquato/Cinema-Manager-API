package dev.leot4.cinemaManagerAPI.service;

import dev.leot4.cinemaManagerAPI.model.Review;

public interface ReviewService {
    public Review createReview(String reviewBody, String imdbId);
}
