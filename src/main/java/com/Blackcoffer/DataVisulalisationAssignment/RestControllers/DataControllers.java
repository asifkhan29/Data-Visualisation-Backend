package com.Blackcoffer.DataVisulalisationAssignment.RestControllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Blackcoffer.DataVisulalisationAssignment.Models.DataRequest;
import com.Blackcoffer.DataVisulalisationAssignment.Models.DataResponse;
import com.Blackcoffer.DataVisulalisationAssignment.Services.DataServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/data")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class DataControllers {
	
	private final DataServices dataServices;
	
	@PostMapping("/saveOnce")
	public String saveOnce(DataRequest dataRequest)
	{
		return this.dataServices.saveOneRow(dataRequest);
	}
	@PostMapping("/saveCsv")
	public String saveCsv(@RequestParam("file") MultipartFile file)
	{
		return this.dataServices.saveCsv(file);
	}
	@GetMapping("/all")
	public List<DataResponse> getAllData()
	{
		return this.dataServices.getAllData();
	}
	@GetMapping("/{id}")
	public DataResponse getById(@PathVariable  Integer id)
	{
		return this.dataServices.getById(id);
	}
	@PutMapping("/")
	public String update(DataRequest dataRequest)
	{
		return this.dataServices.update(dataRequest);
	}
	@DeleteMapping("/")
	public String deleteById(Integer id)
	{
		return this.dataServices.deleteById(id);
	}
}
