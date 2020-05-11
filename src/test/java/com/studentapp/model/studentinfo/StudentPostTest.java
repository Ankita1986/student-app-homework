package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.given;

/**
 * Created by Ankita
 */
public class StudentPostTest extends TestBase {


    @Test
    public void createNewStudent() {


        List<String> course = new ArrayList<>();
        course.add("Computer");
        course.add("Science");
        course.add("Biology");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Sonu");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("Patel" + getRandomString(4) + "@gmail.com");
        studentPojo.setProgramme("Computer Engineer");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

    @Test
    public void createStudentWithFirstNameNull() {


        List<String> course = new ArrayList<>();
        course.add("Computer");
        course.add("Science");
        course.add("Chemistry");


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName(" ");
        studentPojo.setLastName("Modi");
        studentPojo.setEmail("Patel" + getRandomString(4) + "@gmail.com");
        studentPojo.setProgramme("Bio Scientist");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void createStudentWithLastNameNull() {
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Mona");
        studentPojo.setLastName(" ");
        studentPojo.setEmail("Patel" + getRandomString(4) + "@gmail.com");
        studentPojo.setProgramme("Electrical Engineer");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(201);
        response.prettyPrint();


    }

    @Test
    public void createStudentWithDuplicateEmail() {
        List<String> course = new ArrayList<>();
        course.add("Selenium");
        course.add("Java");


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Mona");
        studentPojo.setLastName("Patel ");
        studentPojo.setEmail("molestie@vitaesemper.ca");
        studentPojo.setProgramme("Electrical Engineer");
        studentPojo.setCourses(course);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().statusCode(500);
        response.prettyPrint();


    }
}
