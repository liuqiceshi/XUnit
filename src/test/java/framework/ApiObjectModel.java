package framework;


import io.restassured.response.Response;

import java.util.HashMap;

/**
 * @Author liuqi
 * @Date 20/1/17 14:39
 * @Version 1.0
 * @Description:
 */
public class ApiObjectModel {
    //PO模型
    public HashMap<String, ApiMethodModel> methods = new HashMap<>();

    public ApiMethodModel getMethod(String method) {
        return methods.get(method);
    }

    /**
     * run方法只有method参数
     * @param method
     * @return
     */
    public Response run(String method) {
       /* if (methods != null && methods.size() > 0) {
            System.out.println("url=======:"+methods.get(method).url);
        } else {
            System.out.println("methods为空");
        }
        System.out.println("打印method========"+method);*/
        return getMethod(method).run();
    }


    /**
     * run方法 method和params
     * @param method2
     * @param params
     * @return
     */
    public Object run(String method2, HashMap<String, Object> params) {
        return getMethod(method2).run(params);

    }
}
