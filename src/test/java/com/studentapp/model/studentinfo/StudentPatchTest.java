package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static com.studentapp.model.StudentPojo.getRandomString;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Ankita
 */
public class StudentPatchTest  extends TestBase {

    @Test
    public void updateStudentWithEmailOnly() {

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("Patel123@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .patch("/83")
                .then();
        get("/list").then().body("[82].email", equalTo("Patel123@gmail.com"));

        /*StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("Patel" + getRandomString(4) + "@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch("/2");
        response.then().statusCode(200);
        response.prettyPrint();*/
    }
}


