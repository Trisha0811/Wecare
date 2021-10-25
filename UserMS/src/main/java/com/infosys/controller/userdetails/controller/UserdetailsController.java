package com.infosys.controller.userdetails.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.controller.userdetails.dto.LoginDTO;
import com.infosys.controller.userdetails.dto.UserdetailsDTO;
import com.infosys.controller.userdetails.exception.ErrorMessage;
import com.infosys.controller.userdetails.exception.UserIdNotExist;
import com.infosys.controller.userdetails.service.UserdetailsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserdetailsController {
	
	@Autowired
	private UserdetailsService userdetailsService ;
	@GetMapping
	public String fetchCustomer()
	{
		//This method will fetch the customers of Infytel and return the same. 
		return "user fetched successfully";
	}

	@PostMapping
	public ResponseEntity createUser( @RequestBody UserdetailsDTO userDTO,Errors errors)
	{
		System.out.println("99999999999999999999999999999999");
		System.out.println(userDTO);		System.out.println(userDTO.toString());
		
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
		{
			
			return ResponseEntity.ok(userdetailsService.createUser(userDTO));
		}
		
	}
	
	
	// Login
		@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public boolean login(@RequestBody LoginDTO loginDTO) {
			//logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
			
			//return custService.login(loginDTO);
			return userdetailsService.login(loginDTO);
		}

		
		//fetch full profile of a specific user
		@RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UserdetailsDTO> getUserProfile(@PathVariable String userId) throws UserIdNotExist
		{
			UserdetailsDTO userDTO=userdetailsService.getUserProfile(userId);
			return  ResponseEntity.ok(userDTO);
		}
//		// Fetches full profile of a specific customer
//		@RequestMapping(value = "/customers/{phoneNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//		public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) throws InterruptedException, ExecutionException {
//			long overAllStart=System.currentTimeMillis();
//			logger.info("Profile request for customer {}", phoneNo);
//		
//			CustomerDTO custDTO=custService.getCustomerProfile(phoneNo);
//			long planStart=System.currentTimeMillis();
//			Future<PlanDTO> planDTOFuture=hystService.getSpecificPlans(custDTO.getCurrentPlan().getPlanId());
//			long planStop=System.currentTimeMillis();
//			
//			
//			
//			long friendStart=System.currentTimeMillis();
//			Future<List<Long>> friendsFuture=hystService.getFriends(phoneNo);
//			long friendStop=System.currentTimeMillis();
//			
//			long overAllStop=System.currentTimeMillis();
//			
//			custDTO.setCurrentPlan(planDTOFuture.get());
//			custDTO.setFriendAndFamily(friendsFuture.get());
//			
//			System.out.println("Total time for Plan "+(planStop-planStart));
//			System.out.println("Total time for Friend "+(friendStop-friendStart));
//			System.out.println("Total Overall time for request "+(overAllStop-overAllStart));
//			return custDTO;
//
//		}
//	
		
		
		@RequestMapping(value = "/booking/{id}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
		public String showMyAppointments(@PathVariable("id") Long userId)
		{
			String url="";//booking url here
			
			@SuppressWarnings("unchecked")
			String msg=new RestTemplate().getForObject(url+userId,String.class);
			
			return msg;
		}
		
}
