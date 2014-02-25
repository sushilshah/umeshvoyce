package com.voyce.quiz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import com.voyce.quiz.engine.OtherUtils.ValueComparator;
import com.voyce.quiz.models.Questions;
import com.voyce.quiz.models.Question;
import com.voyce.util.JsonUtils;


public class CopyOfQuizEngineMain {

	/**
	 * @param args
	 */
	
	public static int CRITICAL_RATING_LIMIT = 2;
	
	//if the response if from one question e.g how was ur overall exp? 
	public static Questions nextQuestion(Questions questionsFromDB , Double currQuesNo, int rating, int numberOfQuestions){
		//QuestionsNew questionsFromDB = readFromJsonFile();
		Question currentQuestion = new Question();
		Questions opQuestions = new Questions();

		try{
			currentQuestion = questionsFromDB.getQuestions().get(currQuesNo);
		}catch(Exception e){
			System.out.println("Unable to find question number : " + currQuesNo);
			e.printStackTrace();
		}
		List<Double> _listOfNxtQues = questionsFromDB.getQuestions().get(currQuesNo).getNextQuestionMap().get(rating);
		TreeMap<Integer, List<Double>> mapOfRatingAndQuestions = new TreeMap<Integer, List<Double>>();
		mapOfRatingAndQuestions.put(rating, _listOfNxtQues);
		opQuestions = getRequiredNumberofQuestions( getQuestionsOfList(questionsFromDB, _listOfNxtQues), numberOfQuestions);

		return opQuestions; //return highestWeightageQuestions 
	
	}
	
	//if the response is from multiple questions e.g L1 and L2 questions? 
		public static Questions nextQuestion(Questions questionsFromDB, TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap, int numberOfQuestions){
			return questionLogicForMultipleResponses(questionsFromDB , ratingsAndQuestionsNoMap, numberOfQuestions);
		}

		
	public static Questions getRequiredNumberofQuestions(Questions questions, int numberOfQuestions){
		//strip and give the required number of questions
		Questions outputQuestions  = new Questions();
		Map<Double, Question>  outputQuestionsMap = new HashMap<Double, Question>();
		
		//Sorting the TreeMap based on Value using ValueComparator
		 HashMap<Double,Double> map = new HashMap<Double,Double>();
		 ValueComparator bvc =  new ValueComparator(map);
		TreeMap<Double, Double> treemap = new TreeMap<Double,Double>(bvc);
		
		for(Double key : questions.getQuestions().keySet()){
			map.put(key, questions.getQuestions().get(key).getWeightage());
		}
		treemap.putAll(map);
		
		if(numberOfQuestions == questions.getQuestions().size())
			return questions;
		
		if(numberOfQuestions > questions.getQuestions().size()){
			numberOfQuestions = questions.getQuestions().size();
		}
		int count = 0;
		
		for( Double  entry : treemap.keySet()){
			outputQuestionsMap.put(entry,questions.getQuestions().get(entry));
			count++;
			if(numberOfQuestions == count){
				outputQuestions.setQuestions(outputQuestionsMap);
				return outputQuestions;
			}
		}
		outputQuestions.setQuestions(outputQuestionsMap);
		return outputQuestions;
	}
	
