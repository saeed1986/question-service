package com.example.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data    // for lombok
@Entity //  We want this table to get mapped with the class

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This Id should auto generated
    private Integer id; // id is primary key
    private String questionText; // ORM takes care of it. it means camel case here (questionTitle) is equal to question_title (snake_case) in SQL
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
