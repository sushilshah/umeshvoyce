package com.voyce.quiz.models;


import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Questions_old {
	
	public static class Question{
		private double id;
		private double rateScore;
		private String questionText;
		private TreeMap<Integer, List<Double>> nextQuestionMap = new TreeMap<Integer, List<Double>>();
		private double previousQuestion;
		private double weightage;
		private int setNo;
		
		
		public double getId() {
			return id;
		}
		public void setId(double id) {
			this.id = id;
		}
		public double getRateScore() {
			return rateScore;
		}
		public void setRateScore(double rateScore) {
			this.rateScore = rateScore;
		}
		public String getQuestionText() {
			return questionText;
		}
		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}
		public TreeMap<Integer, List<Double>> getNextQuestionMap() {
			return nextQuestionMap;
		}
		public void setNextQuestionMap(TreeMap<Integer, List<Double>> nextQuestionMap) {
			this.nextQuestionMap = nextQuestionMap;
		}
		public double getPreviousQuestion() {
			return previousQuestion;
		}
		public void setPreviousQuestion(double previousQuestion) {
			this.previousQuestion = previousQuestion;
		}
		public double getWeightage() {
			return weightage;
		}
		public void setWeightage(double weightage) {
			this.weightage = weightage;
		}
		public int getsetNo() {
			return setNo;
		}
		public void setsetNo(int setNo) {
			this.setNo = setNo;
		}
		
	}// Question
	
	private Map<Double, Question> questions;

	
	
	public Map<Double, Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Map<Double, Question> questions) {
		this.questions = questions;
	}
	
	/*public boolean isEmpty(){
		return this.questions.isEmpty();
		questions.i
	}*/
	
	public void delete(Double key){
		this.questions.remove(key);
	}
}
