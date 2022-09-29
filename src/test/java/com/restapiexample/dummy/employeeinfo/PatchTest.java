package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTest extends TestBase {

    @Test
    public void patchEmployee (){
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("Lord Patch");

        Response response = given()
                .header("Content-Type", "application/json") // get info from Postman Headers key and value
                .body(employeePojo)
                .when()
                    .patch("/update/4829");
        response.then();//.statusCode(200);
        response.prettyPrint();
    }
}
