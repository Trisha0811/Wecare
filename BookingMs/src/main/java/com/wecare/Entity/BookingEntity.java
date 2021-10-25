package com.wecare.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="booking")
public class BookingEntity {


@Id
@GeneratedValue(generator="sequence-generator")
@GenericGenerator(name="sequence-generator",strategy="org.hibernate.id.enhanced.SequenceStyleGenerator",
parameters= {
@Parameter(name="sequence_name",value="user_sequence"),
@Parameter(name="initial_value",value="1"),
@Parameter(name="increment_size",value="1")
})
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
public BookingEntity() {
super();
}


}