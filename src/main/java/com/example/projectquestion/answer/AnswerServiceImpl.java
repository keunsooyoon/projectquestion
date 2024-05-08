package com.example.projectquestion.answer;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectquestion.customer.Customer;
import com.example.projectquestion.customer.CustomerRepository;
import com.example.projectquestion.question.Question;
import com.example.projectquestion.question.QuestionRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Override
	public void create(String acontent, Integer qid, Principal principal) {
		Answer answer = new Answer(); // 새로운 answer 객체 생성
		
		answer.setAcontent(acontent); // 객체에 답변 내용 넣기
		
		answer.setAdate(LocalDateTime.now()); //객체에 현재 날짜 시간 넣기
		
		Optional<Question> tq = questionRepository.findById(qid);
		answer.setAquestion(tq.get());
		
		Optional<Customer> tc = customerRepository.findByusername(principal.getName());
		answer.setAauthor(tc.get());  //객체에 답변 작성자 정보 객체로 객체에 넣기
		
		answerRepository.save(answer);// 최종 객체 저장

	}

}
