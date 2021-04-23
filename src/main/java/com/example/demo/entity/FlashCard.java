package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="flashcard")
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "question")
    private String Question;
    @Column(name = "answer")
    private String Answer;

    public FlashCard(String question, String answer) {
        Question = question;
        Answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + id +
                ", Question='" + Question + '\'' +
                ", Answer='" + Answer + '\'' +
                '}';
    }
}
