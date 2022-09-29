package com.restapiexample.dummy.employeeinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

    @Test
    public void delete (){
        Response response = given()
                .when()
                .delete("/delete/4829");
        response.then();//.statusCode(204);
        response.prettyPrint();
    }
}
