package restApi.imgur;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

/**
 * Created by Olga Shestakova
 * Date 09.11.2021
 */
public class ImgurApiTest {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = ImgurApiParams.API_URL + "/" + ImgurApiParams.API_VERSION;
    }


    @DisplayName("Test Account Base")
    @Test
    @Order(1)
    void testAccountBase() {
        String url = "account/" + "olgasil";

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data.bio", is("Test Imgur"))
                .expectBody("data.reputation",is(0))
                .expectBody("status", is(200))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Test Update Image Information (Authed)")
    @Test
    @Order(2)
    void testUpdateImageInfo() {
        String imageHash = "eMJGrUq";
        String url = "image/" + imageHash;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("title", "Darth Vader")
                .addFormParam("description", "Oops!… I Did It Again")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("success", is(true))
                .expectBody("data", is(true))
                .expectStatusCode(200)
                .build();

        given().headers("Authorization", "Bearer *****")
                .when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .post(url);
    }


//     RestAssured.baseURI = ImgurApiParams.API_URL + "/"; url для этого теста
    @DisplayName("Test Account Block Status")
    @Test
    @Order(3)
    void testAccountBlockStatus() {
        String url = "account/" + "v1/" + "olgasil" + "/block";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .statusCode(is(200))
                .body("data.blocked", is(false))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Test Account Avatar (Authed)")
    @Test
    @Order(4)
    void testAccountAvatar() {
        String url = "account/" + "olgasil" + "/avatar";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .statusCode(is(200))
                .body("data.avatar_name", is("default/O"))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Test Account Settings")
    @Test
    @Order(5)
    void testAccountSettings() {
        String url = "account/" + "me" + "/settings";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .statusCode(is(200))
                .body("data.account_url", is("olgasil"))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Test Account Album")
    @Test
    @Order(6)
    void testAccountAlbum() {
        String url = "account/" + "olgasil" + "/album" + "/Test1";

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("data.privacy", is("public"))
                .expectBody("data.layout", is("blog"))
                .expectStatusCode(200)
                .build();

        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .get(url);
    }

    @DisplayName("Test Favorite an Image")
    @Test
    @Order(7)
    void testFavoriteAnImage() {
        String url = "image/" + "eMJGrUq" + "/favorite";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .statusCode(is(200))
                .body("success", is(true))
                .log()
                .all()
                .when()
                .get(url);
    }

    @DisplayName("Test Update Gallery Item Tags")
    @Test
    @Order(8)
    void testUpdateGalleryItemTags() {
        String galleryHash = "Test1";
        String url = "gallery/" + "tags/" + galleryHash;

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("id", "Test1")
                .addFormParam("tags", "funny,cats")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("data.error", is("This post is not in the gallery."))
                .expectStatusCode(400)
                .build();

        given().headers("Authorization", "Bearer *****")
                .when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .post(url);
    }

    @DisplayName("Test Favorite Album")
    @Test
    @Order(9)
    void testFavoriteAlbum() {
        String galleryHash = "Test1";
        String url = "album/" + galleryHash + "/favorite";
        given().when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .expect()
                .log()
                .all()
                .statusCode(is(200))
                .body("data", is("favorited"))
                .when()
                .post(url);
    }

    @DisplayName("Test Add Images to an Album (Authed)")
    @Test
    @Order(10)
    void testAddImagesToAlbum() {
        String url = "album/" + "SoTcVN4" + "/add";

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addFormParam("ids[]", "eMJGrUq")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectBody("data", is(true))
                .expectBody("success", is(true))
                .expectStatusCode(200)
                .build();

        given().headers("Authorization", "Bearer *****")
                .when()
                .auth()
                .oauth2(ImgurApiParams.TOKEN)
                .log()
                .all()
                .spec(requestSpecification)
                .expect()
                .log()
                .all()
                .spec(responseSpecification)
                .when()
                .post(url);
    }
}
