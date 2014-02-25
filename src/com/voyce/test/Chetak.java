package com.voyce.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import com.voyce.quiz.engine.QuizEngineMain;
import com.voyce.quiz.models.Question;
import com.voyce.quiz.models.Questions;
import com.voyce.quiz.models.RestaurantCurrentStatus;
import com.voyce.quiz.models.TableStatus;
import com.voyce.util.JsonUtils;

public class Chetak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Questions questionsFromDB = new Questions(); 
		questionsFromDB  = JsonUtils.readFromJsonFile("D:\\personal_docs\\workbench1\\voyce\\VocyeGAE\\war\\WEB-INF\\data\\ques.json");
		//1=[], 2=[4.0], 3=[], 4=[3.0, 2.0], 5=[5.0]
		//{1=[2.0], 2=[3.0], 3=[], 4=[5.0], 5=[4.0]}
		TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap = new TreeMap<>(); 
		List<Double> lst1 = new ArrayList<>();
		List<Double> lst2 = new ArrayList<>();
		List<Double> lst3 = new ArrayList<>();
		List<Double> lst4 = new ArrayList<>();
		List<Double> lst5 = new ArrayList<>();
		
		lst1.add(5.0);
		lst2.add(3.0);
		//lst4.add(4.0);
		//lst5.add(5.0);
		
		ratingsAndQuestionsNoMap.put(1, lst1);
		ratingsAndQuestionsNoMap.put(2, lst2);
		ratingsAndQuestionsNoMap.put(3, lst3);
		ratingsAndQuestionsNoMap.put(4, lst4);
		ratingsAndQuestionsNoMap.put(5, lst5);
		
		//ratingsAndQuestionsNoMap.putAll(JsonUtils.convertMapFromJson(_ratingAndQuesMap));
		int numberOfQues = 3;
		Questions _outputQueSet = QuizEngineMain.nextQuestion(questionsFromDB, ratingsAndQuestionsNoMap, numberOfQues);
		for(Double foo : _outputQueSet.getQuestions().keySet()){
			System.out.println("SET NO L : "  + _outputQueSet.getQuestions().get(foo).getSetNo());
		}
		System.out.println(" _outputQueSet SIZE : " + _outputQueSet.getQuestions().size());
		System.out.println("_outputQueSet  : " + JsonUtils.convertToJson(_outputQueSet));
		//System.out.println(		questionsFromDB.getQuestionsSet(2).size());
		System.out.println(JsonUtils.convertToJson(QuizEngineMain.getRandomL2Questions(questionsFromDB, _outputQueSet, 5)));
		
		
		
		
		//Questions qs2 = new Questions();
		//Question q2 = new Question();
		
//		q2.setQuestionId(2.0);
//		q2.setCategory("taste");
//		q2.setLevel(2);
//		q2.setQuestionText("Hello question from new modal");
//		q2.setSetNo(22);
//		q2.setScale(5);
//		TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap =  new TreeMap<>();
//		ratingsAndQuestionsNoMap.put(2, new ArrayList<Double>());
//		ratingsAndQuestionsNoMap.get(2).add(2.0);
//		ratingsAndQuestionsNoMap.get(2).add(3.0);
//		ratingsAndQuestionsNoMap.get(2).add(4.0);
//		ratingsAndQuestionsNoMap.get(2).add(5.0);
//		q2.setNextQuestionMap(ratingsAndQuestionsNoMap);
//		Map<Double, Questionv2> mymap = new HashMap<>();
//		mymap.put(2.0, q2);
//		qs2.setQuestions(mymap);
//		System.out.println(JsonUtils.convertToJson(qs2));
		
		//JsonUtils.createJsonFile("d:\\json\\testques.json", qs2);
		
		//qs2 = JsonUtils.readQuesv2JsonFile("d:\\json\\ques.json");
		//System.out.println(JsonUtils.convertToJson(QuizEngineMain.nextQuestion(qs2, 9999.0, 1, 4)));
		//System.out.println(JsonUtils.convertToJson(qs2));
		//System.out.println("Done");
		//String str = "{\"restaurantCurrentStatus\":{\"111\":[{\"tableNumber\":11,\"phoneNumber\":\"123456798\",\"custName\":null,\"currentStatus\":1,\"occupiedSince\":1391539143318,\"restaurantId\":111}]}}";
//		RestaurantCurrentStatus foo = JsonUtils.tableStatusJsonToObj(str);
//		System.out.println(JsonUtils.convertToJson(foo));
//		System.out.println("done");
		
//		RestaurantCurrentStatus res = new RestaurantCurrentStatus();
//		//res = JsonUtils.readTableStatusJsonFile();
//		//System.out.println(JsonUtils.convertToJson(res));
	//	List<TableStatus> lts = new ArrayList<TableStatus>();
		
//		TableStatus ts = new TableStatus();
//		Date date = new Date();
//		//res.getRestaurantCurrentStatus().get(1);
//		ts.setRestaurantId(111);
//		ts.setTableNumber(11);
//		ts.setPhoneNumber("123456798");
//		ts.setOccupiedSince(date);
//		
//		TableStatus ts1 = new TableStatus();
//		//res.getRestaurantCurrentStatus().get(1);
//		ts1.setRestaurantId(111);
//		ts1.setTableNumber(12);
//		ts1.setPhoneNumber("987654321");
//		ts1.setOccupiedSince(date);
//		
//		
//		System.out.println("date : "+ date);
//		
		//lts.add(ts);
//		lts.add(ts1);
		//System.out.println(JsonUtils.convertToJson(lts));
		//Map<Integer, List<TableStatus>> tsm = new HashMap<>();
		//tsm.put(111, lts);
//		res.setRestaurantCurrentStatus(tsm);
		//System.out.println(JsonUtils.convertToJson(res));
		//JsonUtils.createJsonFile("d:\\json\\tableStatus-test.json", res);
//		System.out.println("done");
//		
//		Questions quesfromDB = new Questions();
//		quesfromDB = JsonUtils.readFromJsonFile();
//		System.out.println("done");
//		System.out.println(JsonUtils.convertToJson(quesfromDB));
//		TreeMap<Integer, List<Double>> ratingsAndQuestionsNoMap =  new TreeMap<>();
//		ratingsAndQuestionsNoMap.put(2, new ArrayList<Double>());
//		ratingsAndQuestionsNoMap.get(2).add(2.0);
//		ratingsAndQuestionsNoMap.get(2).add(3.0);
//		ratingsAndQuestionsNoMap.get(2).add(4.0);
//		ratingsAndQuestionsNoMap.get(2).add(5.0);
//		
//		//String jsn = "{\"1\":[],\"2\":[\"3.0\",\"2.0\",\"4.0\",\"5.0\"],\"3\":[],\"4\":[],\"5\":[]}";
//		//String jsn = " {\"1\":[],\"2\":[\"3.0\",\"2.0\",\"4.0\",\"5.0\"],\"3\":[],\"4\":[],\"5\":[]}}";
//		String jsn = "{\"1\":[],\"2\":[],\"3\":[\"3.0\",\"2.0\",\"4.0\",\"5.0\"],\"4\":[],\"5\":[]}";
//		
//		
//		System.out.println(JsonUtils.convertMapFromJson(jsn));
//		Map<Integer, List<Double>> foo = JsonUtils.convertMapFromJson(jsn);
//		System.out.println(foo.toString());
//		System.out.println("quesfromDB : " + quesfromDB.getQuestions());
//		System.out.println(JsonUtils.convertToJson(QuizEngineMain.nextQuestion(quesfromDB, ratingsAndQuestionsNoMap, 5)));
	}

}
