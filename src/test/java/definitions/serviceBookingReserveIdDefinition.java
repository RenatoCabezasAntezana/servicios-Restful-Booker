package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import support.requestBooking;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class serviceBookingReserveIdDefinition {

    requestBooking bookingReserve;


    private static String token;
    public static String bookingid;

    public serviceBookingReserveIdDefinition() {
        bookingReserve = new requestBooking();
    }
    @Given("the user has an account")
    public void theUserHasAnAccount() {

    }

    @When("validate user credentials")
    public void validateUserCredentials(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            bookingReserve.createLogin(
                    data.get(i).get("username"),
                    data.get(i).get("password"));
            System.out.print(data);
        }
    }

    @And("validate response code {string}")
    public void andValidateResponseCode(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), requestBooking.responseBookingIds.getStatusCode());
    }

    @Then("Then validate user access")
    public void thenValidateUserAccess() {
        Response body = requestBooking.responseBookingIds;
        System.out.print(body.asString());
        JsonPath json = new JsonPath(body.asString());
        token = json.getString("token");
        System.out.println(token);

    }

    @Given("list ids")
    public void listIds() {
        bookingReserve.getBookingIds();
    }

    @When("show the list of ids")
    public void showTheListOfIds() {
        ResponseBody body = requestBooking.responseBookingIds;
        System.out.print(body.asString());
    }

    @And("validate response code booking {string}")
    public void validateResponseCodeBooking(String codigo) {
        Assert.assertEquals(Integer.parseInt(codigo), requestBooking.responseBookingIds.getStatusCode());
        System.out.println(token);
    }

    @Given("list reservation with id={string}")
    public void listReservationWithId(String idReserve) {
        bookingReserve.getBookingforId(idReserve);
        System.out.print(idReserve);
    }

    @When("show booking information")
    public void showBookingInformation() {
        showTheListOfIds();
    }

    @And("validate response code booking reserve {string}")
    public void validateResponseCodeBookingReserve(String codigoReserveStatus) {
        Assert.assertEquals(Integer.parseInt(codigoReserveStatus), requestBooking.responseBookingIds.getStatusCode());
    }

    @Given("the user has not created a reservation")
    public void theUserHasNotCreatedAReservation() {

    }

    @When("register reservation data")
    public void registerReservationData(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            bookingReserve.postCreatedBooking(
                    data.get(i).get("firstname"),
                    data.get(i).get("lastname"),
                    data.get(i).get("totalprice"),
                    data.get(i).get("depositpaid"),
                    data.get(i).get("checkin"),
                    data.get(i).get("checkout"),
                    data.get(i).get("additionalneeds"));
            showTheListOfIds(); //LISTAMOS LOS DATOS DE LA RESERVA REALIZADA USANDO UNA FUNCION CREADA ANTERIORMENTE
        }
        System.out.print(token);
    }

    @Then("validate response code booking created {string}")
    public void validateResponseCodeBookingCreated(String codigoCreated) {
        Assert.assertEquals(Integer.parseInt(codigoCreated), requestBooking.responseBookingIds.getStatusCode());
        System.out.print("El token es: "+token);
    }

    @And("verify the response body contains the bookingid")
    public void verifyTheResponseBodyContainsTheBookingid() {
        Response body = requestBooking.responseBookingIds;
        System.out.print(body.asString());
        JsonPath json = new JsonPath(body.asString());
        bookingid = json.getString("bookingid");
        System.out.println(bookingid);

    }


    @Given("Que exista una reserva")
    public void queExistaUnaReserva() {

        System.out.print("El id del booking es: " + bookingid+"\n");
        System.out.println("No se muestra token");
        System.out.println(token);

    }

    @When("Actualizar datos de una reserva")
    public void actualizarDatosDeUnaReserva(DataTable dt) {

        List<Map<String, String>> data = dt.asMaps(String.class, String.class);

        for (int i = 0; i < data.size(); i++) {
            bookingReserve.putUpdateBooking(
                    bookingid,
                    data.get(i).get("firstname"),
                    data.get(i).get("lastname"),
                    data.get(i).get("totalprice"),
                    data.get(i).get("depositpaid"),
                    data.get(i).get("checkin"),
                    data.get(i).get("checkout"),
                    data.get(i).get("additionalneeds"),
                    token);
            System.out.println(data.get(i).get("totalprice")+data.get(i).get("depositpaid"));
            System.out.println(token);
        }
    }

    @Then("Validar condigo de respuesta {string}")
    public void validarCondigoDeRespuesta(String codigoRespuesta) {
        Assert.assertEquals(Integer.parseInt(codigoRespuesta),requestBooking.responseBookingIds.getStatusCode());
    }


    @And("Mostrar reserva actualizada")
    public void mostrarReservaActualizada() {
        showTheListOfIds();
    }

    @When("Actualizar algunos datos de una reserva")
    public void actualizarAlgunosDatosDeUnaReserva(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);

        for (int i = 0; i < data.size(); i++) {
            bookingReserve.patchUpdateBooking(
                    bookingid,
                    data.get(i).get("firstname"),
                    data.get(i).get("lastname"),
                    token);
        }
    }

    @When("Eliminar una reserva")
    public void eliminarUnaReserva() {
        bookingReserve.deleteBooking(bookingid,token);
    }

    @And("Mostrar reserva eliminada")
    public void mostrarReservaEliminada() {
    }
    @Given("Que exista la api")
    public void queExistaLaApi() {

    }
    @When("Que funcione la api")
    public void queFuncioneLaApi() {
        bookingReserve.getPing();
    }


}

