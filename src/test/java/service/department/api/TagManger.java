package service.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @Author liuqi
 * @Date 20/1/8 00:08
 * @Version 1.0
 * @Description:
 */
public class TagManger {

   //标签列表
    public Response list() {
        return  given().queryParam("access_token", Work.getInstance().getToken())
                .when().log().all()
                .get(Work.baseUrl+Work.tagsListPath)
                .then().log().all()
                .extract().response();
    }

    //创建标签
    public Response create(String tagname) {
        HashMap<String,Object> data=new HashMap<>();
        data.put("tagname",tagname);
        return  given()
                .queryParam("access_token",Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post(Work.baseUrl+Work.tagsCreatePath)
                .then().log().all()
                .extract().response();
    }

    //删除标签
    public Response delete(int tagid ) {
        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .queryParam("tagid",tagid)
                .when().log().all()
                .get(Work.baseUrl+Work.tagsDeletePath)
                .then().log().all()
                .extract().response();
    }
}
