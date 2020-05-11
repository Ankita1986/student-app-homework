package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ankita
 */
public class StudentPutTest extends TestBase {

    @Test
    public void updateStudentById() {

        List<String> course = new ArrayList<>();
        course.add("Computer");
        course.add("Science");
        course.add("Biology");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Mary");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("ab123@gmail.com");
        studentPojo.setProgramme("Computer Engineer");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .put("/5");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
