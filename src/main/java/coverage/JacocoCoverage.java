package coverage;

/**
 * @Author liuqi
 * @Date 20/4/6 17:37
 * @Version 1.0
 * @Description:
 */
public class JacocoCoverage {
    public Integer divid(Integer a, Integer b) {
        if (b == 0) {
            return null;
        } else if (a > 100) {
            return null;
        } else if (a < b) {
            return 0;
        } else {
            return a / b;
        }
    }

}
