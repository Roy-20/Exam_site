package com.example.examsite.controller;

import com.example.examsite.forms.TeacherSignup;
import com.example.examsite.models.TeacherModel;
import com.example.examsite.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("/signup")
    public String getRegistration(Model model){
        model.addAttribute("registerForm",new TeacherSignup());
        return "teacherRegistration";
    }
    @PostMapping("/teacherRegister")
    public String submitRegistration1(@ModelAttribute TeacherSignup teacherSignup, Model model){
        if(!teacherSignup.getPassword().equals(teacherSignup.getReTypePassword())) {
            model.addAttribute("passwordError","NOT_EQUAL");
            model.addAttribute("registerForm",new TeacherSignup());
            return "teacherRegistration";
        }
        TeacherModel teacherModel =new TeacherModel();
        teacherModel.setFirstName(teacherModel.getFirstName());
        teacherModel.setMiddleName(teacherModel.getMiddleName());
        teacherModel.setLastName(teacherModel.getLastName());
        teacherModel.setEmail(teacherModel.getEmail());
        teacherModel.setDateOfBirth(teacherModel.getDateOfBirth());
        teacherModel.setGender(teacherModel.getGender());
        teacherModel.setPassword(teacherModel.getPassword());
        teacherModel.setPhoneNumber(teacherModel.getPhoneNumber());
        teacherModel.setName(teacherModel.getFirstName() + " " + teacherModel.getMiddleName() + " " +teacherModel.getLastName());
        try {
            teacherRepository.save(teacherModel);
        }catch (Exception e){
            model.addAttribute("regError","exits");
            model.addAttribute("registerForm",new TeacherSignup());
        }
        return "teacherRegistration";
//        final RegistrationForm2 registrationForm2 = new RegistrationForm2();
//        registrationForm2.setEmail(registrationForm1.getEmail());
//        model.addAttribute("registerForm2", registrationForm2);
//        return "registrationPage2";
    }
}
