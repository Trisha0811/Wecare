package com.infosys.wecare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infosys.wecare.entity.*;
@Repository
public interface coachRepo extends JpaRepository<Coach,String> {

}
