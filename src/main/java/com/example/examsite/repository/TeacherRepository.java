package com.example.examsite.repository;

import com.example.examsite.models.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<TeacherModel,Long> {
    TeacherModel findByEmail(String email);
}
