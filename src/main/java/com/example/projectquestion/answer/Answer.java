package com.example.projectquestion.answer;

import java.time.LocalDateTime;

import com.example.projectquestion.customer.Customer;
import com.example.projectquestion.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Answer {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer aid;
		
		@Column(columnDefinition = "TEXT")
		private String acontent;
		
		@ManyToOne//앞 Many 가 나 즉 질문들 뒤가 작성자, 하나의 작성자가 여러 질문을 작성할수 있다. 
		private Customer aauthor; // User's Object
		
		@ManyToOne//앞 Many 가 나 즉 답변들 뒤가 question, 하나의 질문question 여러 답변answer을 작성할수 있다. 
		private Question aquestion; // User's Object
		
		private LocalDateTime adate;
}
