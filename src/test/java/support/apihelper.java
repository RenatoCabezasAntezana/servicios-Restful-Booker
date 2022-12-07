package support;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//VAMOS A CREAR NUESTRO PROYECTO BASE PARA HACER LAS PETICIONES
public class apihelper {

    public Response postLogin(String url, Object payload) {
        Response response = given()
                .body(payload)
                .contentType("application/json")
                .post(url);
        return response;
    }

    public Response getBookingids(String url) {
        Response response = given().get(url);
        return response;
    }

    public Response postCreatedBookingReserve(String url, Object payload) {
        Response response = given()
                .body(payload)
                .contentType("application/json")
                .post(url);
        return response;
    }

    public Response putUpdateReserve(String url, Object payload, String token) {
        Response response = given()
                .header("Cookie", "token=" + token)
                .header("Accept", "application/json")
                .body(payload)
                .contentType("application/json")
                .put(url);
        return response;
    }

    public Response patchUpdateBooking(String url, Object payload, String token) {
        Response response = given()
                .header("Cookie", "token=" + token)
                .header("Accept", "application/json")
                .body(payload)
                .contentType("application/json")
                .patch(url);
        return response;
    }

    public Response deleteBooking(String url, String token) {
        Response response = given()
                .header("Cookie", "token=" + token)
                .header("Accept", "application/json")
                .contentType("application/json")
                .delete(url);
        return response;
    }
    public Response getPing(String url){
        Response response=given().get(url);
        return response;
    }
}