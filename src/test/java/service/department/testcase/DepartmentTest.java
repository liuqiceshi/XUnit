package service.department.testcase;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.department.api.Department;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * @Author liuqi
 * @Date 20/1/6 14:34
 * @Version 1.0
 * @Description:
 */
public class DepartmentTest {
    static  Department department=new Department();

    @BeforeAll
    public static void beforAll(){
        /**
         * 1、case执行之前先要清理数据
         * 2、用list方法根据parentid通过findAll查询出所有子部门ids
         * 3、调用删除方法根据ids进行删除子部门
         */
        ArrayList<Integer> ids = department.list(department.parentid)
                .then()
                .extract()
                .body()
                .path("department.findAll{d->d.parentid=="+department.parentid+"}.id");

        System.out.println("ids删除之前数组大小===================:"+ids);
        ids.forEach(id->department.delete(id));

    }

    @Test
    public void list(){
        department.list(department.parentid).then().body("errmsg",equalTo("ok"));
    }

    @DisplayName("create创建")
    @Test()
    public void create(){
      String name="六七测试组";
        //创建部门
        department.create(name,department.parentid)
                   .then()
                    .body("errcode",equalTo(0))
                    .body("errmsg",equalTo("created"));

      // find 或者findAll断言hasSize
     department.list(department.parentid)
             .then()
             .body("department.findAll{d->d.name=='"+name+"'}.id",hasSize(1));

    }

    @Test
    public void delete(){
        //创建部门
        int id=department.create("部门3",department.parentid)
                .then()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("created"))
                .extract().body().path("id");
        System.out.println("id=================:"+id);
        department.delete(id).then().body("errcode",equalTo(0))
                .body("errmsg",equalTo("deleted"));

    }


}
