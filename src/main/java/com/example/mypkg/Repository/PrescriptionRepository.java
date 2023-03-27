package com.example.mypkg.Repository;

import com.example.mypkg.Model.Patient;
import com.example.mypkg.Model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    public List<Prescription> findPrescriptionByPatient(Patient patient);

}
