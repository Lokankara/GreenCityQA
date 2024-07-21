package com.softserve.greencity.api.assured;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AuthUtils {
    private static final String PREFIX_PROP = "local.";
    private static final String PROP_USERNAME = PREFIX_PROP + "user.username";
    private static final String PROP_PASSWORD = PREFIX_PROP + "user.password";
    private static final String ENV_CHROME_OPTIONS = "CHROME_OPTIONS";
    private static final String ENV_APP_OPTIONS = "APP_OPTIONS";
    private static final String PROP_CHROME_OPTIONS = PREFIX_PROP + ENV_CHROME_OPTIONS.toLowerCase();
    public static final String BASE_URL = "https://greencity-user.greencity.cx.ua";
    private static final String SIGN_IN_ENDPOINT = "/ownSecurity/signIn";
    private static Properties properties;
    private static final ChromeOptions chromeOptions;

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();
            if (isServerRun()) {
                properties.setProperty(PROP_CHROME_OPTIONS, System.getenv(ENV_CHROME_OPTIONS));

                if (System.getenv(ENV_APP_OPTIONS) != null) {
                    for (String option : System.getenv(ENV_APP_OPTIONS).split(";")) {
                        String[] optionArr = option.split("=");
                        properties.setProperty(PREFIX_PROP + optionArr[0], optionArr[1]);
                    }
                }
            } else {

                try (InputStream inputStream = AuthUtils.class.getClassLoader().getResourceAsStream("local.properties")) {
                    if (inputStream == null) {
                        System.err.println("The \u001B[31mlocal.properties\u001B[0m file not found in src/test/resources/ directory.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException e) {
                    System.err.println("Error loading properties file: " + e.getMessage());
                    System.exit(1);
                }
            }
        }
    }

    static {
        initProperties();
        chromeOptions = new ChromeOptions();
        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            Arrays.stream(options.split(";")).forEach(chromeOptions::addArguments);
        }
    }

    public static String getUserName() {
        return properties.getProperty(PROP_USERNAME);
    }

    public static String getPassword() {
        return properties.getProperty(PROP_PASSWORD);
    }

    private static String getToken() {
        RestAssured.baseURI = BASE_URL;
        String payload = String.format("{\"email\": \"%s\", \"password\": \"%s\"}", getUserName(), getPassword());

        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post(SIGN_IN_ENDPOINT)
                .jsonPath()
                .getString("accessToken");
    }

    public static RequestSpecification getAuth() {
        return given().header("Authorization", "Bearer " + getToken());
    }
}
