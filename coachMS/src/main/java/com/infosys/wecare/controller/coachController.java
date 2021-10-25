package com.infosys.wecare.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.wecare.DTO.LoginDTO;
import com.infosys.wecare.DTO.coachDTO;
import com.infosys.wecare.service.coachServiceImpl;
import com.infosys.wecare.Exceptions.CoachIdNotExist;
import com.infosys.wecare.Exceptions.ErrorMessage;

@RestController
@CrossOrigin
public class coachController {
@Autowired
coachServiceImpl ser;
@PostMapping(path="coaches")
public ResponseEntity createCoach(@Valid @RequestBody coachDTO dto,Errors errors) {
	String response = "";
	if (errors.hasErrors()) 
	{			
		response  = errors.getAllErrors().stream().
				map(x->x.getDefaultMessage()).
					collect(Collectors.joining(","));
		ErrorMessage error = new ErrorMessage();
	    error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
	    error.setMessage(response);
	    return ResponseEntity.ok(error);
	}
	else
	return ResponseEntity.ok(ser.createCoach(dto));
}
@GetMapping("coaches/{coachId}")
public ResponseEntity<coachDTO> getCoachProfile(@PathVariable("coachId") String cid) throws CoachIdNotExist{
	return ResponseEntity.ok(ser.getCoachProfile(cid));
	
}
@GetMapping("coaches/all")
public List<coachDTO> showAllCoaches(){
	return ser.showAllCoaches();
}
@PostMapping("coaches/login")
public ResponseEntity<Boolean> loginCoach(@RequestBody LoginDTO loginDTO){
	return ResponseEntity.ok(ser.loginCoach(loginDTO));
}
}
