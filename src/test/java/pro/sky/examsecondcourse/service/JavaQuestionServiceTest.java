package pro.sky.examsecondcourse.service;

import org.junit.jupiter.api.Test;
import pro.sky.examsecondcourse.domain.Question;
import pro.sky.examsecondcourse.exception.DuplicateQuestionException;
import pro.sky.examsecondcourse.exception.QuestionNotFoundException;
import pro.sky.examsecondcourse.serviceimpl.JavaQuestionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.examsecondcourse.constant.Constants.*;


public class JavaQuestionServiceTest {
    private final JavaQuestionService out;

    JavaQuestionServiceTest() {
        out = new JavaQuestionService();
    }

    @Test
    void shouldCorrectAddQuestion() {
        int size = out.getAll().size();
        assertEquals(QUEST1, out.add(QUEST1));
        assertEquals(size + 1, out.getAll().size());
    }

    @Test
    void shouldThrowExceptionWhenAddDuplicate() {
        out.add(QUEST1);
        assertThrows(DuplicateQuestionException.class, () -> out.add(QUEST1));
    }

    @Test
    void shouldCorrectRemoveQuestion() {
        int size = out.getAll().size();
        out.add(QUEST2);
        assertEquals(QUEST2, out.remove(QUEST2));
        assertEquals(size, out.getAll().size());
    }

    @Test
    void shouldThrowExceptionWhenQuestionNotFound() {
        out.add(QUEST1);
        Question notFoundQuestion = new Question(QUESTION1, ANSWER2);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(notFoundQuestion));
    }

    @Test
    void shouldReturnTestingSetWhenGetAll() {
        out.add(QUEST1);
        out.add(QUEST2);
        out.add(QUEST3);
        out.add(QUEST4);
        out.add(QUEST5);
        assertEquals(ALL_QUESTIONS_SET, out.getAll());
    }
}
