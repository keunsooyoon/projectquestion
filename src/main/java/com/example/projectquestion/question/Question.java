package com.example.projectquestion.question;

import java.time.LocalDateTime;
import java.util.List;

import com.example.projectquestion.answer.Answer;
import com.example.projectquestion.customer.Customer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Question {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer qid;

@Column(length = 200)
private String qtitle;

@Column(columnDefinition = "TEXT")
private String qcontent;

@ManyToOne//앞 Many 가 나 즉 질문들 뒤가 작성자, 하나의 작성자가 여러 질문을 작성할수 있다. 
private Customer qauthor; // User's Object

@OneToMany(mappedBy = "aquestion", cascade = CascadeType.REMOVE)
private List<Answer> answerList;

private LocalDateTime qdate;
}


