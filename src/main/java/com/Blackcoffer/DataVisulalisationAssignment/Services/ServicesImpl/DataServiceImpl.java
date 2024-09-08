package com.Blackcoffer.DataVisulalisationAssignment.Services.ServicesImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Blackcoffer.DataVisulalisationAssignment.Entity.Data;
import com.Blackcoffer.DataVisulalisationAssignment.Models.DataRequest;
import com.Blackcoffer.DataVisulalisationAssignment.Models.DataResponse;
import com.Blackcoffer.DataVisulalisationAssignment.Repository.DataRepo;
import com.Blackcoffer.DataVisulalisationAssignment.Services.DataServices;
import com.Blackcoffer.DataVisulalisationAssignment.Utilities.ConvertingData;
import com.Blackcoffer.DataVisulalisationAssignment.Utilities.DataUtilitiesMethods;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataServiceImpl implements DataServices{

	
	private final ModelMapper mapper;
	private final DataRepo dataRepo;
	private final DataUtilitiesMethods utilitiesMethods;
	
	@Override
	public String saveOneRow(DataRequest dataRequest) {
		
		this.dataRepo.save(mapper.map(dataRequest, Data.class));
		return "Success";
		
	}

	@Override
	public String saveCsv(MultipartFile file) {
		
		dataRepo.saveAll(utilitiesMethods.uploadCSV(file));
		return "Success";
	
	
	}

	@Override
	public List<DataResponse> getAllData() {
		List<Data> AllData = this.dataRepo.findAll();
		
		 return AllData.stream()
		                 .map(ConvertingData::convertToDataResponse)
		                 .toList();
		
		
	}

	@Override
	public DataResponse getById(Integer id) {
		// TODO Auto-generated method stub
		
		return mapper.map(this.dataRepo.findById(id), DataResponse.class);
	}

	@Override
	public String update(DataRequest dataRequest) {
		// TODO Auto-generated method stub
		 this.dataRepo.save(mapper.map(dataRequest, Data.class));
		 return "Success";
	}

	@Override
	public String deleteById(Integer id) {
		this.dataRepo.deleteById(id);
		return "Success";
	}

	

}
