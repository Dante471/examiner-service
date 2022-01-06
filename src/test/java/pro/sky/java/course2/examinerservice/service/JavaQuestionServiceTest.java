package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domian.Question;
import pro.sky.java.course2.examinerservice.excepction.NoQuestionsAddedException;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;
import pro.sky.java.course2.examinerservice.repository.QuestionRepository;

import java.util.Collection;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import static pro.sky.java.course2.examinerservice.constants.ExaminerServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repositoryMock;

    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void shouldReturnAddedByObjectJavaQuestion() {
        when(repositoryMock.add(CORRECT_QUESTION))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_QUESTION));
    }

    @Test
    public void shouldReturnAddedByParamsJavaQuestion() {
        when(repositoryMock.add(QUESTION, ANSWER))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.add(QUESTION, ANSWER));
    }

    @Test
    public void shouldReturnRemovedQuestion() {
        when(repositoryMock.remove(CORRECT_QUESTION))
                .thenReturn(CORRECT_QUESTION);
        assertEquals(CORRECT_QUESTION, out.remove(CORRECT_QUESTION));
    }

    @Test
    public void shouldReturnCorrectCollection() {
        when(repositoryMock.getAll())
                .thenReturn(CORRECT_COLLECTION);
        assertIterableEquals(CORRECT_COLLECTION, out.getAll());
    }

    @Test
    public void shouldReturnSomeJavaQuestion() {
        when(repositoryMock.size())
                .thenReturn(1);
        when(repositoryMock.get(0))
                .thenReturn(CORRECT_QUESTION);
        assertNotNull(out.getRandomQuestion());
    }

    @Test
    public void shouldThrowNoQuestionsAddedException() {
        when(repositoryMock.isEmpty())
                .thenReturn(true);
        assertThrows(NoQuestionsAddedException.class,
                () -> out.getRandomQuestion());
    }

}
