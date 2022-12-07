package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingDates {

    @JsonProperty(value="checkin") private String checkin;
    @JsonProperty(value="checkout") private String checkout;

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
