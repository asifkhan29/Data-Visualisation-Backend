package com.Blackcoffer.DataVisulalisationAssignment.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigurations {
	
	@Bean
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}
	
	

}
