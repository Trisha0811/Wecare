package com.infosys.wecare.service;

import java.util.List;

import com.infosys.wecare.DTO.LoginDTO;
import com.infosys.wecare.DTO.coachDTO;
import com.infosys.wecare.Exceptions.CoachIdNotExist;

public interface coachService {
public String createCoach(coachDTO dto);
public coachDTO getCoachProfile(String coachId) throws CoachIdNotExist;
public List<coachDTO> showAllCoaches();
public Boolean loginCoach(LoginDTO loginDTO);
}
