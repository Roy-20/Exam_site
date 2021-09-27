package com.example.examsite.controller;

import com.example.examsite.forms.Exam;
import com.example.examsite.models.ExamModel;
import com.example.examsite.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;
    @GetMapping("/Exam")
    public String getExam(){
        return "exam";
    }
    @PostMapping
    public String addExam(@ModelAttribute Exam examForm){
        ExamModel exam=new ExamModel();
        exam.setExamId(examForm.getExamId());
        return "home";
    }
    @DeleteMapping("/remove")
    public String deleteExam(@ModelAttribute Exam examForm, Model model){
        final ExamModel exam=examRepository.findById(examForm.getExamId());
        this.examRepository.delete(exam);
        return "home";
    }
}
