package service.filter;

import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @Author liuqi
 * @Date 20/1/13 23:38
 * @Version 1.0
 * @Description:
 */
public class FilterTest {


    @Test
    void filterAlterRequest() {
        given().filter((req, res, ctx) -> {

            //请求加密 req.getBody()
            req.queryParam("token", "xxxxx");
            req.path("/user_error.json");
            req.baseUri("http://127.0.0.1:8000");
            System.out.println(req.getURI());
            Response resReal = ctx.next(req, res);
            System.out.println(resReal.getStatusLine());
            return resReal;
        })
                .when().log().all().get("http://127.0.0.1:8000/user.json")
                .then().log().all().statusCode(200);
    }

    @Test
    void filterAlterResponse() {
        given().filter((req, res, ctx) -> {
            Response resOrigin = ctx.next(req, res);

            String bodyNew = resOrigin.getBody().asString().replace("\"userid\": \"seveniruby\",", "\"userid\": null,");
            ResponseBuilder responseBuilder = new ResponseBuilder().clone(resOrigin);
            responseBuilder.setBody(bodyNew);
            return responseBuilder.build();
        })
                .when().log().all().get("http://127.0.0.1:8000/user.json")
                .then().log().all().statusCode(200);
    }
}