	public static Questions questionLogicForMultipleResponses(Questions questionsFromDB, TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap, int numberOfQuestions){
		
		Questions outputQUestions =  new Questions();
		
		if(questionsFromDB.getQuestions().size() < numberOfQuestions)
			numberOfQuestions = questionsFromDB.getQuestions().size();
		
		//considering mapOfNextQues will be a sorted list
		for(int rating : ratingsAndQuestionsNoMap.keySet()){
			List<Double> questionList = ratingsAndQuestionsNoMap.get(rating);
			if(questionList.size() < 1)
				continue;

			Questions allNextQuestions = getAllNextQuestions(questionsFromDB, questionList, rating);
			//currently if you have a rating of 1,2,3 then it will try to fill the questions from all three rating questions which is incorrect 
			// you should only check for questions from bracket (1,2) ... Oops CHANGE IN LOGIC .. DISREGARD THE PREVIOUS LINE OF COMMENT .. ;P
			//new logic the output question bucket should be filled full (= noOfQuestion) 
			//so the bucket will be filled first with question of rating 1 first and 2 then and if still space is remaining (which is unlike as per todays logic) then add a random question from rating 3
			if (Arrays.asList(1,2).contains(rating)){
				List<Double> consollidatedQueList = new ArrayList<Double>();
				List<Double> _questionList;
				_questionList = ratingsAndQuestionsNoMap.containsKey(1) ?  ratingsAndQuestionsNoMap.get(1) : null;
				//TODO check for empty and not just null {1=[], 2=[4.0], 3=[], 4=[3.0, 2.0], 5=[5.0]}
				System.out.println("_questionList.size() : " + _questionList.size());
				if((_questionList != null || _questionList.size() != 0) && rating == 1){
					 List<Double> rating1NxtQueList = ratingsAndQuestionsNoMap.get(rating);
					 //Map<Double, Question> _tempQuestions = getKeysForQuestionSet(questionsFromDB, ratingsAndQuestionsNoMap, numberOfQuestions);
					Map<Double, Question> _tempQuestions = getQuestionSetOfList(questionsFromDB, rating1NxtQueList,rating,  numberOfQuestions );
					if(outputQUestions.getQuestions() != null)
						outputQUestions.getQuestions().putAll( _tempQuestions);
					else
						outputQUestions.setQuestions(_tempQuestions ); 
				}else if(rating == 2){
					//TODO might be else is also required here
					//if there is anymore room for questions then get rating 2 highest weightage questions and add 
					_questionList = ratingsAndQuestionsNoMap.containsKey(2) ?  ratingsAndQuestionsNoMap.get(2) : null;
					//int questionSize = (outputQUestions.getQuestions().size() != 0 ? outputQUestions.getQuestions().size() : 0);
					int questionSize = outputQUestions.getQuestions() != null ? outputQUestions.getQuestions().size() : 0;
					System.out.println(" _questionList 1 : " + _questionList.size());
					if(numberOfQuestions > questionSize  && (_questionList != null  || _questionList.size() != 0)){
						//guess required getRequiredNumberofQuestions is not required here
						//Map<Double, Question> _tempQuestions = getKeysForQuestionSet(questionsFromDB, ratingsAndQuestionsNoMap, numberOfQuestions);
						//getAllNextQuestions(questionsFromDB, quesList, rating)
						List<Double> rating2NxtQueList = ratingsAndQuestionsNoMap.get(2);
						Map<Double, Question> _tempQuestions = getQuestionSetOfList(questionsFromDB, rating2NxtQueList, rating , numberOfQuestions);
						if(outputQUestions.getQuestions() != null)
							outputQUestions.getQuestions().putAll( _tempQuestions);
						else
							outputQUestions.setQuestions(_tempQuestions ); 
					}
				}
				if(!ratingsAndQuestionsNoMap.containsKey(3) || numberOfQuestions == outputQUestions.getQuestions().size()){
					return outputQUestions; //return highestWeightageQuestions -- outputQUestions
				}
				//get the size and loop through if if not equal to numberOfQuestions
			}else if(rating == 3 && (!ratingsAndQuestionsNoMap.containsKey(1) && !ratingsAndQuestionsNoMap.containsKey(2)) ){
				int questionSize = (outputQUestions.getQuestions() != null ? outputQUestions.getQuestions().size() : 0);
				//give some random question from this section

				outputQUestions = getRandomQuestions(allNextQuestions, (numberOfQuestions - questionSize));
				return outputQUestions; //outputQUestions -- Optimistic return not checking any of the questions more than rating 3
				//get randon questions from foo
				//get_random_questions
				
				//can write the mapOfNextQues conditions better
			}else if(rating == 3 && (ratingsAndQuestionsNoMap.containsKey(1) || ratingsAndQuestionsNoMap.containsKey(2))  ){
				// && ( outputQUestions.getQuestions() != null && numberOfQuestions > outputQUestions.getQuestions().size()) removed this condition from else if
				int questionSize = (outputQUestions.getQuestions() != null ? outputQUestions.getQuestions().size() : 0);
				
				if(outputQUestions.getQuestions() != null){
					outputQUestions.getQuestions().putAll(getRandomQuestions(allNextQuestions, (numberOfQuestions - questionSize)).getQuestions());
				}
				else
					outputQUestions.setQuestions(getRandomQuestions(allNextQuestions, (numberOfQuestions - questionSize)).getQuestions());
				//return outputQUestions; //outputQUestions -- Optimistic return not checking any of the questions more than rating 3 
				
			}else if (Arrays.asList(4,5).contains(rating) && (!ratingsAndQuestionsNoMap.containsKey(1) && !ratingsAndQuestionsNoMap.containsKey(2)) && !ratingsAndQuestionsNoMap.containsKey(3)){
				//Dont do much
			}else{
				//there is a bug here Selection out of range : You rated [4]. Supported ratings are [1,2,3,4,5]
				System.out.println("Selection out of range : You rated [" + rating + "]. Supported ratings are [1,2,3,4,5]");
			}
		}
		return outputQUestions;
	}
	

