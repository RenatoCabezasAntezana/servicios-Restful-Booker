package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadPatchBooking {

    @JsonProperty(value = "firstname") String firstname;
    @JsonProperty(value="lastname") String lastname;

    public payloadPatchBooking(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
