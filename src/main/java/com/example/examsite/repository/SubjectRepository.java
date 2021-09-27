package com.example.examsite.repository;

import com.example.examsite.models.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectModel,Integer> {
}
