package com.example.mypkg.Repository;

import com.example.mypkg.Model.Pathologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologistRepository extends JpaRepository<Pathologist, Integer> {
	
}
