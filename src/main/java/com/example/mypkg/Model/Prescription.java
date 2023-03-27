package com.example.mypkg.Model;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Prescription {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription prescription = (Prescription) o;
        return  Objects.equals(id, prescription.id)  && Objects.equals(description, prescription.description)  &&  Objects.equals(appointment, prescription.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,  appointment, description);
    }
}
