package com.example.examsite.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "options")
public class OptionModel extends BaseEntity{
    private String content;
    private boolean isCorrect;
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionModel question;
    private String optionId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public QuestionModel getQuestion() {
        return question;
    }

    public void setQuestion(QuestionModel question) {
        this.question = question;
    }
}
