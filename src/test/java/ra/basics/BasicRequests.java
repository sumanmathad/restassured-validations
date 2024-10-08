package ra.basics;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class BasicRequests {

@Test
    public void verifyResponseStatusCode_ContentType(){
        given().
        when().
        get("https://api.zippopotam.us/IN/584122").
        then().
                assertThat().statusCode(200).contentType("application/json");
}

@Test
    public void verifyBodyValidationsWithHamcrestMatchers(){
    given().when().get("https://api.zippopotam.us/IN/584122").
            then().assertThat().
            body("places[0].'place name'", equalTo("Lingasugur")).
            body("places[0].state", equalTo("Karnataka")).
            body("places[0].'place name'",endsWith("ugur")).
            body("places[0]", hasEntry("place name","Lingasugur")).
            body("places.'place name'",hasItem("Lingasugur"));
}

    @Test
    public void verifyHeaderValidations(){
        given().when().get("https://api.zippopotam.us/IN/584122").
                then().assertThat().header("charset","UTF-8").
                header("Server",equalTo("cloudflare"));

    }

    @Test
    public void verifygroovyParsingValidations(){
    given().when().get("https://api.zippopotam.us/IN/570001").then()
            .assertThat().
            body("places.findAll { it.state = 'Karnataka' } .'place name'", hasItems("Iringere","K R Mohalla","Kabir Road", "K R Circle"));
    }

    @Test
    public void verifyLogAll(){
        given().
                when().
                get("https://api.zippopotam.us/IN/584122").
                then().log().all();
    }

    @Test
    public void verifyLogBody(){
        given().
                when().
                get("https://api.zippopotam.us/IN/584122").
                then().log().body();
    }




}
