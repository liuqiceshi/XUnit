package service;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author liuqi
 * @Date 19/12/28 14:40
 * @Version 1.0
 * @Description:
 */
public class TestWork {
    //https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET
    //公共地址
    static  String baseUrl="https://qyapi.weixin.qq.com/cgi-bin";
    static String corpid="wwba4073edf8ccf28d";
    static String corpsecret="MyNy688YygBDO39LP7H95E-Cqp-Z3_AVs5sR0d4fdwA";
    static String access_token;
    //获取access_token路径
    static String gettokenPath="/gettoken";
    //创建部门路径
    static  String createDepartPath="/department/create";
    //部门id
    static int parentid=4;
    //获取部门列表路径
    static String departListPath="/department/list";
    //删除部门路径
    static String deleteDepartPath="/department/delete";


    //获取access_token
    @BeforeAll
    public static void getToken(){
        access_token= given()
                .param("corpid",corpid)
                .param("corpsecret",corpsecret)
        .when().log().all()
                .get(baseUrl+gettokenPath)
        .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("ok"))
                .extract()
                .body().path("access_token");
                 System.out.println("token++++++"+access_token);

    }


    @Test
    public void departCreate(){
        String name="api自动创建部门刘琦"+System.currentTimeMillis();
        HashMap<String,Object> data=new HashMap<>();
        data.put("name",name);
        data.put("parentid",parentid);

        given()
                .queryParam("access_token",access_token)
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post(baseUrl+createDepartPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("created"));
    }

    @Test
    public void departList(){
        given()
                .queryParam("access_token",access_token)
                .queryParam("id",30)
        .when().log().all()
                .get(baseUrl+departListPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("ok"));
    }
    @Test
    public void delete(){
        departList();
        given()
                .queryParam("access_token",access_token)
                .queryParam("id",5)
                .when().log().all()
                .get(baseUrl+deleteDepartPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("deleted"));
                departList();
    }

}
