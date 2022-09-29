package com.restapiexample.dummy.assertion;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Assertion extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt (){
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/";
       // RestAssured.basePath="/api/v1";
        response = given()
                .when()
                .get("employees")
                .then().statusCode(200);
    }

    //Vetify the following data from response
    //1. total records are 24
    @Test // extraction
    public void test001 (){
        List<?> data=response.extract().path("data");
        int noOfData = data.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The no of data is : "+ noOfData);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. data[23].id = 24
    @Test
    public void test002 () {response.body("data[23].id", equalTo(24));}
    //   public void Id() {response.body("data[23].id",equalTo(24));}

    //3. data[23].employee_name = “Doris Wilder”
    @Test
    public void test003 (){ response.body("data[23].employee_name", equalTo("Doris Wilder"));}

    //4. message = “Successfully! All records has been fetched.”
    @Test
    public void test004 (){response.body("message", equalTo("Successfully! All records has been fetched."));}

    //5.status = success
    @Test
    public void test005 (){response.body("status", equalTo("success"));}
    //6. id = 3 has employee_salary = 86000
    @Test
    public void test006 (){response.body("data[2].employee_salary", equalTo(86000));}
    //7. id = 6 has employee_age = 61
@Test
    public void test007 (){response.body("data[5].employee_age", equalTo(61));}
    //8. id = 11 has employee_name = Jena Gaines
    @Test
    public void test008 (){response.body("data[10].employee_name", equalTo("Jena Gaines"));}

}
