package pro.sky.examsecondcourse.service;

import pro.sky.examsecondcourse.domain.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
