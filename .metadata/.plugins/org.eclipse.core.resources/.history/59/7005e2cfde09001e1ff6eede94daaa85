package com.openclassroom.projet5.repository;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.openclassroom.projet5.model.DataJson;




	@Repository
	public class DAOJson implements IDAOJson {
	    private String jsonPath = "src/main/resources/data_projet5.json";
	    private static final Logger logger = LogManager.getLogger("AlertsApplication");

	    private DataJson jsonData;

	    public DAOJson() throws FileNotFoundException, IOException {
		this.readJson(this.jsonPath);
	    }

	    @Override
	    public DataJson getJsonData() {
		return jsonData;
	    }

	    @Override
	    public void setJsonData(DataJson jsonData) {
		this.jsonData = jsonData;
	    }

	    @Override
	    public String getJsonPath() {
		return this.jsonPath;
	    }

	    @Override
	    public void setJsonPath(String jsonLocation) {
		this.jsonPath = jsonLocation;
	    }

	    @Override
	    public void readJson(String property) throws FileNotFoundException, IOException {

		try (FileReader file = new FileReader(this.getJsonPath())) {
		    BufferedReader reader = new BufferedReader(file);
		    String jsonString = "";
		    String line = reader.readLine();

		    while (line != null) {
			jsonString += line;
			line = reader.readLine();
		    }
		    Map<String, Any> deserializedMap = JsonIterator.deserialize(jsonString).asMap();

		    this.setJsonData(JsonIterator.deserialize(jsonString, DataJson.class));
		}
		
	   };
	

}
