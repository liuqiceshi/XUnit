package service.user.testcase;


import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * @Author liuqi
 * @Date 20/1/14 22:05
 * @Version 1.0
 * @Description:
 */
public class TemplateTest {
    @Test
    public void template() throws IOException {
        HashMap<String, Object> data = new HashMap<String, Object>();
        /*scopes.put("name", "Mustache");
        scopes.put("feature", "Perfect!");*/
        data.put("userid","userid"+System.currentTimeMillis());
        data.put("name","liuqi"+System.currentTimeMillis());

        Writer writer = new OutputStreamWriter(System.out);
        MustacheFactory mf = new DefaultMustacheFactory();
        //Mustache mustache = mf.compile(new StringReader("{{name}}, {{feature.description}}!"), "example");
//        /Users/liuqi/360yunpan/workspace/XUnit/src/main/resources/template/user.json
        Mustache mustache = mf.compile(this.getClass().getResource("/template/user.json").getPath());
        mustache.execute(writer, data);
        writer.flush();
        System.out.println(writer.toString());
    }
}
