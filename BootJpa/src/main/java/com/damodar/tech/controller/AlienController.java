package com.damodar.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.damodar.tech.dao.AlienRepo;
import com.damodar.tech.model.Alien;

//{{{{  <---------------commented for rest POST part 8-------------->
//@Controller
//public class AlienController {
//	
//	@Autowired
//	AlienRepo repo;
//	
//	@RequestMapping("/")
//	public String home() {
//		return "home.jsp";
//	}
//	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
//<---------------commented for rest POST part 8-------------->}}}}


	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien( @RequestParam int aid) {
//		
//		
//		ModelAndView mv = new ModelAndView("ShowAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
		
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("java"));
		
		//mv.addObject(alien);
		
		//return mv;
	
	//<----------------------------------REST API------------------------------------------------>
	//->For REST API we don't need this(@RequestMapping("/getAlien")) and also modelview
//	@RequestMapping("/aliens")
//	@ResponseBody
//	public String getAliens( ){
//		
//		return repo.findAll().toString();
//	}
//	
//	//1 @RequestMapping("/alien/102")
//	@RequestMapping("/alien/{aid}") //Put id in wild card
//	@ResponseBody
//	//1 public String getAlien( ){
//	public String getAlien(@PathVariable("aid")int aid ){
//		
//		return repo.findById(aid).toString();
//	}	
//<----------------------------------------REST API------------------>



//{{{{<---------------commented for rest POST part 8-------------->

//	//To convert Response in  JSON format
//	@RequestMapping("/aliens")
//	@ResponseBody
//	public List<Alien> getAliens( ){
//		
//		return repo.findAll();
//	}
//	
//	
//	@RequestMapping("/alien/{aid}") //Put id in wild card insteat of writing of this ("/alien/102")
//	@ResponseBody
//	public Optional<Alien> getAlien(@PathVariable("aid")int aid ){
//		
//		return repo.findById(aid);
//	}
//	
//
//}
//<---------------commented for rest POST part 8-------------->}}}}


//<---------------------REST-POST--part-8---------->
					//We don't need to write @ResponseBody  every time// instead of using controller we will use @RestController
@RestController			//@RestController simply means that all the method working for rest it will sending json or xml response
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
	
	
	//{{{{<-------------DELETE METHOD-------------------------->
	
	
	@DeleteMapping("/alien/{aid}")
	public String deletedAlien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	//-------------------------------------------------------->
	
	
	//{{{{<-------------POST METHOD-------------------------->
	
	//When server is accepting data from  client that is consume
	//@PostMapping("/alien")								//url will be alien instead of addAlien
	@PostMapping(path="/alien",consumes= {"application/json"})//what type of data we want to accept consumes= {"application/json"}
	public Alien addAlien(@RequestBody Alien alien) {	//When we are sending as raw data which is JSON we have to use special---
		repo.save(alien);								//--annotation called as @RequestBody just to enable it.
		return alien;
	}
	
	//--------------------------------------------------------------}}}}
	
	
	
	
	//{{{{<-------------GET METHOD-------------------------->
	//When we are send data from server to client so server is producing so that is a produce
	
	@GetMapping("/aliens")
	//@ResponseBody
	public List<Alien> getAliens( ){
		
		return repo.findAll();
	}
	
	
	@RequestMapping("/alien/{aid}") //Put id in wild card instead of writing of this ("/alien/102")
	//@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid")int aid ){
		
		return repo.findById(aid);
	}
	
	//----------------------------------------------}}}}
	
	
	
	
	
	//{{{{<-------------PUT METHOD-------------------------->
	@PutMapping(path="/alien",consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {	
		repo.save(alien);								
		return alien;
	}
	//---------------------------------------------------------}}}}

}