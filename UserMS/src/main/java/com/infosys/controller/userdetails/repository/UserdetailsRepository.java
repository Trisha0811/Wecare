package com.infosys.controller.userdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.controller.userdetails.entity.UserEntity;



public interface UserdetailsRepository extends JpaRepository<UserEntity, String> {

}
