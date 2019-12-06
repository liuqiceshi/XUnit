package mobile.testcase;


import mobile.page.App;
import mobile.page.SearchPage;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestSearch {

    public static SearchPage searchPage;

    @BeforeClass
    public static void beforeAll() throws MalformedURLException {
        App.start();
        searchPage=App.toSearch();
    }
    @Test
    public void search(){
        assertThat(searchPage.search("alibaba").getStockList(), equalTo("阿里巴巴"));
       // assertThat(searchPage.search("alibaba").getCurrentPrice(), greaterThanOrEqualTo(120f));

    }
}
