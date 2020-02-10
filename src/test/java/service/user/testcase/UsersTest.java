package service.user.testcase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import service.user.api.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @Author liuqi
 * @Date 20/1/9 10:26
 * @Version 1.0
 * @Description:
 */
public class UsersTest {

    /**
     * 用CsvSource进行数据驱动
     * @param userid
     */
    @DisplayName("getUseListPo方法")
    @ParameterizedTest
    @CsvSource({
            "xiaolidev1",
            "productTest"
    })
    public void getUseListPo(String userid){
        if(userid.isEmpty()){
            userid="liuqi"+System.currentTimeMillis();

        }
        Users users=new Users();
        users.getUseListPO(userid).then().body("errmsg",equalTo("ok"));
    }

    @DisplayName("用户列表")
    @Test
    public void getUseList(){
        service.user.api.Users users=new service.user.api.Users();
        users.getUseList("xiaolidev1").then().body("name",equalTo("小李的新名字Test"));
    }

    /**
     * 通过CsvFileSource加载文件进行数据驱动
     * @param userid
     * @param name
     */
    @DisplayName("创建用户通过CsvFileSource加载文件进行数据驱动")
    @ParameterizedTest
    @CsvFileSource(resources = "createUsers.csv" )
    public void create(String userid,String name){
        if (userid.isEmpty()){
             userid="userid"+System.currentTimeMillis();
        }
        if(name.isEmpty()){
             name="name"+System.currentTimeMillis();
        }
        service.user.api.Users users=new service.user.api.Users();
        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("department",new int[]{36});
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        users.create(data).then().body("errcode",equalTo(0));
        users.getUseList(userid).then().body("name",equalTo(name));

    }
    /**
     * 通过CsvFileSource加载文件进行数据驱动
     * @param userid
     * @param name
     */
    @DisplayName("创建用户通过MethodSource加载文件进行数据驱动")
    @ParameterizedTest
    @MethodSource("createUsersFormYamlDatas")
    public void createUsers(String userid,String name){
        if (userid.isEmpty()){
            userid="userid"+System.currentTimeMillis();
        }
        if(name.isEmpty()){
            name="name"+System.currentTimeMillis();
        }
        service.user.api.Users users=new service.user.api.Users();
        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("department",new int[]{36});
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        users.create(data).then().body("errcode",equalTo(0));
        users.getUseList(userid).then().body("name",equalTo(name));

    }
    public static Stream<Arguments> createUsersFormYamlDatas(){
        //todo
        return Stream.of();
    }


    //克隆-模板
    @Test
    public void cloneCreateUser(){
        String userid="userid"+System.currentTimeMillis();
        String name="liuqi"+System.currentTimeMillis();


        HashMap<String,Object> data=new HashMap<>();
        data.put("userid",userid);
        data.put("name",name);
        data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
        data.put("email",String.valueOf(System.currentTimeMillis()).substring(0,11));
        service.user.api.Users users=new service.user.api.Users();
        users.clone(data).then().body("errcode",equalTo(0));
        users.getUseList(userid).then().body("name",equalTo(name));

    }
    /**
     * 通过HashMap修改多个字段值,通过MethodSource进行数据驱动
     * @param userid
     * @param name
     */
    @DisplayName("更新用户")
    @ParameterizedTest
    @MethodSource("updateFormYamlDatas")
    public  void update(String userid,String name){
        service.user.api.Users users=new service.user.api.Users();
        String addressNew="地球上666";
        HashMap<String,Object> data=new HashMap();
        data.put("name",name);
        data.put("address",addressNew);
        users.update(userid,data);
        users.getUseList(userid)
                              .then()
                              .body("name",equalTo(name))
                              .body("address",equalTo(addressNew));

    }

    //通过流数据驱动
    public static Stream<Arguments> updateFormYamlDatas(){
        ObjectMapper objectMapper=new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String,Object>>> typeReference=new TypeReference<List<HashMap<String,Object>>>(){};
        List<HashMap<String,Object>> datas;
        try {
            //读取yaml文件
            datas=objectMapper.readValue(UsersTest.class.getResourceAsStream("updateUers.yaml"),typeReference);
            //获取各个字段添加到流中
            ArrayList<Arguments> results =new ArrayList<Arguments>() ;
            for (HashMap<String,Object> data:datas) {
                results.add(
                              Arguments.arguments(data.get("userid"),data.get("name"))
                        );

            }
            return results.stream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Stream.of(
//                Arguments.arguments("xiaolidev1","小李的新名字TestArguments")
        );

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

        service.user.api.Users users=new service.user.api.Users();
        users.clone(data).then().body("errcode",equalTo(0));

        users.delete(userid).then().body("errmsg",equalTo("deleted"));

        users.getUseList(userid).then().body("errcode",not(equalTo(0)));
       // users.getUseList(userid).then().body("errcode",equalTo(60111));


    }

    @DisplayName("批量删除成员batchdelete")
    @Test
    public void batchdelete(){
        //todo
        service.user.api.Users users=new service.user.api.Users();
        ArrayList<String> useridlist=new ArrayList<>();
        //先批量创建用户
        for (int i = 0; i <5 ; i++) {
            String userid="userid"+System.currentTimeMillis();
            String name="liuqi"+System.currentTimeMillis();
            HashMap<String,Object> data=new HashMap<>();
            data.put("userid",userid);
            data.put("name",name);
            data.put("mobile",String.valueOf(System.currentTimeMillis()).substring(0,11));
            data.put("email",String.valueOf(System.currentTimeMillis()).substring(0,11));
            //调用模板数据
            users.clone(data).then().body("errcode",equalTo(0));
            //调用用户列表
            users.getUseList(userid).then().body("errcode",equalTo(0));
            //添加到list中
            useridlist.add(userid);
        }
        //将list放在map中，进行批量删除用户
        HashMap<String,Object> data=new HashMap<>();
        data.put("useridlist",useridlist);
        //批量删除
        int department_id=2;
        users.batchdelete(data).then().body("errmsg",equalTo("deleted"));
        users.simplelist(department_id).then().body("errcode",equalTo(0));
    }

    @DisplayName("获取部门成员")
    @Test
    public void simplelist(){
        int department_id=2;
        HashMap<String,Object> data=new HashMap<>();
        data.put("department_id",department_id);
        service.user.api.Users users=new service.user.api.Users();
        users.simplelist(data).then().body("errcode",equalTo(0));
    }

}
