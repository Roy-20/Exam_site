package com.example.examsite.controller;

import com.example.examsite.forms.Subject;
import com.example.examsite.models.SubjectModel;
import com.example.examsite.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;
    @GetMapping("/subject")
    public String getSubject(Model model){
        model.addAttribute("subjectForm",new Subject());
        return "subject";
    }
    @PostMapping("/createSubject")
    public String addSubject(@ModelAttribute Subject subjectForm) {
        SubjectModel subject=new SubjectModel();
        subject.setSubjectID(subjectForm.getSubjectID());
        subject.setSubjectCode(subjectForm.getSubjectCode());
        subject.setSubjectName(subjectForm.getSubjectName());
        subjectRepository.save(subject);
        return "home";
    }
    @PutMapping("/updateSubject")
    public String updateSubject(@ModelAttribute Subject subjectForm){
        final SubjectModel subject=subjectRepository.findBysubjectID(subjectForm.getSubjectID());
        subject.setSubjectCode(subjectForm.getSubjectCode());
        subject.setSubjectName(subjectForm.getSubjectName());
        subject.setSubjectID(subjectForm.getSubjectID());
        subjectRepository.save(subject);
        return "home";
    }
    @DeleteMapping("/deleteSubject")
    public String deleteSubject(@ModelAttribute Subject subjectForm){
        final SubjectModel subject=subjectRepository.findBysubjectID(subjectForm.getSubjectID());
        this.subjectRepository.delete(subject);
        return "home";
    }
}
