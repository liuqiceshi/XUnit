package service.department.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.department.api.TagManger;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

/**
 * @Author liuqi
 * @Date 20/1/8 00:08
 * @Version 1.0
 * @Description:
 */
public class TagsTest {
    static TagManger tagManger = new TagManger();

    @BeforeAll
    public static void beforAll() {
        ArrayList<Integer> tagIds = tagManger.list()
                .then()
                .body("errcode", equalTo(0))
                .body("errmsg", equalTo("ok"))
                .extract()
                .body()
                .path("taglist.tagid");

        System.out.println("tagIds==============:" + tagIds);
        tagIds.forEach(tagId->tagManger.delete(tagId));

    }
    //标签列表
    @Test
    public void list(){
        tagManger.list()
                .then()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("ok"));
    }

    //创建标签然后通过list断言是否存在
    @Test
    public void create(){
        String tagname="标签7";
        tagManger.create(tagname).then().body("errcode",equalTo(0)).body("errmsg",equalTo("created"));
        tagManger.list()
                .then()
                .body("taglist.tagname",hasItem(tagname));
    }
    //先创建标签再根据id删除标签
    @Test
    public void delete(){
        String tagname="标签6"+System.currentTimeMillis();
        int  tagid=tagManger.create(tagname).then()
                .body("errcode",equalTo(0))
                .body("errmsg",equalTo("created"))
                .extract()
                .body().path("tagid");
        System.out.println(tagid);
        tagManger.delete(tagid).then().body("errcode",equalTo(0)).body("errmsg",equalTo("deleted"));
    }

}