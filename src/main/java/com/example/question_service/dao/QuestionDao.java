package com.example.question_service.dao;

import com.example.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// here is a magic and with this extends can we get more features. here it should given class or table name and primary key type

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findAllById(int id);

    List<Question> findByCategory(String category);

    // Native query added to connect with database
    // @Query(value= "", nativeQuery = true)
    // I write JPQL Query and i want to fetch the query from the question table
    // : to specify the value
    // ORDER BY RANDOM() is an inbuilt function
    @Query(value = "SELECT q.id FROM question q where q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
