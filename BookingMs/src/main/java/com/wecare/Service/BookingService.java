package com.wecare.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.wecare.Dto.AppointmentDto;
import com.wecare.Dto.BookingDto;
import com.wecare.Entity.BookingEntity;
import com.wecare.Exception.ExceptionConstants;
import com.wecare.Exception.WecareException;
import com.wecare.Repository.BookingRepository;

@Service
@PropertySource("classpath:VaildationMessages.properties")
public class BookingService {

@Autowired
BookingRepository repo;
@Autowired
private Environment environment;

public boolean bookAppointment(String userId, String coachId, AppointmentDto dto) throws WecareException {

List<BookingEntity> be=repo.findByUser_id(userId);

for(BookingEntity b:be) {
if(b.getSlot().equals(dto.getSlot()))  {
if(b.getAppointment_date().compareTo(dto.getAppointment_date())==0){
throw new WecareException(environment.getProperty(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString()));
}
}
}
BookingEntity be1=new BookingEntity();
be1.setUser_id(userId);
be1.setCoach_id(coachId);
be1.setAppointment_date(dto.getAppointment_date());
be1.setSlot(dto.getSlot());
repo.saveAndFlush(be1);
return true;

}
public boolean rescheduleAppointment(Integer bookingId, AppointmentDto dto) throws WecareException {
BookingEntity b=repo.getById(bookingId);
List<BookingEntity> bl=repo.findByUser_id(b.getUser_id());
for(BookingEntity be:bl) {
if(be.getSlot().equals(dto.getSlot())) {
if(be.getAppointment_date().compareTo(dto.getAppointment_date())==0) {
throw new WecareException(environment.getProperty(ExceptionConstants.BOOKING_ALREADY_EXISTS.toString()));
}
}
}
b.setAppointment_date(dto.getAppointment_date());
b.setSlot(dto.getSlot());
repo.saveAndFlush(b);
return true;
}
public void cancelAppointment(Integer bookingId) {
repo.deleteById(bookingId);

}
public BookingDto findByBookingId(Integer bookingId) {
return BookingDto.prepareDto(repo.findById(bookingId).get());
}

public List<BookingDto> findBookingByUserId(String userId){
List<BookingEntity> be=repo.findByUser_id(userId);
List<BookingDto> dto=new ArrayList<>();
for(BookingEntity b:be) {
dto.add(BookingDto.prepareDto(b));

}
return dto;

}

public List<BookingDto> findBookingByCoachId(String coachId)
{
List<BookingEntity> be=repo.findByCoach_id(coachId);
List<BookingDto> dto=new ArrayList<>();
for(BookingEntity b:be) {
dto.add(BookingDto.prepareDto(b));

}
return dto;
}
}

