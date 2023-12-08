package APIStepDefinitions;

import Utils.APIConstants;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GenerateTokenSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static String token;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

//      preparing Request
        RequestSpecification generateTokenRequest = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "    \"email\": \"mohammadalinaim32@gmail.com\",\n" +
                        "    \"password\": \"ABdullah$1234\"\n" +
                        "}");

//      hitting the endpoint
        Response response = generateTokenRequest.when().post(APIConstants.GENERATE_TOKEN_URI);

//      storing the token in global variable
        token = "Bearer "+response.jsonPath().getString("token");

        System.out.println(token);


    }

}
