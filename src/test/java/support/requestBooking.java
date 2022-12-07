package support;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import objetcs.BookingDates;
import objetcs.payloadBooking;
import objetcs.payloadLogin;
import objetcs.payloadPatchBooking;

public class requestBooking {
    apihelper api;
    payloadBooking booking;
    BookingDates bookingdates;

    payloadPatchBooking bookingpatch;
    payloadLogin login;


    public static Response responseBookingIds;

    public requestBooking() {
        api = new apihelper();
    }


    public void createLogin(String email, String password) {
        String url = "https://restful-booker.herokuapp.com/auth";
        System.out.printf(email,password);
        login = new payloadLogin(email, password);
        responseBookingIds = api.postLogin(url, login);
    }
    public void getBookingIds() {
        String url = "https://restful-booker.herokuapp.com/booking";
        responseBookingIds = api.getBookingids(url);
    }

    public void getBookingforId(String id) {
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        responseBookingIds = api.getBookingids(url);
    }

    public void postCreatedBooking(String firstname, String lastname, String totalprice,
                                   String depositpaid, String checkin, String checkout,
                                   String additionalneeds) {
        String url = "https://restful-booker.herokuapp.com/booking";
        bookingdates = new BookingDates(checkin, checkout);
        booking = new payloadBooking(firstname, lastname, Integer.parseInt(totalprice), Boolean.parseBoolean(depositpaid), bookingdates, additionalneeds);
        responseBookingIds = api.postCreatedBookingReserve(url,booking);
    }

    public void putUpdateBooking(String id, String firstname, String lastname, String totalprice,String depositpaid, String checkin, String checkout,String additionalneeds,String token) {
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        bookingdates = new BookingDates(checkin, checkout);
        booking = new payloadBooking(firstname, lastname, Integer.parseInt(totalprice), Boolean.parseBoolean(depositpaid), bookingdates, additionalneeds);
        responseBookingIds = api.putUpdateReserve(url,booking,token);
    }
    public void patchUpdateBooking(String id, String firstname, String lastname,String token) {
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        bookingpatch = new payloadPatchBooking(firstname, lastname);
        responseBookingIds = api.patchUpdateBooking(url,bookingpatch,token);
    }
    public void deleteBooking(String id,String token) {
        String url = "https://restful-booker.herokuapp.com/booking/" + id;
        responseBookingIds = api.deleteBooking(url,token);
    }
    public void getPing(){
        String url="https://restful-booker.herokuapp.com/ping";
        responseBookingIds=api.getPing(url);
    }
}
