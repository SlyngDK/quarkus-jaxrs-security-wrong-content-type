package org.acme.quickstart;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    public void testForbiddenEndpoint() {
        given()
                .when()
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString("user:passwd".getBytes()))
                .get("/hello/forbidden")
                .then()
                .statusCode(403)
                .header("Content-Type", "text/plain")
                .body(is("Forbidden"));
    }

}
