package pro.sky.java.course2.examinerservice.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domian.Question;
import pro.sky.java.course2.examinerservice.excepction.QuestionNotFoundException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.examinerservice.constants.ExaminerServiceConstants.*;

public class JavaQuestionRepositoryTest {
    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    public void shouldReturnAddedByParametersQuestion() {
        Question result = out.add(QUESTION, ANSWER);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnAddedByObjectQuestion() {
        Question result = out.add(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        out.add(CORRECT_QUESTION);
        Question result = out.remove(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, result);
    }

    @Test
    public void shouldReturnCorrectCollection() {
        out.add(CORRECT_QUESTION);
        out.add(CORRECT_QUESTION2);
        Collection<Question> result = out.getAll();
        assertIterableEquals(CORRECT_COLLECTION, result);
    }

    @Test
    public void shouldThrowQuestionNotFoundException() {
        out.add(CORRECT_QUESTION2);
        assertThrows(QuestionNotFoundException.class,
                () -> out.remove(CORRECT_QUESTION));
    }
}
