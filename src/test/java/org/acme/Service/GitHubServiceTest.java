package org.acme.Service;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@QuarkusTest

public class GitHubServiceTest {

    @Test
    public void testGetUserRepositoryInfo_200() {
        String username = "octocat";

        RestAssured.given()
                .when().get("/" + username + "/repos")
                .then()
                .statusCode(200)
                .body("$.size()", greaterThan(0))
                .body("[0].login", equalTo(username));
    }
}
