package com.studentapp.model.studentinfo;

import com.studentapp.model.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Ankita
 */
public class StudentDeleteTest extends TestBase {

    @Test
    public void deleteStudentById(){
        Response response = given()
                .when()
                .delete("/113");
        response.then().statusCode(204);


    }
}
