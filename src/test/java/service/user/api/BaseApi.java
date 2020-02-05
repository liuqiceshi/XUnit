package service.user.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import framework.ApiObjectModel;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @Author liuqi
 * @Date 20/1/17 14:42
 * @Version 1.0
 * @Description:
 */
public class BaseApi {

    ApiObjectModel  apiObjectModel=new ApiObjectModel();
    HashMap<String, Object> params;

    //获取需要替换的参数
    public void setParams(HashMap<String, Object> datas) {
        params=datas;
    }

    public Response parseSteps(){
        String method2=Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println("method2=========:"+method2);

        if (apiObjectModel.methods.entrySet().isEmpty()){
            System.out.println("yaml first laod");

            String path = "/" + this.getClass().getCanonicalName().replace('.', '/') + ".yaml";
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            //mapper序列化设置为false
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            try {
//                System.out.println("=========apiObjectModel前=======");
//                System.out.println( "liuqi=========="+BaseApi.class.getResourceAsStream(path).toString());
                InputStream is = BaseApi.class.getResourceAsStream(path);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int i;
                while ((i = is.read()) != -1) {
                    baos.write(i);
                }
                String str = baos.toString();
                System.out.println("yaml文件内容：===="+str);
                apiObjectModel = mapper.readValue(BaseApi.class.getResourceAsStream(path), ApiObjectModel.class);
//              System.out.println("=========apiObjectModel后=======");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (Response) apiObjectModel.run(method2,params);



//        String className=Thread.currentThread().getStackTrace()[2].getClassName();
//        System.out.println("==================className=========:"+className);
//        String method0=Thread.currentThread().getStackTrace()[0].getMethodName();
//        System.out.println("==================method0=========:"+method0);
//        String method1=Thread.currentThread().getStackTrace()[1].getMethodName();
//        System.out.println("==================method1=========:"+method1);
//        String method2=Thread.currentThread().getStackTrace()[2].getMethodName();
//        System.out.println("==================method2=========:"+method2);
//        String method3=Thread.currentThread().getStackTrace()[3].getMethodName();
//        System.out.println("==================method3=========:"+method3);
//        String method4=Thread.currentThread().getStackTrace()[4].getMethodName();
//        System.out.println("==================method4=========:"+method4);
//        String method5=Thread.currentThread().getStackTrace()[5].getMethodName();
//        System.out.println("==================method5=========:"+method5);



    }


    //getStackTrace学习
    @Test
    public void stepsTest(){
        System.out.println("我是stepsTest方法");
        steps();

    }
    public void steps(){
        System.out.println("我是steps方法");
        parseSteps();
    }


}
