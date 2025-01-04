package restfundamentals.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.jupiter.api.BeforeAll;

public class VideoGameConfig {


    @BeforeAll
    public static void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://videogamedb.uk/")
                .setBasePath("api/v2/")
                .setContentType("application/json")
                .addHeader("Accept","application/json")
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }


}
