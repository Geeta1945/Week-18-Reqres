package in.reqres.usersinfo;

import in.reqres.testbase.TestBase;
import in.requres.constants.EndPoints;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllUsers(){

        SerenityRest.given()
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }
}
