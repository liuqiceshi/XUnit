package service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @Author liuqi
 * @Date 20/1/6 14:58
 * @Version 1.0
 * @Description:
 */
public class Work {
    //公共地址
   public static  String baseUrl="https://qyapi.weixin.qq.com/cgi-bin";
   public static String corpid="wwba4073edf8ccf28d";
   public static String corpsecret="MyNy688YygBDO39LP7H95E-Cqp-Z3_AVs5sR0d4fdwA";

   //标签列表路径
    public static String tagsListPath="/tag/list";
    //创建标签路径
    public  static String tagsCreatePath="/tag/create";
    //删除标签路径
    public static String tagsDeletePath="/tag/delete";
    //获取用户列表路径
    public static String userGetPath="/user/get";
    //获取用户更新路径
    public  static String userUpdatePath="/user/update";
    //创建用户路径
    public static String userCreatePath="/user/create";
    //删除用户路径
    public static String userDeletePath="/user/delete";
    //获取部门成员
    public static String simplelistPath="/user/simplelist";
    //批量删除成员
    public static String batchdeletePath="/user/batchdelete";

    //access_token
      String access_token;
    //获取access_token路径
    static String gettokenPath="/gettoken";
    private static Work work;

      public static  Work getInstance(){
          if (work==null ){
              work=new Work();
          }
          return work;
      }

    //创建部门路径
    public String getToken(){
          if (access_token==null) {
              access_token= given()
                      .param("corpid", corpid)
                      .param("corpsecret", corpsecret)
              .when().log().all()
                      .get(baseUrl + gettokenPath)
              .then().log().all()
                      .body("errcode", equalTo(0))
                      .body("errmsg", equalTo("ok"))
                      .extract()
                      .body().path("access_token");
             // System.out.println("token++++++" + access_token);
          }
          return access_token;

    }

    public static void main(String[] args){
        System.out.println("access_token:"+Work.getInstance().getToken());
    }
}
