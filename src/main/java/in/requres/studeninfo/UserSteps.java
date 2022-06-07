package in.requres.studeninfo;

import in.requres.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.yecht.Data;

public class UserSteps {

    @Step
    public ValidatableResponse createUser(String firstName, String lastName, String email, String avatar){

        UserPojo userPojo = new UserPojo();
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setAvatar(avatar);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post()
                .then();

    }
}
