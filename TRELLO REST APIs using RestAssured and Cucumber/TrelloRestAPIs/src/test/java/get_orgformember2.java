import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class get_orgformember2 {
    @Test
    public void get_orgformember()
     {

         //https://api.trello.com/1/members/me?key={{key}}&token={{token}}
         Enviroment proj_variable=new Enviroment();
         RestAssured.baseURI="https://api.trello.com/1/members/me";

        RequestSpecification request=RestAssured.given();

        request.header("Accept","application/json");

        request.queryParam("token",proj_variable.getToken());
        request.queryParam("key",proj_variable.getKey());

        Response response;
        response=request.get();
        response.prettyPrint();
         int statuscode=response.getStatusCode();
         Assert.assertEquals(statuscode,200);
         System.out.println("the status code is :"+statuscode);

    }
}
