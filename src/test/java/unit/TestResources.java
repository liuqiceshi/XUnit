package unit;

import org.junit.Test;

public class TestResources {
    @Test
    public void readFile(){
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getResource("/app/TestStock.yaml"));
        System.out.println(
                //FileUitls.read
        );
    }
}
