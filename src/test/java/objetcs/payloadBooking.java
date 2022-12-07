package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadBooking {


    @JsonProperty(value = "firstname")  String firstname;
    @JsonProperty(value = "lastname")  String lastname;
    @JsonProperty(value = "totalprice")  Integer totalprice;
    @JsonProperty(value = "depositpaid")  Boolean depositpaid;
    @JsonProperty(value = "bookingdates") BookingDates bookingdates;
    @JsonProperty(value = "additionalneeds") String additionalneeds;

    public payloadBooking(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDates bookingdates, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }
}

