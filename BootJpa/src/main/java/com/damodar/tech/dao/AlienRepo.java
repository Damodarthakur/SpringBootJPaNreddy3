package com.damodar.tech.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.damodar.tech.model.Alien;

//CrudRepository is an Interface

//public interface AlienRepo extends CrudRepository<Alien,Integer> {
//---------We are not using  anything below in Rest Api keep it blank
	
//	List<Alien>findByTech(String tech);		//method name should always start with findBy
//	List<Alien>findByAidGreaterThan(int aid);
//	
//	@Query("from Alien where tech=?1 order by aname")
//	List<Alien>findByTechSorted(String tech);
//}

//----------To convert in json format we are using JpaRepository instead of CrudRepository so that we ll get extra feature --------
public interface AlienRepo extends JpaRepository<Alien,Integer> {
	//We have all the feature of crudRepository plus extra feature
	
	
}
