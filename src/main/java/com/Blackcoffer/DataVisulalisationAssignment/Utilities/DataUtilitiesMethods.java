package com.Blackcoffer.DataVisulalisationAssignment.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.Blackcoffer.DataVisulalisationAssignment.Constants.Pestle;
import com.Blackcoffer.DataVisulalisationAssignment.Constants.Region;
import com.Blackcoffer.DataVisulalisationAssignment.Constants.Sectors;
import com.Blackcoffer.DataVisulalisationAssignment.Entity.Data;
import com.Blackcoffer.DataVisulalisationAssignment.Repository.DataRepo;
import com.opencsv.CSVReader;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataUtilitiesMethods {
	
	private final DataRepo dataRepo;

	
	

	public List<Data> uploadCSV( MultipartFile file) {
	        List<Data> allData = new ArrayList<Data>();
	        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
	            List<String[]> records = csvReader.readAll();
	            boolean firstLine = true;
	            
	            for (String[] record : records) {
	                if (firstLine) {
	                    firstLine = false; // Skip header line
	                    continue;
	                }
	                
	                
	                
	                Data data = new Data();
	                data.setEnd_year(record[0]); // end_year
	                data.setCitylng(record[1]); // citylng
	                data.setCitylat(record[2]); // citylat
	                data.setIntensity(record[3]); // intensity
	                data.setSector(record[4]); // sector
	                data.setTopics(record[5]); // topics
	                data.setInsight(record[6]); // insight
	                data.setSwot(record[7]); // swot
	                data.setUrl(record[8]); // url
	                data.setRegion(record[9]); // region
	                data.setStart_year(record[10]); // start_year
	                data.setImpact(record[11]); // impact
	                //data.setadded(record[12]); // published
	                data.setPublished(record[13]); // published
	                data.setCity(record[14]); // city
	                data.setCountry(record[15]); // country
	                data.setRelevance(record[16]); // relevance
	                data.setPestle(record[17]); // pestle
	                data.setSource(record[18]); // source
	                data.setTitle(record[19]); // title
	                data.setLikelihood(record[20]); // likelihood
	                
	                allData.add(data);	                
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return allData;
	    }

}
