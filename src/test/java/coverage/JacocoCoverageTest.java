package coverage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @Author liuqi
 * @Date 20/4/6 17:41
 * @Version 1.0
 * @Description:
 */
class JacocoCoverageTest {

    JacocoCoverage jacocoCoverage =new JacocoCoverage();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void divid() {
        assertThat(jacocoCoverage.divid(1, 2), equalTo(0));
    }
    @Test
    public void dividByZero(){

        assertThat(jacocoCoverage.divid(100, 0), equalTo(null));
    }

}