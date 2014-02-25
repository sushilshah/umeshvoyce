package com.voyce.quiz.actions;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.voyce.quiz.engine.QuizEngineMain;
import com.voyce.quiz.models.Questions;
import com.voyce.util.JsonUtils;

public class QuestionAction extends ActionSupport implements  ServletRequestAware,ServletContextAware, 
ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
   
	private Questions questions;
	private HttpServletRequest request;
	private ServletContext servletcontext;
	
	@Override
    public String execute(){
	       
		String filePath = servletcontext.getRealPath("WEB-INF/data/ques.json");
		
		questions = new Questions();
		Questions questionsFromDB = new Questions(); 
		questionsFromDB  = JsonUtils.readFromJsonFile(filePath);
		
		int numberOfQues =  Integer.parseInt(request.getParameter("numberOfQues"));
		if("false".equalsIgnoreCase(request.getParameter("multi"))){
			Double questionNumber = Double.parseDouble(request.getParameter("questionNumber"));
			int rating = Integer.parseInt(request.getParameter("rating"));

			Questions _outputQueSet = QuizEngineMain.nextQuestion(questionsFromDB,questionNumber, rating, numberOfQues);
			setQuestions(_outputQueSet);
		}else{
			String _ratingAndQuesMap = request.getParameter("ratingAndQuesMap");
			TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap = new TreeMap<>(); 
			ratingsAndQuestionsNoMap.putAll(JsonUtils.convertMapFromJson(_ratingAndQuesMap));
			Questions _outputQueSet = QuizEngineMain.nextQuestion(questionsFromDB, ratingsAndQuestionsNoMap, numberOfQues);
			
			//lame logic.. check if any of the questions in _outputQueSet contains questions from any set if yes then get all the question of that..
			Questions  tempQuestions = new Questions();
			List<Integer> setStack = new ArrayList<>();
			for(Double quesNo : _outputQueSet.getQuestions().keySet()){
				System.out.println(_outputQueSet.getQuestions().get(quesNo).getSetNo());
				int curSetNo = _outputQueSet.getQuestions().get(quesNo).getSetNo();
				if( curSetNo > 0 && !setStack.contains(curSetNo)){
					setStack.add(curSetNo);
					tempQuestions.getQuestions().putAll(questionsFromDB.getQuestionsSet(curSetNo));
				}
				//if setno != null then get push the setno to a list and get all the question of this set
				// getAllQuestionSet(questionDB, setNo)
			}
			System.out.println(" tempQuestions " + tempQuestions.toString());
			System.out.println(" tempQuestions.getQues " + tempQuestions.getQuestions());

			if(tempQuestions.getQuestions() != null && tempQuestions.getQuestions().size() != 0)
				_outputQueSet.getQuestions().putAll(tempQuestions.getQuestions());
			
			//Add some random questions if numberOfQuestion is less than the question fetched by the logic
			if(_outputQueSet.getQuestions().size() < numberOfQues){
				_outputQueSet.getQuestions().putAll(QuizEngineMain.getRandomL2Questions(questionsFromDB, _outputQueSet,(numberOfQues - _outputQueSet.getQuestions().size())).getQuestions());
			}
				
			
			System.out.println("_outputQueSet  : " + JsonUtils.convertToJson(_outputQueSet));
			setQuestions(_outputQueSet);
			// the new logic in which 2 ques out of 5 ques is required as random must be coded here or on the webpage. 
			
		}
		
        return SUCCESS;
    }
     
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public Questions getQuestions() {
		return questions;
	}


	public void setQuestions(Questions questions) {
		this.questions = questions;
	}


	@Override
	public void setServletContext(ServletContext servletcontext ) {
		this.servletcontext = servletcontext ;
		
	}

}
