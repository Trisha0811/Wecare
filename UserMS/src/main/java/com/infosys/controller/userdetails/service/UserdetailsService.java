package com.infosys.controller.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.controller.userdetails.dto.LoginDTO;
import com.infosys.controller.userdetails.dto.UserdetailsDTO;
import com.infosys.controller.userdetails.entity.UserEntity;
import com.infosys.controller.userdetails.exception.UserIdNotExist;
import com.infosys.controller.userdetails.repository.UserdetailsRepository;

import com.infosys.controller.util.UserConstants;

import antlr.collections.List;


@Service
@PropertySource("classpath:ValidationMessages.properties")
public class UserdetailsService {
	
	@Autowired
	public UserdetailsRepository userRepo;
	
	private Environment environment;
	public String createUser(UserdetailsDTO userDTO)
	{
		UserEntity user=new UserEntity();
		userRepo.save(userDTO.createEntity());
		return userDTO.getUserId();
		
	}
	
//	public UserdetailsDTO getUser(){
//		List<UserEntity> user = userRepo.findAll();
//		
//		List<UserdetailsDTO> userDTOs=new UserdetailsDTO();
//		
//		UserdetailsDTO userDTO=UserdetailsDTO.valueOf(user);
//		
//		return userDTO;
//	}
	// Login
	
		public boolean login(LoginDTO loginDTO) {
			//logger.info("Login request for customer {} with password {}", loginDTO.getPhoneNo(),loginDTO.getPassword());
			UserEntity user = userRepo.findById(loginDTO.getUserId()).get();
			if (user != null && user.getPassword().equals(loginDTO.getPassword())  ) {
				return true;
			}
			return false;
		}

	// Fetches full profile of a specific customer
	
		public UserdetailsDTO getUserProfile(String userId)throws UserIdNotExist {

			
				UserEntity user = userRepo.findById(userId).get();
				UserdetailsDTO userDTO=UserdetailsDTO.valueOf(user);
				
				if(user==null)
					throw new UserIdNotExist(environment.getProperty(UserConstants.USERID_NOT_FOUND.toString()));
				else
				 return userDTO;
		}
//			logger.info("Profile request for customer {}", phoneNo);
//			Customer cust = custRepo.findById(phoneNo).get();
//			CustomerDTO custDTO = CustomerDTO.valueOf(cust);
//
//			logger.info("Profile for customer : {}", custDTO);
//			return custDTO;
//		}

}
