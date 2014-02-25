package com.voyce.quiz.models;

import java.util.List;
import java.util.TreeMap;

public class Question{
	private double questionId;
	private double rateScore;
	private String category;
	private String questionText;
	private TreeMap<Integer, List<Double>> nextQuestionMap = new TreeMap<Integer, List<Double>>();
	private double previousQuestion;
	private double weightage;
	private int setNo;
	private int scale;
	private int level;
	public double getQuestionId() {
		return questionId;
	}
	public void setQuestionId(double questionId) {
		this.questionId = questionId;
	}
	public double getRateScore() {
		return rateScore;
	}
	public void setRateScore(double rateScore) {
		this.rateScore = rateScore;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getSetNo() {
		return setNo;
	}
	public void setSetNo(int setNo) {
		this.setNo = setNo;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
			
}// Question
