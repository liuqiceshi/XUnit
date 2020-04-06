package coverage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author liuqi
 * @Date 20/4/6 21:22
 * @Version 1.0
 * @Description:
 */
class LoginCoverageTest {

    LoginCoverage loginCoverage =new LoginCoverage();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("用户名和密码不能为空值或者空对象")
    void loginServiceFail() {
       String actual= loginCoverage.loginService("","");
        assertEquals("用户名和密码不能为空值或者空对象", actual);
    }
    @DisplayName("用户名和密码正确,登录成功")
    @Test
    void loginServiceSuccess(){
        String actual= loginCoverage.loginService("admin","123456");
        assertEquals("用户名和密码正确,登录成功", actual);
    }
    @DisplayName("用户名和密码不正确")
    @Test
    void loginServiceFail2(){
        String actual= loginCoverage.loginService("adminTest","123456Test");
        assertEquals("用户名和密码不正确", actual);
    }
}