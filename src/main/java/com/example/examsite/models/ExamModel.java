package com.example.examsite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam")
public class ExamModel extends BaseEntity{
    @Column(unique = true)
    private String examId;
    private String examName;
    private String description;
    private double marks;
    private int totalQuestions;

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectModel> subjects;

    public List<SubjectModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectModel> subjects) {
        this.subjects = subjects;
    }
}
