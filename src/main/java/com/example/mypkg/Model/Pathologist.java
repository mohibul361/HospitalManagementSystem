package com.example.mypkg.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Pathologist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String department;
    private double salary;

    public Pathologist(){}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Pathologist{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pathologist pathologist = (Pathologist) o;
        return Double.compare(pathologist.salary, salary) == 0 && Objects.equals(id, pathologist.id) && Objects.equals(firstName, pathologist.firstName) && Objects.equals(lastname, pathologist.lastname) && Objects.equals(phoneNumber, pathologist.phoneNumber) && Objects.equals(email, pathologist.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, phoneNumber, email, department, salary);
    }
}
