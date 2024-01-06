package com.services.schoolmates.repository;
import com.services.schoolmates.entity.Schoolmate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolmateRepository extends JpaRepository<Schoolmate, Long> {
}
