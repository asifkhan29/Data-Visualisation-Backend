package com.Blackcoffer.DataVisulalisationAssignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blackcoffer.DataVisulalisationAssignment.Entity.Data;

public interface DataRepo extends JpaRepository<Data, Integer>{

}
