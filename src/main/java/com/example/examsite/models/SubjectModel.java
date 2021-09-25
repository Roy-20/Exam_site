package com.example.examsite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class SubjectModel extends BaseEntity {

    private String subjectName;
    private String subjectCode;
    private String subjectID;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public ExamModel getExam() {
        return exam;
    }

    public void setExam(ExamModel exam) {
        this.exam = exam;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @OneToMany(mappedBy = "subject",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuestionModel> question;

    @ManyToOne(fetch = FetchType.LAZY)
    private ExamModel exam;

    public List<QuestionModel> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionModel> question) {
        this.question = question;
    }
}
