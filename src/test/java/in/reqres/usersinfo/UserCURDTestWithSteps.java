package in.reqres.usersinfo;

import in.reqres.testbase.TestBase;
import in.requres.studeninfo.UserSteps;
import in.requres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

public class UserCURDTestWithSteps extends TestBase {
    static String firstName ="ReqresUser" + TestUtils.getRandomValue();
    static String lastName = ""+ TestUtils.getRandomValue();
    static String email= TestUtils.getRandomValue()+"xyz@gmail.com";
    static String avatar = "https://reqres.in/img/faces/1-image.jpg";
    static int userId;

    @Steps
    UserSteps userSteps;


    @Title("This will create a new user")
    @Test
    public void createUser(){
        ValidatableResponse response = userSteps.createUser(firstName,lastName,email,avatar);
        response.log().all().statusCode(201);
    }

}
