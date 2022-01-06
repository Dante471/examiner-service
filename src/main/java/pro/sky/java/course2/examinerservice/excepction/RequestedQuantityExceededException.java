package pro.sky.java.course2.examinerservice.excepction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestedQuantityExceededException extends RuntimeException{
}
