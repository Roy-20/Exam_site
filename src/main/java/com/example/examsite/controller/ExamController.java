package com.example.examsite.controller;

import com.example.examsite.forms.Exam;
import com.example.examsite.models.ExamModel;
import com.example.examsite.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;
    @GetMapping("/exam")
    public String getExam(Model model){
        model.addAttribute("examForm",new Exam());
        return "exam";
    }
    @PostMapping("/createExam")
    public String addExam(@ModelAttribute Exam examForm){
        ExamModel exam=new ExamModel();
        exam.setExamId(examForm.getExamId());
        exam.setExamName(examForm.getExamName());
        exam.setDescription(examForm.getDescription());
        exam.setMarks(examForm.getMarks());
        exam.setTotalQuestions(examForm.getTotalQuestions());
        examRepository.save(exam);
        return "home";
    }
    @GetMapping("/updateExam")
    public String updateExam(@RequestParam String examId,@ModelAttribute Exam examForm){
        final ExamModel exam=examRepository.findByexamId(examId);
        exam.setExamId(examForm.getExamId());
        exam.setExamName(examForm.getExamName());
        exam.setMarks(exam.getMarks());
        exam.setDescription(examForm.getDescription());
        exam.setTotalQuestions(examForm.getTotalQuestions());
        examRepository.save(exam);
        return "home";
    }
    @DeleteMapping("/deleteExam")
    public String deleteExam(@ModelAttribute Exam examForm){
        final ExamModel exam=examRepository.findByexamId(examForm.getExamId());
        this.examRepository.delete(exam);
        return "home";
    }
    @GetMapping("/examList")
    public String getAllExams(Model model){
        populateAllExamPage(model);
        return "allExams";
    }
    private void populateAllExamPage(Model model){
        List<ExamModel> exam=examRepository.findAll();
        List<Exam> examList=new ArrayList<>();
        for (ExamModel ex:exam){
            Exam form=new Exam();
            form.setDescription(ex.getDescription());
            form.setExamId(ex.getExamId());
            form.setExamName(ex.getExamName());
            form.setMarks(ex.getMarks());
            form.setTotalQuestions(ex.getTotalQuestions());
            examList.add(form);
        }
        model.addAttribute("examforms",examList);
        model.addAttribute("form1",new Exam());
    }
}