		 public static Questions getRandomQuestions(Questions questions, int numberOfQuestions){
			 //random func
			 
			 TreeMap<Double, Question> questionMap = new TreeMap<Double, Question>(); //use set questions
			 questionMap.putAll(questions.getQuestions());
			 
			/* Double rangeMax = questionMap.lastKey();
			 Double rangeMin = questionMap.firstKey();*/
			 
			 int count = 0;
			 Questions outputQuestions = new Questions();
			 int questionsSize = questions.getQuestions().size();
			 if(numberOfQuestions > questionsSize)
				 numberOfQuestions = questionsSize;
			
			 if (numberOfQuestions  == questionsSize)
				 return questions; //return questions

			 while(numberOfQuestions > count){ //TODO check if numberOfQuestions < count is required [IMPORTANT] 
				 Random rand = new Random();
			//	 double randomValue ;
				 //run loop once as long as the question is not found

				  Set<Double> _r = questions.getQuestions().keySet();
				  List<Double> randlist = new ArrayList<Double>(_r);

				  Double randKey = randlist.get(rand.nextInt(randlist.size()));
				  if(questions.getQuestions().containsKey(randKey)){
					  if(outputQuestions.getQuestions() == null){
						Map<Double, Question>  _map = new HashMap<Double, Question>();
						_map.put(randKey, questions.getQuestions().get(randKey));
						outputQuestions.setQuestions(_map);
						randlist.remove(randKey);
					  }
					  else{
						  outputQuestions.getQuestions().put(randKey, questions.getQuestions().get(randKey));
						  randlist.remove(randKey);
					  }
				  }
				  
				 //Ahhh thank God, got rid of this loop :) 
			/*	 do{
					 randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			
					if(questions.getQuestions().containsKey(randomValue))
						outputQuestions.getQuestions().put(randomValue, questions.getQuestions().get(randomValue));
			
				 }while(!questions.getQuestions().containsKey(randomValue));
				 */
				 
/*				 do{
					 randomValue = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
			
					if(questions.getQuestions().containsKey(randomValue))
						outputQuestions.getQuestions().put(randomValue, questions.getQuestions().get(randomValue));
			
				 }while(!questions.getQuestions().containsKey(randomValue));*/
				 count = outputQuestions.getQuestions() != null ? outputQuestions.getQuestions().size() : 0;
			 }
			 
			 return outputQuestions; //return outputQuestions;
		 }
		/**
		 * get the highest weightage question from the list of questions
		 * @param questionsFromDB
		 * @param nextQuesList
		 * @return
		 */
		public static Questions getHighestWeightageQuestion(Questions local_questionsFromDB, List<Double> nextQuesList){
			double highestWeightageQues = 0;
			try{
				if(local_questionsFromDB.getQuestions().get(nextQuesList.get(0)) != null)
					highestWeightageQues = local_questionsFromDB.getQuestions().get(nextQuesList.get(0)).getWeightage();
			}catch (Exception e){ //check y is it not catching null pointer exception
				System.err.println("[Error] : wrong selection question number in the nextQuesList is not valid.");
				e.printStackTrace();
			}
			
			Questions returnQuestions = new Questions();
			Map<Double, Question> questionsfoo = new HashMap<Double, Question>();
			
			Iterator<Double> it	= nextQuesList.iterator();
			while(it.hasNext()){
				Double queNo = it.next();
				if(local_questionsFromDB.getQuestions().get(queNo) == null){
					System.err.println( "Unable to get question number : " + queNo + " Please check if the question exists.");
				}
				//the higher the number the higher the weightage
				if(local_questionsFromDB.getQuestions().get(queNo) != null && highestWeightageQues < local_questionsFromDB.getQuestions().get(queNo).getWeightage()){
					//returnQues  = questionsFromDB.getQuestions().get(d);
					highestWeightageQues = 	local_questionsFromDB.getQuestions().get(queNo).getWeightage();
					questionsfoo.clear();
					questionsfoo.put(queNo, local_questionsFromDB.getQuestions().get(queNo));
				}else if(local_questionsFromDB.getQuestions().get(queNo) != null && highestWeightageQues == local_questionsFromDB.getQuestions().get(queNo).getWeightage()){ //if highest weightage question is the first one then 
					questionsfoo.put(queNo, local_questionsFromDB.getQuestions().get(queNo));
				}
			}
			returnQuestions.setQuestions(questionsfoo);
			return returnQuestions;
		}
		
