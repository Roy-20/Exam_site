package com.example.examsite.controller;

import com.example.examsite.forms.Question;
import com.example.examsite.models.QuestionModel;
import com.example.examsite.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    @GetMapping("/question")
    public String getQuestion(Model model){
        model.addAttribute("questionForm",new Question());
        return "question";
    }
    @PostMapping("/submitQuestion")
    public String createQuestions(@ModelAttribute Question question){
        QuestionModel questions=new QuestionModel();
        questions.setContent(question.getContent());
        questions.setAnswer(question.getAnswer());
        questions.setMarks(question.getMarks());
        questions.setQuestionID(question.getQuestionId());
        questionRepository.save(questions);
        return "home";
    }
    @PutMapping("/updateQuestion")
    public String updateQuestion(@ModelAttribute Question questionForm){
        final QuestionModel question=questionRepository.findByquestionID(questionForm.getQuestionId());
        question.setContent(questionForm.getContent());
        question.setAnswer(questionForm.getAnswer());
        question.setMarks(questionForm.getMarks());
        question.setQuestionID(questionForm.getQuestionId());
        questionRepository.save(question);
        return "home";
    }
    @DeleteMapping("/deleteQuestion")
    public String deleteQuestion(@ModelAttribute Question questionForm){
        final QuestionModel question=questionRepository.findByquestionID(questionForm.getQuestionId());
        this.questionRepository.delete(question);
        return "home";
    }
}
