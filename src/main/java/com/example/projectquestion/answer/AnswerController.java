package com.example.projectquestion.answer;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/create")
	public String create(@RequestParam ("acontent") String acontent, 
						 @RequestParam ("qid") Integer qid, 
			Principal principal) {
		
		answerService.create(acontent, qid, principal);
		
		return "redirect:/question/readdetail/" + qid;
	}

}
