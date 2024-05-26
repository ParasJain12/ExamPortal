package com.examportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.Model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
