package com.voyce.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import com.voyce.quiz.models.Questions;
import com.voyce.quiz.models.Question;
import com.voyce.quiz.models.RestaurantCurrentStatus;
import com.voyce.quiz.models.TableStatus;


/* This class will create and manupulate the jsons for the webpage */
public class JsonUtils {
	static ObjectMapper mapper = new ObjectMapper();
	//jsonFilePaths filepaths = new jsonFilePaths();
	//static final //logger //logger = //logger.get//logger(JsonUtils.class);
	
	/**
	 * read json file into Question Object
	 * @param <T>
	 * @return
	 */
	
	//TODO change this all to generalised class.  Or use classes from saty's impl of vouceJsonDeserializer 
	public static RestaurantCurrentStatus readTableStatusJsonFile(String filePath){
	
		RestaurantCurrentStatus restaurantcurrentstatus = new RestaurantCurrentStatus(); //  readFromJsonFile();;
			try {  //"WEB-INF/data/tableStatus.json"
				restaurantcurrentstatus = mapper.readValue(new File(filePath), RestaurantCurrentStatus.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return restaurantcurrentstatus;
		}
	
	
	
	public static TableStatus tableStatusJsonToObj(String str ){
		
		//RestaurantCurrentStatus restaurantcurrentstatus = new RestaurantCurrentStatus(); //  readFromJsonFile();;
		TableStatus tbs = new TableStatus();
			try {
				tbs = mapper.readValue(str, TableStatus.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tbs;
		}
	
	public static RestaurantCurrentStatus restaurantStatusJsonToObj(String str ){
		
		//RestaurantCurrentStatus restaurantcurrentstatus = new RestaurantCurrentStatus(); //  readFromJsonFile();;
		RestaurantCurrentStatus rcs = new RestaurantCurrentStatus();
			try {
				rcs = mapper.readValue(str, RestaurantCurrentStatus.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rcs;
		}
	
	
	public static Questions readFromJsonFile(String filePath){
	//	ObjectMapper mapper = new ObjectMapper();
			Question q = new Question();
		Questions questionsFromDB  = new Questions(); //  readFromJsonFile();;

		try {
			questionsFromDB = mapper.readValue(new File(filePath), Questions.class);
			//questionsFromDB = mapper.readValue(new File("data\\ques.json"), Questions.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionsFromDB;
	}
	
	
	
	//Methods to create JSON files
	public void createJsonFile(String filepathname, Map map) {
		//logger.info("Enter into createJsonFile using Map ");
		File file = new File(filepathname);
		if(!file.exists()){
			 try {
				 file.createNewFile();
			} catch (IOException e) {
				//logger.error("createJsonFile Failed [CreateNewFile] : " + e.getMessage() );
			}
		 }
		try {
			mapper.writeValue(new File(filepathname), map);
			//logger.info("Json File : " + filepathname + "  have been created" );
		} catch (Exception e) {
			//logger.error("createJsonFile Failed  [writeValue] : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void createJsonFile(String filepathname, List list) {
		//logger.info("Enter into createJsonFile using List ");
		File file = new File(filepathname);
		if(!file.exists()){
			 try {
				 file.createNewFile();
			} catch (IOException e) {
				//logger.error("createJsonFile Failed [CreateNewFile] : " + e.getMessage() );
			}
		 }
		try {
			mapper.writeValue(new File(filepathname), list);
			//logger.info("Json File : " + filepathname + "  have been created" );
		} catch (Exception e) {
			//logger.error("createJsonFile Failed  [writeValue] : " + e.getMessage());
		}
		
	}
	
	public static void createJsonFile(String filepathname, Object obj) {
		//logger.info("Enter into createJsonFile using Object ");
		File file = new File(filepathname);
		if(!file.exists()){
			 try {
				 file.createNewFile();
			} catch (IOException e) {
				//logger.error("createJsonFile Failed [CreateNewFile] : " + e.getMessage() );
			}
		 }
		try {
			mapper.writeValue(new File(filepathname), obj);
			//logger.info("Json File : " + filepathname + "  have been created" );
		} catch (Exception e) {
			//logger.error("createJsonFile Failed  [writeValue] : " + e.getMessage());
		}
		
	}
	
	
	public void deletefile(String filename){
		try{
			 
    		File file = new File(filename);
 
    		if(file.delete()){
    			//logger.info(file.getName() + " is deleted!");
    		}else{
    			//logger.warn("Delete operation is failed.");
    		}
 
    	}catch(Exception e){
    		//logger.error("deletefile Failed");
    	}
	}
	
	public void deletefile(String dirName, final String fileName){
		
		final File folder = new File(dirName);
			final File[] files = folder.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(final File dir, final String name) {
					return name.matches( fileName + ".*\\.json" );
				}
			});
				
			if(files.length > 0){
				for ( final File file : files ) {
				    if ( !file.delete() ) {
				    	//logger.warn( "Can't remove " + file.getAbsolutePath() );
				    }else{
				    	//logger.info("File deleted :" + file.getAbsolutePath());
				    }
				}
			}else
				System.out.println("File not deleted as file doesnot exists " + fileName);
				//logger.info("File not deleted as file doesnot exists " + fileName);
		
	}
	
	
	public static String convertToJson(Object object) {
		//logger.info("Enter convertToJson ");
		String json = "";
		try {
			json =  mapper.writeValueAsString(object);
		} catch (Exception e) {
			//logger.error("convertToJson Failed : " + e.getMessage());
		}
		return json;
	}

	@SuppressWarnings("rawtypes")
	public static Map<Integer, List<Double>> convertMapFromJson(String json) {
		//logger.info("Enter convertFromJson ");
		Object object = null;
		Map<Integer, List<Double>> outputMap = new HashMap<Integer, List<Double>>();
		
		try {
			outputMap = mapper.readValue(json, new TypeReference<HashMap<Integer, List<Double>>>(){});
			System.out.println("TA DA : " + outputMap);
		} catch (Exception e) {
			//logger.error("convertFromJson : " + e.getMessage());
			System.out.println("convertMapFromJson Failed");
		}

		return outputMap;
	}

	//TODO change this all to generalised class.  Or use classes from saty's impl of vouceJsonDeserializer 
		public static Questions readQuesv2JsonFile(String filePath){
		
			Questions questionsV2 = new Questions();
			
				try {  //"WEB-INF/data/tableStatus.json"
					questionsV2 = mapper.readValue(new File(filePath), Questions.class);
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return questionsV2;
			}
	
}
