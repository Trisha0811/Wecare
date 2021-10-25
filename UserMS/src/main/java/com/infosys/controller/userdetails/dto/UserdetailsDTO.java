package com.infosys.controller.userdetails.dto;

import java.time.LocalDate;



import com.infosys.controller.userdetails.entity.UserEntity;
import com.sun.istack.NotNull;



public class UserdetailsDTO {

	String coachid;
    String user_id;
	@NotNull
	
	String name;
	String gender;
	@NotNull
	
	String password;
	LocalDate date_of_birth;
	@NotNull
	long mobile_number;
	String email;
	int pincode;
	String city;
	String state;
	String country;
	
	
	
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String userId) {
		this.user_id = userId;
	}
	public String getCoachid() {
		return coachid;
	}
	public void setCoachid(String coachid) {
		this.coachid = coachid;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDateOfBirth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getmobile_number() {
		return mobile_number;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobile_number = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public UserdetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserdetailsDTO(String coachid, String password, String name, LocalDate dateOfBirth, String gender,
			long mobileNumber, String email, int pincode, String city, String state, String country) {
		super();
		this.coachid = coachid;
		this.password = password;
		this.name = name;
		this.date_of_birth = dateOfBirth;
		this.gender = gender;
		this.mobile_number = mobileNumber;
		this.email = email;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
	
	@Override
	public String toString() {
		return "UserdetailsDTO [coachid=" + coachid + ", userId=" + user_id + ", name=" + name + ", gender=" + gender
				+ ", password=" + password + ", dateOfBirth=" + date_of_birth + ", mobileNumber=" + mobile_number
				+ ", email=" + email + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
			// Converts Entity into DTO
			public static UserdetailsDTO valueOf(UserEntity user) {
				UserdetailsDTO userDTO=new UserdetailsDTO();
				
			//	userDTO.setCoachid();
				userDTO.setUserId(user.getUserId());
				userDTO.setName(user.getName());
				userDTO.setGender(user.getGender());
				userDTO.setDateOfBirth(user.getDateOfBirth());
				userDTO.setPassword(user.getPassword());
				userDTO.setMobileNumber(user.getMobileNumber());
				userDTO.setEmail(user.getEmail());
				userDTO.setPincode(user.getPincode());
				userDTO.setCity(user.getCity());
				userDTO.setState(user.getState());
				userDTO.setCountry(user.getCountry());
//				CustomerDTO custDTO = new CustomerDTO();
//				custDTO.setAge(cust.getAge());
//				custDTO.setGender(cust.getGender());
//				custDTO.setName(cust.getName());
//				custDTO.setPhoneNo(cust.getPhoneNo());
//				custDTO.setAddress(cust.getAddress());
//				PlanDTO planDTO = new PlanDTO();
//				planDTO.setPlanId(cust.getPlanId());
//				custDTO.setCurrentPlan(planDTO);
//				custDTO.setCurrentPlan(planDTO);
				
				
				
				return userDTO;
			}

			// Converts DTO into Entity
			public UserEntity createEntity() {
				UserEntity user = new UserEntity();
				
				user.setName(this.getName());
				user.setCity(this.getCity());
				user.setCountry(this.getCountry());
				user.setDateOfBirth(this.getDate_of_birth());
				user.setMobileNumber(this.getmobile_number());
				user.setPassword(this.getPassword());
				user.setPincode(this.getPincode());
				user.setGender(this.getGender());
				user.setEmail(this.getEmail());
				user.setState(this.getState());
//				cust.setAge(this.getAge());
//				cust.setGender(this.getGender());
//				cust.setName(this.getName());
//				cust.setPhoneNo(this.getPhoneNo());
//				cust.setAddress(this.getAddress());
//				cust.setPassword(this.getPassword());
//				cust.setPlanId(this.getCurrentPlan().planId);
//				return cust;
				
				return user;
			}
}
