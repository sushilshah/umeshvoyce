package com.voyce.quiz.models;

import java.util.HashMap;
import java.util.Map;

public class Questions {
	
	
	
	private Map<Double, Question> questions;

	public Map<Double, Question> getQuestionsSet(int setNo){
		Map<Double, Question> returnQues = new HashMap<Double, Question>();
		for(Double quesNo : questions.keySet()){
			if(questions.get(quesNo).getSetNo() == setNo)
				returnQues.put(quesNo, questions.get(quesNo)); //???? check if there is a more beautiful to write this line. something like this.questions
		}
		return returnQues;
	}
	
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
