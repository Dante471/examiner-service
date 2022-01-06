package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domian.Question;
import pro.sky.java.course2.examinerservice.excepction.RequestedQuantityExceededException;


import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionServices;


    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        if (amount <= 0) {
            throw new RequestedQuantityExceededException();
        }
        Random random = new Random();
        while (questions.size() < amount) {
            int digitForChange = random.nextInt(2);
            if (digitForChange == 0 && questionServices.get(0).getAll().size() != 0){
                questions.add(questionServices.get(0).getRandomQuestion());
            } else {
                questions.add(questionServices.get(1).getRandomQuestion());
            }
        }
        return Collections.unmodifiableCollection(questions);
    }
}
