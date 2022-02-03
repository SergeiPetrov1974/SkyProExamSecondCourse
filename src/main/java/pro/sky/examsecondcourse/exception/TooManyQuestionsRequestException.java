package pro.sky.examsecondcourse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TooManyQuestionsRequestException extends RuntimeException {
}
