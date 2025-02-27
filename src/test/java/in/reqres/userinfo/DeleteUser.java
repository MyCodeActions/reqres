package in.reqres.userinfo;
import in.reqres.testbase.TestBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DeleteUser extends TestBase {

    @Test
    public void ReqResDelete(){
        given().log().all()
                .when()
                .delete("/users/2")
                .then().log().all()
                .statusCode(204);
    }
}