		/**
		 * Get all the questions from nextQuestionList
		 * @return 
		 */
		public static Questions getAllNextQuestions(Questions questionsFromDB, List<Double> quesList, int rating){
			Questions returnQuestions = new Questions();
			Map<Double, Question> _questions = new HashMap<Double, Question>();
			List<Double> _nextQuestionList =  new ArrayList<Double>();
			
			for(Double queNo : quesList){
				_nextQuestionList = questionsFromDB.getQuestions().get(queNo).getNextQuestionMap().get(rating);
				for(Double nxtQue : _nextQuestionList)
					_questions.put(nxtQue, questionsFromDB.getQuestions().get(nxtQue));
			}
			returnQuestions.setQuestions(_questions);
			return returnQuestions;
		}
		
		public static Questions getQuestionsOfList(Questions questionsFromDB, List<Double> quesList){
			Questions returnQuestions = new Questions();
			Map<Double, Question> questionsfoo = new HashMap<Double, Question>();
			
			for(Double d : quesList){
				questionsfoo.put(d, questionsFromDB.getQuestions().get(d));
			}
			returnQuestions.setQuestions(questionsfoo);
			return returnQuestions;
		}
		
		/**
		 * To decide and get the question set out $$$$$$$$$$
		 * I want 5 ques. They response keys are 1:[2.0,3.0,5.0], 4:[4.0]
		 * @return 
		 */
		//static int noOfQuest = 5; //GIVE NUMBER OF QUESTION REQUIRED HERE
		
