package pro.sky.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.examinerservice.domian.Question;
import pro.sky.java.course2.examinerservice.excepction.QuestionNotFoundException;

import java.util.*;

@Repository
public class JavaQuestionRepository implements QuestionRepository{
    private final List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        questions.add(questionToAdd);
        return questionToAdd;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question get(int index) {
        return questions.get(index);
    }

    public int size() {
        return questions.size();
    }

    @Override
    public boolean isEmpty() {
        return questions.isEmpty();
    }

}
