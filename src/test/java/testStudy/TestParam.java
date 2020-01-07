package testStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//参数化
@RunWith(Parameterized.class)
public class TestParam {
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {1,2},
                {3,4}
        });
    }
    public int actual;

    @Test
    public void testDemo(){
        int actual=10;
        int expection=9;

       // assertThat("demo",actual,equals(expection));
    }
}
