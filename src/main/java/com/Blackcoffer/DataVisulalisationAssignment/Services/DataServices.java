package com.Blackcoffer.DataVisulalisationAssignment.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Blackcoffer.DataVisulalisationAssignment.Models.DataRequest;
import com.Blackcoffer.DataVisulalisationAssignment.Models.DataResponse;

@Service
public interface DataServices {

	public String saveOneRow(DataRequest dataRequest);
	public String saveCsv(MultipartFile file);
	public List<DataResponse> getAllData();
	public DataResponse getById(Integer id);
	public String update(DataRequest dataRequest);
	public String deleteById(Integer id);
}
