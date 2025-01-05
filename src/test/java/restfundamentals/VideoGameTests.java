package restfundamentals;

import org.junit.jupiter.api.Test;
import restfundamentals.config.VideoGameConfig;
import restfundamentals.config.VideoGameEndpoints;

import static io.restassured.RestAssured.*;

public class VideoGameTests extends VideoGameConfig {
    String bodyJSON = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Mario\",\n" +
            "  \"rating\": \"Mature\",\n" +
            "  \"releaseDate\": \"2012-05-04\",\n" +
            "  \"reviewScore\": 85\n" +
            "}";
    String bodyXML = "<VideoGameRequest>\n" +
            "\t<category>Platform</category>\n" +
            "\t<name>Mario</name>\n" +
            "\t<rating>Mature</rating>\n" +
            "\t<releaseDate>2012-05-04</releaseDate>\n" +
            "\t<reviewScore>85</reviewScore>\n" +
            "</VideoGameRequest>";

    @Test
    public void getAllGames(){
        given()
        .when()
                .get(VideoGameEndpoints.ALL_VIDEO_GAMES)
        .then();
    }

    @Test
    public void createNewGameByJSON(){

        given()
                .body(bodyJSON)
        .when()
                    .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
        .then();
    }

    @Test
        public void createNewGameByXML(){

        given()
                .body(bodyXML).contentType("application/xml")
                .accept("application/xml")
                .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAMES)
                .then();
        }

        @Test
        public void updateGame(){
        given()
                .body(bodyJSON)
        .when()
                .put("videogame/3")
        .then();

        }

        @Test
        public void deleteGame(){
        given()
                .accept("text/plain")
        .when()
                .delete("videogame/8")
        .then();
        }


}
