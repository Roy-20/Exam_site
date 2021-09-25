package com.example.examsite.repository;

import com.example.examsite.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel,Integer> {
    TeacherModel findByEmail(String email);
}
