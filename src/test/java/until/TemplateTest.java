package until;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

/**
 * @Author liuqi
 * @Date 20/1/20 10:40
 * @Version 1.0
 * @Description:
 */
public class TemplateTest {

    //模板
    public    String template(String path, HashMap<String,Object> data)  {
        Writer writer = new StringWriter();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(this.getClass().getResource(path).getPath());
        mustache.execute(writer, data);

        try {
            // System.out.println("flush前");
            writer.flush();
            // System.out.println("flush后");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer.toString();

    }

}
