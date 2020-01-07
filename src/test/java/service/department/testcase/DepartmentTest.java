package service.department.testcase;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.department.api.Department;

import static org.hamcrest.Matchers.equalTo;

/**
 * @Author liuqi
 * @Date 20/1/6 14:34
 * @Version 1.0
 * @Description:
 */
public class DepartmentTest {
    Department department=new Department();

    @BeforeAll
    public static void beforAll(){



    }

    @Test
    public void list(){
        department.list(department.parentid).then().body("errmsg",equalTo("ok"));
    }

    @DisplayName("根据部门parentid创建子部门")
    @Test()
    public void create(){
        department.create("api部门",department.parentid)
                  .then()
                    .body("errcode",equalTo(0))
                    .body("errmsg",equalTo("created"));
        department.list(department.parentid).then().body("errmsg",equalTo("ok"));


    }

    @Test
    public void delete(){


    }


}
