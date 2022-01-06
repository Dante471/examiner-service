package pro.sky.java.course2.examinerservice.constants;

import pro.sky.java.course2.examinerservice.domian.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExaminerServiceConstants {
    public static final String QUESTION = "What?";
    public static final String ANSWER = "Yes";
    public static final Question CORRECT_QUESTION = new Question("What?", "Yes");
    public static final Question CORRECT_QUESTION2 = new Question("Who?", "Me");
    public static final Collection<Question> CORRECT_COLLECTION = List.of(
            CORRECT_QUESTION,
            CORRECT_QUESTION2
    );
    public static final Question MATH_CORRECT_QUESTION = new Question("1 + 2", "3");
    public static final Collection<Question> CORRECT_EXAM_COLLECTION = List.of(
            MATH_CORRECT_QUESTION,
            CORRECT_QUESTION
            );
}
