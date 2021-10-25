package com.wecare.Dto;

import java.time.LocalDate;


import com.wecare.Entity.BookingEntity;

public class BookingDto {
private int booking_id;

private String user_id;

private String coach_id;

private LocalDate appointment_date;

private String slot;

public int getBooking_id() {
return booking_id;
}

public void setBooking_id(int booking_id) {
this.booking_id = booking_id;
}

public String getUser_id() {
return user_id;
}

public void setUser_id(String user_id) {
this.user_id = user_id;
}

public String getCoach_id() {
return coach_id;
}

public void setCoach_id(String coach_id) {
this.coach_id = coach_id;
}

public LocalDate getAppointment_date() {
return appointment_date;
}

public void setAppointment_date(LocalDate appointment_date) {
this.appointment_date = appointment_date;
}

public String getSlot() {
return slot;
}

public void setSlot(String slot) {
this.slot = slot;
}

@Override
public String toString() {
return "BookingDto [booking_id=" + booking_id + ", user_id=" + user_id + ", coach_id=" + coach_id
+ ", appointment_date=" + appointment_date + ", slot=" + slot + "]";
}

public  BookingEntity prepareEntity() {
BookingEntity b=new BookingEntity();
b.setBooking_id(this.getBooking_id());
b.setUser_id(this.getUser_id());
b.setCoach_id(this.getCoach_id());
b.setAppointment_date(this.getAppointment_date());
b.setSlot(this.getSlot());
return b;
}
public static BookingDto prepareDto(BookingEntity e) {
BookingDto dto=new BookingDto();
dto.setUser_id(e.getUser_id());
dto.setCoach_id(e.getCoach_id());
dto.setBooking_id(e.getBooking_id());
dto.setAppointment_date(e.getAppointment_date());
dto.setSlot(e.getSlot());
return dto;

}

}