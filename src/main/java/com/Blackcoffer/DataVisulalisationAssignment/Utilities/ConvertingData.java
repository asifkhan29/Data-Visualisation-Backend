package com.Blackcoffer.DataVisulalisationAssignment.Utilities;

import com.Blackcoffer.DataVisulalisationAssignment.Entity.Data;
import com.Blackcoffer.DataVisulalisationAssignment.Models.DataResponse;



public class ConvertingData {
	
	public static  DataResponse convertToDataResponse(Data data) {
	    DataResponse response = new DataResponse();
	    response.setId(data.getId());
	    response.setTitle(data.getTitle());
	    response.setEnd_year(data.getEnd_year());
	    response.setCitylng(data.getCitylng());
	    response.setCitylat(data.getCitylat());
	    response.setIntensity(data.getIntensity());
	    response.setSector(data.getSector());
	    response.setTopics(data.getTopics());
	    response.setSwot(data.getSwot());
	    response.setUrl(data.getUrl());
	    response.setRegion(data.getRegion());
	    response.setStart_year(data.getStart_year());
	    response.setImpact(data.getImpact());
	    response.setPublished(data.getPublished());
	    response.setCity(data.getCity());
	    response.setCountry(data.getCountry());
	    response.setRelevance(data.getRelevance());
	    response.setPestle(data.getPestle());
	    response.setSource(data.getSource());
	    response.setLikelihood(data.getLikelihood());
	    return response;
	}

}
