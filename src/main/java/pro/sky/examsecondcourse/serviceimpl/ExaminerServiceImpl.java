package pro.sky.examsecondcourse.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.examsecondcourse.domain.Question;
import pro.sky.examsecondcourse.exception.TooManyQuestionsRequestException;
import pro.sky.examsecondcourse.service.ExaminerService;
import pro.sky.examsecondcourse.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl  implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new TooManyQuestionsRequestException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
