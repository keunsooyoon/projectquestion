package com.example.projectquestion.answer;

import java.security.Principal;

public interface AnswerService {
	
	void create(String acontent, Integer qid, Principal principal);

}
