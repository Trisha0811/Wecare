package com.infosys.wecare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infosys.wecare.DTO.LoginDTO;
import com.infosys.wecare.DTO.coachDTO;
import com.infosys.wecare.Exceptions.CoachIdNotExist;
import com.infosys.wecare.entity.Coach;
import com.infosys.wecare.repo.coachRepo;
import com.infosys.wecare.util.CoachConstants;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class coachServiceImpl implements coachService{
@Autowired
coachRepo repo;
@Autowired
private Environment environment;
	@Override
	public String createCoach(coachDTO dto) {
		Coach coach=new Coach();
		coach=coachDTO.preareEntity(dto);
		repo.save(coach);
		return coach.getCoach_id();
		
		
	}
	@Override
	public coachDTO getCoachProfile(String coachId) throws CoachIdNotExist{
		Coach coach=new Coach();
		coach=repo.getById(coachId);
		if(coach==null)
			throw new CoachIdNotExist(environment.getProperty(CoachConstants.COACHID_NOT_FOUND.toString()));
		else
		{
		coachDTO dto=coachDTO.prepareDTO(coach);
		return dto;
		}
	}
	@Override
	public List<coachDTO> showAllCoaches() {
		List<Coach> coachlist=new ArrayList<>();
		List<coachDTO> dtolist=new ArrayList<>();
		coachlist=repo.findAll();
		for(Coach c:coachlist) {
			dtolist.add(coachDTO.prepareDTO(c));
		}
		return dtolist;
	}
	@Override
	public Boolean loginCoach(LoginDTO loginDTO) {
		Coach coach=repo.getById(loginDTO.getCoach_id());
		String lpassword=loginDTO.getPassword();
		String cpassword=coach.getPassword();
		if(lpassword.equals(cpassword))
		{
			return true;
		}
		return false;
	}
	

}
