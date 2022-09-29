package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CRUDTest extends TestBase {

    @Test // list
    public void test001 (){
        Response response = given()
                .when()
                .get("employees");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test // single id
    public void test002 (){
        Response response = given()
                .when()
                .get("/employee/1");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test // post
    public void test003 (){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("lord11");
        employeePojo.setSalary("320001");
        employeePojo.setAge("31");
        Response response = given()
                .header("Content-Type", "application/json") // get info from Postman Headers key and value
                .body(employeePojo)
                .when()
                .post("/create");
        response.then();//statusCode(201);
        response.prettyPrint();
    }
    @Test //patch
    public void test004 (){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("lord");
        Response response = given()
                .header("Content-Type", "application/json") // get info from Postman Headers key and value
                .body(employeePojo)
                .when()
                .patch("/update/943");
        response.then();//.statusCode(200);
        response.prettyPrint();

    }

    @Test // delete
    public void test005 (){
        Response response = given()
                .when()
                .delete("/delete/943");
        response.then();////.statusCode(204);
        response.prettyPrint();
    }
    @Test // // heck delete id
    public void test006 (){
        Response response = given()
                .when()
                .get("/employee/943");
        response.then();//.statusCode(404);
        response.prettyPrint();
    }
}
