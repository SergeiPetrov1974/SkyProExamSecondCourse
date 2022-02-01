package pro.sky.examsecondcourse.serviceimpl;

import org.springframework.stereotype.Service;
import pro.sky.examsecondcourse.domain.Question;
import pro.sky.examsecondcourse.exception.DuplicateQuestionException;
import pro.sky.examsecondcourse.exception.QuestionNotFoundException;
import pro.sky.examsecondcourse.service.QuestionService;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @PostConstruct
    private void initQuestions() {
        for (int i = 0; i < 6; i++) {
            questions.add(new Question("question" + i, "answer" + i));
        }
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        }
        throw new DuplicateQuestionException();
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = new ArrayList<>(getAll());
        return questionList.get(random.nextInt(questions.size()));
    }

}