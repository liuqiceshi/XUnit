package coverage;

/**
 * @Author liuqi
 * @Date 20/4/6 20:54
 * @Version 1.0
 * @Description:
 */
public class LoginCoverage {

    public  String  loginService(String username, String password) {

        if (username == null || "".equals(username)||password == null || "".equals(password)) {
            return "用户名和密码不能为空值或者空对象";
        } else if ("admin".equals(username) && "123456".equals(password)) {
            return "用户名和密码正确,登录成功";
        }
         return "用户名和密码不正确";
        }
    }

