package com.example.mypkg.Payload.Request;

import com.example.mypkg.Model.Appointment;

import javax.persistence.*;

@Entity
public class PrescriptionRequest {
    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    private String description;


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
