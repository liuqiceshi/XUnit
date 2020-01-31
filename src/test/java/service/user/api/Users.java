package service.user.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;
import until.TemplateTest;

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
    public TemplateTest templateTest=new TemplateTest();
    //用户列表
    public Response getUseList(String userid) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid",userid)
                .when().log().all()
                .get(Work.baseUrl+Work.userGetPath)
                .then().log().all()
                .extract().response();

    }

    //更新用户
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

    //创建用户
    public Response create( HashMap<String, Object> data) {
        return given().queryParam("access_token",Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post(Work.baseUrl+Work.userCreatePath)
                .then().log().all()
                .extract().response();
    }
    //克隆-数据模板
    public Response clone( HashMap<String, Object> data) {
        String body=templateTest.template("/service/user/api/createUser.json",data);

        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .when().log().all().post(Work.baseUrl+Work.userCreatePath)
                .then().log().all().extract().response();
    }

    //删除单个用户
    public Response delete(String userid) {
        return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("userid",userid)
                .when().log().all()
                .get(Work.baseUrl+Work.userDeletePath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("deleted"))
                .extract().response();
    }


    //获取部门成员
    public Response simplelist( HashMap<String, Object> data) {

        String body=templateTest.template("/service/user/api/simplelist.json",data);
        //转化为map类型
        JSONObject jsonObject = JSON.parseObject(body);
        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .queryParams(jsonObject)
                .when().log().all()
                .post(Work.baseUrl+Work.simplelistPath)
                .then().log().all().extract().response();
    }
    //根据部门id获取成员
    public Response simplelist( int department_id) {
        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .queryParam("department_id",department_id)
                .when().log().all()
                .post(Work.baseUrl+Work.simplelistPath)
                .then().log().all().extract().response();
    }


   // 批量删除成员
    public Response batchdelete(HashMap<String,Object> data) {

        return given()
                 .queryParam("access_token",Work.getInstance().getToken())
                 .body(data)
                 .when().log().all()
                 .post(Work.baseUrl+Work.batchdeletePath)
                 .then().log().all().extract().response();

    }
}
