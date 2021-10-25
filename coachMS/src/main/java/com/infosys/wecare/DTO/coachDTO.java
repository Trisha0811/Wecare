package com.infosys.wecare.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.infosys.wecare.entity.Coach;

public class coachDTO {
	
	private String coach_id;
	@NotNull
	@Size(min=3,max=50)
	private String name;
	private String gender;
	private LocalDate date_of_birth;
	@NotNull
	@Size(min=5,max=10)
	private String password;
	@NotNull
	private long mobile_number;
	@NotNull
	@Size(min=3,max=50)
	private String speciality;
	public coachDTO() {
		super();
	}
	public coachDTO(String coach_id, String name, String gender, LocalDate date_of_birth, String password,
			long mobile_number, String speciality) {
		super();
		this.coach_id = coach_id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.password = password;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}
	public String getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(String coach_id) {
		this.coach_id = coach_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	@Override
	public String toString() {
		return "coachDTO [coach_id=" + coach_id + ", name=" + name + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", password=" + password + ", mobile_number=" + mobile_number + ", speciality="
				+ speciality + "]";
	}
	public static Coach preareEntity(coachDTO dto)
	{
		Coach coach=new Coach();
		coach.setCoach_id(dto.getCoach_id());
		coach.setName(dto.getName());
		coach.setGender(dto.getGender());
		coach.setDate_of_birth(dto.getDate_of_birth());
		coach.setPassword(dto.getPassword());
		coach.setMobile_number(dto.getMobile_number());
		coach.setSpeciality(dto.getSpeciality());
		return coach;
	}
	public static coachDTO prepareDTO(Coach coach)
	{
		coachDTO dto=new coachDTO();
		dto.setCoach_id(coach.getCoach_id());
		dto.setName(coach.getName());
		dto.setGender(coach.getGender());
		dto.setDate_of_birth(coach.getDate_of_birth());
		dto.setPassword(coach.getPassword());
		dto.setMobile_number(coach.getMobile_number());
		dto.setSpeciality(coach.getSpeciality());
		return dto;
		
	}

}
