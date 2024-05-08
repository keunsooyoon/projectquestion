package com.example.projectquestion.question;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@Controller
public class QuestionController {

@Autowired
private QuestionService questionService;
@GetMapping("/create")
public String create() {
return "question/create";
}
@PostMapping("/create")
public String create(Question question, Principal principal) {
questionService.create(question, principal);
return "redirect:/question/readlist";
}
@GetMapping("/readlist")
public String readlist(Model model) {
model.addAttribute("questions", questionService.readlist());
return "question/readlist";
}
@GetMapping("/readdetail/{qid}")
public String readdetail(@PathVariable("qid") Integer qid,
Model model) {
model.addAttribute("question", questionService.readdetail(qid));
return "question/readdetail";
}
@GetMapping("/update/{qid}")
public String update(@PathVariable("qid") Integer qid, Model model) {
	model.addAttribute("question", questionService.readdetail(qid));
return "question/update";
}
@PostMapping("/update")
public String update(Question question) {
questionService.update(question);
return "redirect:/question/readlist";
}
}
 