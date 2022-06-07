package in.reqres.usersinfo;

import in.reqres.testbase.TestBase;
import in.requres.constants.EndPoints;
import in.requres.model.UserPojo;
import in.requres.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class UserCurdTest extends TestBase {


    static String first_name ="ReqresUser" + TestUtils.getRandomValue();
    static String last_name = "ReqresLastName"+ TestUtils.getRandomValue();
    static String email= TestUtils.getRandomValue()+"xyz@gmail.com";
    static String avatar = "https://reqres.in/img/faces/1-image.jpg";
    static int userId = Integer.parseInt(15+ TestUtils.getRandomValue());
    @Test
    public void test001(){

        UserPojo userPojo = new UserPojo();
        userPojo.setFirstName(first_name);
        userPojo.setLastName(last_name);
        userPojo.setEmail(email);
        userPojo.setAvatar(avatar);
        userPojo.setUserId(userId);
        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.GET_ALL_USERS)
                .then().log().all().statusCode(201);

    }

   // @Title("Verify if the user was added to the application")
    @Test
    public void test002(){

        System.out.println(first_name);
        HashMap<String, Object> userMap = SerenityRest.given().log().all()
                .when()
                .pathParam("userID",userId)
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then()
                .statusCode(200)
                .extract()
                .path("");
        Assert.assertThat(userMap,hasValue(first_name)); // Junit assert
        userId= (int) userMap.get("id");
        System.out.println(userId);

    }

}
