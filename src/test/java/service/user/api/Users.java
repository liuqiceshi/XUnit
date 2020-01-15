package service.user.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author liuqi
 * @Date 20/1/9 10:27
 * @Version 1.0
 * @Description:
 */
public class Users {
    //用户列表
    public Response getUseList(String userid) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid",userid)
                .when().log().all()
                .get(Work.baseUrl+Work.userGetPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("ok"))
                .extract().response();

    }

    public Response update(String userid, HashMap<String,Object> data) {
        data.put("userid",userid);

        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .body(data)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post(Work.baseUrl+Work.userUpdatePath)
                .then().log().all()
                .extract().response();

    }

    public Response create( HashMap<String, Object> data) {

        return given().queryParam("access_token",Work.getInstance().getToken())
                .body(data)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post(Work.baseUrl+Work.userCreatePath)
                .then().log().all()
                .extract().response();
    }
}
