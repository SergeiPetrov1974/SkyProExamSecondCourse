package pro.sky.examsecondcourse.service;

import pro.sky.examsecondcourse.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
