package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domian.Question;
import pro.sky.java.course2.examinerservice.excepction.MethodNotAllowedException;

import java.util.Collection;
import java.util.Random;

import static pro.sky.java.course2.examinerservice.constants.MathSign.*;

@Service
public class MathQuestionService implements QuestionService{
    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        char mathSign = SIGNS[random.nextInt(4)];
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        int result = 0;
        switch (mathSign) {
            case '+': result = a + b;
                break;
            case '-': result = a - b;
                break;
            case '/': result = a / b;
                break;
            case '*': result = a * b;
                break;
            default:
                break;
        }
        String question = a + " " + mathSign + " " + b;
        String answer = String.valueOf(result);
        return new Question(question, answer);
    }


}