		public static Map<Double, Question> getQuestionSetOfList(Questions questionsFromDB,List<Double> ratingNextQuesList,int rating, int noOfQuest ){
			//add paramater int noOfQuest
			Questions outputQuestions;
			Map<Double, Question> outputQuestionsMap = new HashMap<Double, Question>();
			
			int count = 0;
			Questions fullQuesListOfRating = new Questions();

			
				if(noOfQuest == count ){
					return outputQuestionsMap;
				}
				//add questions from its list
				List<Double> listOfQuesNos = new ArrayList<Double>();
				listOfQuesNos.addAll(ratingNextQuesList);

				List<Double> _listOfQuesNos =  new ArrayList<Double>();
				for(Double entry : listOfQuesNos)
					 _listOfQuesNos.addAll(questionsFromDB.getQuestions().get(entry).getNextQuestionMap().get(rating));

				fullQuesListOfRating.setQuestions(getQuestionsOfList(questionsFromDB, _listOfQuesNos).getQuestions());
				System.out.println(" fullQuesListOfRating : " + JsonUtils.convertToJson(fullQuesListOfRating));
				while(!fullQuesListOfRating.getQuestions().isEmpty() && count < noOfQuest ){
					Questions _fullQuesListOfRating = new Questions();  
					Map<Double, Question> _highestWeiQue = new HashMap<Double, Question>();
					_fullQuesListOfRating.setQuestions(fullQuesListOfRating.getQuestions());
					_highestWeiQue  = getHighestWeightageQuestion(_fullQuesListOfRating, _listOfQuesNos).getQuestions();
					outputQuestionsMap.putAll(_highestWeiQue);

					for(Double quesnos : _highestWeiQue.keySet()){
						_fullQuesListOfRating.delete(quesnos);
						_fullQuesListOfRating.getQuestions().remove(quesnos);
						_listOfQuesNos.remove(quesnos);
					}
					count = outputQuestionsMap.size();
				}

		 		//Check if the this is required 
//				if(outputQuestionsMap.size() == count);
//					return outputQuestionsMap;
			
			return outputQuestionsMap; 
		}

		
		
		
		//TODO change method name
		//IMPORTANT not used 
		public static Map<Double, Question> getKeysForQuestionSet(Questions questionsFromDB,TreeMap<Integer, List<Double>> mapOfRatingAndQuestions, int noOfQuest ){
			//add paramater int noOfQuest
			Questions outputQuestions;
			Map<Double, Question> outputQuestionsMap = new HashMap<Double, Question>();
			
			int count = 0;
			Questions fullQuesListOfRating = new Questions();

			for(Integer ratingKeys : mapOfRatingAndQuestions.keySet()){ //assuming the keys will be sorted due to TreeMap
				if(noOfQuest == count ){
					return outputQuestionsMap;
				}
				//add questions from its list
				List<Double> listOfQuesNos = new ArrayList<Double>();
				listOfQuesNos.addAll(mapOfRatingAndQuestions.get(ratingKeys));

				List<Double> _listOfQuesNos =  new ArrayList<Double>();
				for(Double entry : listOfQuesNos)
					 _listOfQuesNos.addAll(questionsFromDB.getQuestions().get(entry).getNextQuestionMap().get(ratingKeys));

				fullQuesListOfRating.setQuestions(getQuestionsOfList(questionsFromDB, _listOfQuesNos).getQuestions());
				
				while(!fullQuesListOfRating.getQuestions().isEmpty() && count < noOfQuest ){
					Questions _fullQuesListOfRating = new Questions();  
					Map<Double, Question> _highestWeiQue = new HashMap<Double, Question>();
					_fullQuesListOfRating.setQuestions(fullQuesListOfRating.getQuestions());
					_highestWeiQue  = getHighestWeightageQuestion(_fullQuesListOfRating, _listOfQuesNos).getQuestions();
					outputQuestionsMap.putAll(_highestWeiQue);

					for(Double quesnos : _highestWeiQue.keySet()){
						_fullQuesListOfRating.delete(quesnos);
						_fullQuesListOfRating.getQuestions().remove(quesnos);
						_listOfQuesNos.remove(quesnos);
					}
					count = outputQuestionsMap.size();
				}

		 		//Check if the this is required 
				if(outputQuestionsMap.size() == count);
					return outputQuestionsMap;
				}
			return outputQuestionsMap; 
		}

}
