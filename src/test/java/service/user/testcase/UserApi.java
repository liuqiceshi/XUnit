package service.user.testcase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.user.api.Users;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @Author liuqi
 * @Date 20/1/9 10:26
 * @Version 1.0
 * @Description:
 */
public class UserApi {

    //用户列表
    @Test
    public void getUseList(){
        Users users=new Users();
        users.getUseList("xiaolidev1").then().body("name",equalTo("小李的新名字Test"));
    }
    //创建用户
    @Test
    public void create(){
        String userid="userid"+System.currentTimeMillis();
        String name="liuqi"+System.currentTimeMillis();
        Users users=new Users();
        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("department",new int[]{36});
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        users.create(data).then().body("errcode",equalTo(0));
        users.getUseList(userid).then().body("name",equalTo(name));

    }
    @Test
    public void cloneCreateUser(){
        String userid="userid"+System.currentTimeMillis();
        String name="liuqi"+System.currentTimeMillis();


        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("email",String.valueOf(System.currentTimeMillis()).substring(0,11));
        Users users=new Users();
        users.clone(data).then().body("errcode",equalTo(0));
        users.getUseList(userid).then().body("name",equalTo(name));

    }


    //通过HashMap修改多个字段值
    @Test
    public  void update(){
        Users users=new Users();

        String userid="xiaolidev1";
        String nameNew="小李的新名字Test";
        String addressNew="地球上666";

        HashMap<String,Object> data=new HashMap();
        data.put("name",nameNew);
        data.put("address",addressNew);

        users.update(userid,data);

        users.getUseList(userid)
                              .then()
                              .body("name",equalTo(nameNew))
                              .body("address",equalTo(addressNew));

    }


    @DisplayName("删除用户")
    @Test
    public void delete(){

        String userid="userid"+System.currentTimeMillis();
        String name="liuqi"+System.currentTimeMillis();


        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("email",String.valueOf(System.currentTimeMillis()).substring(0,11));

        Users users=new Users();
        users.clone(data).then().body("errcode",equalTo(0));

        users.delete(userid).then().body("errmsg",equalTo("deleted"));

        users.getUseList(userid).then().body("errcode",not(equalTo(0)));
       // users.getUseList(userid).then().body("errcode",equalTo(60111));


    }

    @DisplayName("批量删除成员")
    @Test
    public void batchdelete(){
        //todo

    }

    @DisplayName("获取部门成员")
    @Test
    public void simplelist(){
        //todo

    }





}
