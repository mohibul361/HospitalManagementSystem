package com.example.mypkg.Payload.Request;

import com.example.mypkg.Model.Appointment;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class InvoiceRequest {
    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;


    private double totalAmount;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
