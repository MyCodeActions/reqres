package in.reqres.userinfo;

import in.reqres.model.ReqResPojo;
import in.reqres.testbase.TestBase;
import in.reqres.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUser extends TestBase {

    @Test
    public void createReqRes() {
        String email = TestUtils.getRandomValue() + "prashant@gmail.com";
        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setFirst_name("Kapil");
        reqResPojo.setJob("Tester");
        reqResPojo.setId(213);
        reqResPojo.setEmail(email);
        reqResPojo.setLast_name("Patel");
        reqResPojo.setAvatar("https://reqres.in/img/faces/8-image.jpg");

        Response response = given().log().all()
                .when()
                .body(reqResPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public void PostLoginSuccess() {

        String email = TestUtils.getRandomValue() + "prashant@gmail.com";
        ReqResPojo reqResPojo = new ReqResPojo();
        reqResPojo.setEmail("eve.holt@reqres.in");
        reqResPojo.setPassword("cityslicka");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(reqResPojo)
                .post("/login");
        response.prettyPrint();
        response.then().statusCode(200);

    }
}
