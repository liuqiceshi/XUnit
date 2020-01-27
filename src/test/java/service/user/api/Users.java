package service.user.api;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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
    //克隆-模板
    public Response clone( HashMap<String, Object> data) {
        String body=template("/service/user/api/createUser.json",data);

        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .when().log().all().post(Work.baseUrl+Work.userCreatePath)
                .then().log().all().extract().response();
    }


    //模板
    public  String template(String path,HashMap<String,Object> data)  {
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(path).getPath());
        mustache.execute(writer, data);

        try {
           // System.out.println("flush前");
            writer.flush();
           // System.out.println("flush后");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();

    }

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
}
