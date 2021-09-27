package com.example.examsite.repository;

import com.example.examsite.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel,Integer> {
}
