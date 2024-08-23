package com.example.question_service.controller;

import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired // We got an object with this annotation
    QuestionService questionService;
    @GetMapping("allQuestions") // with allquestion does not work
    public ResponseEntity<List<Question>> getAllQuestions(){ // most of the time you will have the same method names
        return questionService.getAllQuestions();
    }

    // it does n't work and there is an issue here
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    // It does not work
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String category, @RequestParam Integer numQuestions) {
        return questionService.getQuestionsForQuiz(category, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId() {
        public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsId) {
            return questionService.getQuestionsFromId();
        }
    }
    // generate
    // getQuestions (questionId)
    // getScore

}
