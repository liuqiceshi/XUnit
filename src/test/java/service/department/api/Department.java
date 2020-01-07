package service.department.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import service.Work;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author liuqi
 * @Date 20/1/6 14:55
 * @Version 1.0
 * @Description:
 */
public class Department {
    static  String baseUrl="https://qyapi.weixin.qq.com/cgi-bin";
    static String corpid="wwba4073edf8ccf28d";
    static String corpsecret="MyNy688YygBDO39LP7H95E-Cqp-Z3_AVs5sR0d4fdwA";


    //部门id
    public   int parentid=39;

    //获取部门列表
    static String departListPath="/department/list";
    //创建部门路径
    static  String createDepartPath="/department/create";
    //删除部门路径
    static String deleteDepartPath="/department/delete";



    //根据部门id获取部门列表
    public  Response list(int parentid){
       return given()
                .queryParam("access_token", Work.getInstance().getToken())
                .queryParam("id",parentid)
                .when()
               .log().all()
                .get(baseUrl+departListPath)
                .then()
               .log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("ok"))
                .extract().response();
    }
    //给某部门创建子部门
    public Response create(String name,int parentid){
        HashMap<String,Object> data=new HashMap<>();
        data.put("name",name);
        data.put("parentid",parentid);
        return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .contentType(ContentType.JSON)
                .body(data)
                .when().log().all()
                .post(baseUrl+createDepartPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("created"))
                .extract().response();
    }
    //不传部门id给默认的
    public Response create(String name){
        return create(name,parentid);
    }


    public Response delete(int id){
       return given()
                .queryParam("access_token",Work.getInstance().getToken())
                .queryParam("id",id)
                .when().log().all()
                .get(baseUrl+deleteDepartPath)
                .then().log().all()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("deleted"))
                .extract().response();


    }

   /* public static void main(String[] args){
        System.out.println("list:"+Department.list(30));
    }*/
}
