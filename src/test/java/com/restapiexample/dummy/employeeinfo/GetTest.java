package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTest extends TestBase {

    @Test
    public void getAllEmployeesList(){
        Response response = given()
                .when()
                .get("employees");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleEmployees(){
        Response response = given()
//                .basePath("employee")
//                .pathParam("data[0].id", "1")
                .when()
                .get("/employee/1");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void checkDeleteEmployee (){
        Response response = given()
                .when()
                .get("/employee/4829");
        response.then();//.statusCode(404);
        response.prettyPrint();
    }
}
