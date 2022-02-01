package pro.sky.examsecondcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkyProExamSecondCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkyProExamSecondCourseApplication.class, args);
    }
    //http://localhost:8080/exam/java
    //http://localhost:8080/exam/java/add?question=12345QuestionText&answer=QuestionAnswer
    //http://localhost:8080/exam/java/remove?question=12345QuestionText&answer=QuestionAnswer
}
