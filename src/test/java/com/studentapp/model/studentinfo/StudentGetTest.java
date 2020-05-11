package com.studentapp.model.studentinfo;

import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Ankita
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentDetails() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getStudentById(){
        Response response = given()
                .when()
                .get("1");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentByProgramme(){

        given()
                .param("programme","Financial Analysis")
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(10));

    }

    @Test
    public void searchStudentWithProgrammeAndLimit() {

        given()
                .param("programme","Financial Analysis")
                .param("limit",4)
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(4));

    }


}
