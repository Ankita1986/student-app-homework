package com.studentapp.model;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Ankita
 */
public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost:8085";
        RestAssured.basePath = "/student";
    }

}
