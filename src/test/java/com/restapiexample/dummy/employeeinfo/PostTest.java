package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTest extends TestBase {
    @Test
    public void CreateEmployee (){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("lord1");
        employeePojo.setSalary("3200");
        employeePojo.setAge("39");
        Response response = given()
                .header("Content-Type", "application/json") // get info from Postman Headers key and value
                .body(employeePojo)
                .when()
                .post("/create");
        response.then().statusCode(201);//.statusCode(200); //201
        response.prettyPrint();

    }
}
