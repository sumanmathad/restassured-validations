package restfundamentals;

import org.junit.jupiter.api.Test;
import restfundamentals.config.FootBallConfig;

import static io.restassured.RestAssured.*;

public class FootballTests extends FootBallConfig {
    @Test
    public void getDetailsOfOneArea(){

        given()
                .queryParam("areas",2076)
        .when()
                .get("/areas");

    }

}
