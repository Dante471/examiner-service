package pro.sky.java.course2.examinerservice.repository;

import pro.sky.java.course2.examinerservice.domian.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question get(int index);
    int size();
    boolean isEmpty();
}
