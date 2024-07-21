package com.softserve.greencity.api.assured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class PlaceControllerTests {

    private static RequestSpecification auth;
    private static final String BASE_URL = "https://greencity.greencity.cx.ua";
    private static final String PLACE_ALL = "/place/all";
    private static final String PLACE_ABOUT_ID = "/place/about/{id}";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        auth = AuthUtils.getAuth();
    }

    @Test
    public void testGetAllPlaces() {
        auth.get(PLACE_ALL)
                .then()
                .statusCode(200)
                .body("content", not(empty()));
    }

    @Test
    public void testGetPlaceById() {
        auth.get(PLACE_ABOUT_ID, 1)
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
