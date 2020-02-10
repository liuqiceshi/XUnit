package framework;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import service.Work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

/**
 * @Author liuqi
 * @Date 20/1/17 14:41
 * @Version 1.0
 * @Description:
 */
public class ApiMethodModel {
    public HashMap<String, Object> query;
    public HashMap<String, Object> header;
    public HashMap<String, Object> postBody;
    public String postBodyRaw;
    //pos get
    public String method = "get";
    public String url;
    public HashMap<String, Object> params;

    public Response run() {
        RequestSpecification request = given();
        request.queryParam("access_token", Work.getInstance().getToken());

        if (query != null) {
            Set<HashMap.Entry<String, Object>> entries = query.entrySet();
            for (HashMap.Entry<String, Object> entry : entries) {
                request.queryParam(entry.getKey(), replace(entry.getValue().toString()));
            }
        }
        if (header != null) {
            Set<HashMap.Entry<String, Object>> entries = header.entrySet();
            for (HashMap.Entry<String, Object> entry : entries) {
                request.header(entry.getKey(), replace(entry.getValue().toString()));
            }
        }
        if (postBody!=null){
            //todo replace HashMap 递归算法替换参数
            request.body(postBody);
        }
        if(postBodyRaw!=null){
            request.body(replace(postBodyRaw));
        }
        System.out.println("request============:"+request);
        return request
                .when().log().all()
                .request(method,url)
                .then().log().all()
                .extract().response();
    }
    /**
     * 处理需要替换的参数
     * @param params
     * @return
     */
    public Object run(HashMap<String, Object> params) {
        this.params=params;
        return run();

    }

    /**
     * 替换yaml文件中变量值{{}}
     * @param raw
     * @return
     */
    public String replace(String raw){

            Set<HashMap.Entry<String, Object>> entries = params.entrySet();
            for (HashMap.Entry<String, Object> entry : entries) {
                String matcher="${"+entry.getKey()+"}";
                if (raw.contains(matcher)){
                    System.out.println("matcher========"+matcher);
                    System.out.println("raw==========="+raw);
                    raw=raw.replace(matcher,entry.getValue().toString());
                    System.out.println("raw==========="+raw);
                }
            }

        return raw;
    }




    @Test
    public void HashMapTest(){
        //map
        Map<Integer,String> map =new HashMap();
        map.put(1,"zhangsan");
        map.put(2,"lisi");
        map.put(3,"wangwu");
        map.put(4,"zhangsan");
        //通过entrySet获取key和value的值
        Set<Map.Entry<Integer, String>> entries=map.entrySet();
        for(Map.Entry<Integer,String> entry:entries){
            System.out.println("key值："+entry.getKey()+"value值："+entry.getValue());

        }
    }
}
