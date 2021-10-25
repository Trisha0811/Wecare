package com.wecare.Controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.wecare.Dto.AppointmentDto;
import com.wecare.Dto.BookingDto;
import com.wecare.Exception.WecareException;
import com.wecare.Service.BookingService;
@RestController
@CrossOrigin
public class BookingController {
@Autowired
BookingService service;
@PostMapping("/users/{userId}/booking/{coachId}")
public ResponseEntity<Boolean> bookAppointment(@PathVariable("userId") String userId, @PathVariable("coachId") String coachId, @RequestBody AppointmentDto dto ) throws WecareException
{
return ResponseEntity.ok(service.bookAppointment(userId,coachId,dto));
}

@PatchMapping("/booking/{bookingId}")
public ResponseEntity<Boolean> rescheduleAppointment(@PathVariable("bookingId") int bookingid,@RequestBody AppointmentDto dto) throws WecareException
{
return ResponseEntity.ok(service.rescheduleAppointment(bookingid,dto));
}

@DeleteMapping("/booking/{bookingId}")
public ResponseEntity<?> cancelAppointment(@PathVariable("bookingId") int bookingId)
{
service.cancelAppointment(bookingId);
return (ResponseEntity<?>) ResponseEntity.ok();
}
@GetMapping("/booking/{coachId}")
public List<BookingDto> findBookingByCoachId(@PathVariable("coachId") String coachId){
return service.findBookingByCoachId(coachId);
}
@GetMapping("/users/booking/{userId}")
public List<BookingDto> findBookingByUserId(@PathVariable("userId") String userId){
return service.findBookingByUserId(userId);
}
}