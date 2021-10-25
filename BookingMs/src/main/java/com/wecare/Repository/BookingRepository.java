package com.wecare.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecare.Entity.BookingEntity;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer>{
//@Query("SELECT t FROM RouteEntity t WHERE t.source=?1 AND t.destination=?2")
@Query("SELECT b FROM BookingEntity b WHERE b.coach_id=?1")
List<BookingEntity> findByCoach_id(String cId);
@Query("SELECT b FROM BookingEntity b WHERE b.user_id=?1")
List<BookingEntity> findByUser_id(String uId);
}