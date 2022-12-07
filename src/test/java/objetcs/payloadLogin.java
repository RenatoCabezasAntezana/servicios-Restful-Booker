package objetcs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class payloadLogin {
    @JsonProperty(value = "username") private String username;
    @JsonProperty(value="password") private String contra;

    public payloadLogin(String correo, String contra) {
        this.username = correo;
        this.contra = contra;
    }
}
