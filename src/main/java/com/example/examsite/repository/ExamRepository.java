package com.example.examsite.repository;

import com.example.examsite.models.ExamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamModel,Integer> {
    ExamModel findById(String examId);
}
