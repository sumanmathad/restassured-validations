package restfundamentals;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest {

    @Test
    public void myFirstTest(){

        given().
                log().all()
        .when()
                .get("https://videogamedb.uk/api/videogame")
        .then()
                .log().all();
    }
}
