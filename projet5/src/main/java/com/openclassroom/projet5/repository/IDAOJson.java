package com.openclassroom.projet5.repository;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.openclassroom.projet5.model.DataJson;

public interface IDAOJson {
	

	    DataJson getJsonData();

	    void setJsonData(DataJson jsonData);

	    String getJsonPath();

	    void setJsonPath(String jsonLocation);

	    void readJson(String property) throws FileNotFoundException, IOException;

	    // void writeJson(String[] values, String property);

	
}
