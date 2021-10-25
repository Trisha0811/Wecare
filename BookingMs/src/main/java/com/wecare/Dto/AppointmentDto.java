package com.wecare.Dto;

import java.time.LocalDate;

public class AppointmentDto {
private LocalDate appointment_date;

private String slot;

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
return "AppointmentDto [appointment_date=" + appointment_date + ", slot=" + slot + "]";
}


}