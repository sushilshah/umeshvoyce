package com.voyce.quiz.models;

import java.util.Map;

public class Ratings {
	
	public class Rating{
		private int ratingId;
		private int ratingScore;
		private int questionId;
		
		public int getRatingId() {	return ratingId; }
		public void setRatingId(int ratingId) {	this.ratingId = ratingId; }
		public int getRatingScore() { return ratingScore; }
		public void setRatingScore(int ratingScore) { this.ratingScore = ratingScore; }
		public int getQuestionId() { return questionId;	}
		public void setQuestionId(int questionId) {	this.questionId = questionId; }
	}
	
	private Map<Integer, Rating> ratings;

	public Map<Integer, Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Map<Integer, Rating> ratings) {
		this.ratings = ratings;
	}
	
	
}
