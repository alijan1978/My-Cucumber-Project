package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // this annotation with method ascending is used to tell Java not execute top to bottom...
                                                // instead execute it based on ascending alphabetical order (a , b) as we added before our methods

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." +
            "eyJpYXQiOjE3MDE4ODkwODUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTkzMjI4NSwidXNlcklkIjoiNjE0MyJ9." +
            "TDrvgykHxV3R13_mxqg_nBziqmEaGGNNHy4IbQ41zdU";

    public static String employee_id; // declared employee id globally to be used in entire class

    @Test
    public void bgetCreatedEmployee(){
// prepare the Request
        RequestSpecification preparedRequest = given().request().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);
// hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
// verify the response status code
        response.then().assertThat().statusCode(200);
// verify the exact employee id, firstname and lastname provided in Create Employee and now in getCreate Employee should be the same
       String tempEmployeeId = response.jsonPath().getString("employee.employee_id");

// we have 2 employee id (Uppercase Employee message (object) from Create Employee API which was global
// the other employee id with Lowercase employee from getEmployee API which was local)
// In Below, with Assert.assertEquals() method, we compare the two employee id if both are the same or not

        Assert.assertEquals(employee_id, tempEmployeeId);
    }

    @Test
    public void acreateEmployee(){

// CRUD operation
// 1. Prepare the Request
        RequestSpecification prepareRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "      \"emp_firstname\": \"Tahseen\",\n" +
                        "      \"emp_lastname\": \"Ali\",\n" +
                        "      \"emp_middle_name\": \"None\",\n" +
                        "      \"emp_gender\": \"M\",\n" +
                        "      \"emp_birthday\": \"2023-11-28\",\n" +
                        "      \"emp_status\": \"Confirmed\",\n" +
                        "      \"emp_job_title\": \"Baby child\"\n" +
                        "    }");

// 2. Hitting the endpoint OR send the request
        Response response = prepareRequest.when().post("/createEmployee.php");
// print the output in Console
        response.prettyPrint();
// 3. Verifying the assertion OR get response
        response.then().assertThat().statusCode(201);
// Here we are capturing employee ID from the Response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println("This is my employee id: "+employee_id);
// Verifying the firstname in response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Tahseen"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Ali"));

// Verifying the response header
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My test case is passed");

    }
    @Test
    public void cupdateEmployee(){

        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Tahseen jan\",\n" +
                        "  \"emp_lastname\": \"Ali Baba\",\n" +
                        "  \"emp_middle_name\": \"none\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-11-28\",\n" +
                        "  \"emp_status\": \"Promoted to higher position\",\n" +
                        "  \"emp_job_title\": \"Naughty Body\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    // to verify , we use hamcrest matchers
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));
    }

    @Test
    public void dgetUpdatedEmployee(){

        RequestSpecification preparedRequest = given().request().
                header("Content-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
 // if you want to verify the body of Response, you can do that using hamcrest matchers



    }



}
