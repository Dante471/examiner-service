package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.repository.JavaQuestionRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.java.course2.examinerservice.constants.ExaminerServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaServiceMock;

    @Mock
    private MathQuestionService mathServiceMock;


    private ExaminerServiceImpl out;

    @BeforeEach
    public void init () {
        out = new ExaminerServiceImpl(List.of(javaServiceMock, mathServiceMock));
    }

    @Test
    public void shouldReturnSomeNotNullCollection() {
        when(javaServiceMock.getRandomQuestion())
                .thenReturn(CORRECT_QUESTION);
        when(mathServiceMock.getRandomQuestion())
                .thenReturn(MATH_CORRECT_QUESTION);
        assertIterableEquals(CORRECT_EXAM_COLLECTION, out.getQuestions(2));
    }


}
