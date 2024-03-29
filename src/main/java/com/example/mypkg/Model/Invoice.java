package com.example.mypkg.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    private double totalAmount;

    public Invoice(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", totalAmount=" + totalAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.totalAmount, totalAmount) == 0 && Objects.equals(id, invoice.id)  && Objects.equals(appointment, invoice.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointment,  totalAmount);
    }
}