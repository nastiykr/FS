package ru.cft.focus.api;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.cft.focus.constants.Path.BASE_URL;

public class HttpMethods {
    private static RequestSpecification prepareRequest() {
        return given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .proxy("proxy.ftc.ru", 3128)
                .baseUri(BASE_URL);
    }

    public static Response get(String url, Map<String, ?> parameters) {
        return prepareRequest().
                params(parameters).
                when().
                get(url);
    }

    public static <T> Response post(String url, T bodyData) {
        return prepareRequest().
                contentType(ContentType.JSON).
                body(bodyData).
                when().
                post(url);
    }
}
