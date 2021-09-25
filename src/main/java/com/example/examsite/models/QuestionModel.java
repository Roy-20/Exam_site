package com.example.examsite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionModel extends BaseEntity{
    private String content;
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionModel> options;
    @ManyToOne(fetch = FetchType.LAZY)
    private SubjectModel subject;
    private String questionID;
    private double marks;

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

    public List<OptionModel> getOptions() {
        return options;
    }

    public void setOptions(List<OptionModel> options) {
        this.options = options;
    }
}
