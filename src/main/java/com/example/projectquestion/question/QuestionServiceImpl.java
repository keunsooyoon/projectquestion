package com.example.projectquestion.question;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectquestion.customer.Customer;
import com.example.projectquestion.customer.CustomerRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void create(Question question, Principal principal) {
		question.setQdate(LocalDateTime.now());
		Optional<Customer> tc = customerRepository.findByusername(principal.getName());
		question.setQauthor(tc.get());
		questionRepository.save(question);
	}
	@Override
	public List<Question> readlist() {
		return questionRepository.findAll();
	}
	@Override
	public Question readdetail(Integer qid) {
		Optional<Question> tq = questionRepository.findById(qid);
		return tq.get();
	}
	@Override
		public void update(Question question) {
		questionRepository.save(question);
	}
	@Override
	public void delete(Integer qid) {
		Optional<Question> tq = questionRepository.findById(qid);
		questionRepository.delete(tq.get());
	}

}