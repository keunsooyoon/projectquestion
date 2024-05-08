package com.example.projectquestion.question;

import java.security.Principal;
import java.util.List;

public interface QuestionService {

void create(Question question, Principal principal);
List<Question> readlist();
Question readdetail(Integer qid);
void update(Question question);
void delete(Integer qid);

}
