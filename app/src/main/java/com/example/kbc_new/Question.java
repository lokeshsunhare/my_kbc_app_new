package com.example.kbc_new;

import java.util.List;

public class Question {
    private int questionId;
    private String questionText;
    private List<Option> optionList;
    private int correctOption;
    private int giveOption;

    public Question(int questionId, String questionText, List<Option> optionList, int correctOption) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.optionList = optionList;
        this.correctOption = correctOption;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(int correctOption) {
        this.correctOption = correctOption;
    }

    public int getGiveOption() {
        return giveOption;
    }

    public void setGiveOption(int giveOption) {
        this.giveOption = giveOption;
    }
}
