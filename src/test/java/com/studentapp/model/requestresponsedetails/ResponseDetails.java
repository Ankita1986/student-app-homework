package com.studentapp.model.requestresponsedetails;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created by Ankita
 */
public class ResponseDetails extends TestBase {


    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");

        Response response = given()
                .when()
                .get("/2");
        response.then()
                .log().headers()
                .statusCode(200);


    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");

        Response response = given()
                .when()
                .get("/2");
        response.then()
                .log().status()
                .statusCode(200);

    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");

        Response response = given()
                .when()
                .get("/2");
        response.then()
                .log().body()
                .statusCode(200);




    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");

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
        response.then().statusCode(500)
                .log().body();





    }

}
