import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete_board_8 {


    @Test
    public void delete_board() {
        Enviroment proj_variable=new Enviroment();
        //https://api.trello.com/1/boards/{id}?key=APIKey&token=APIToken

        RestAssured.baseURI="https://api.trello.com";

        RequestSpecification request=RestAssured.given();
        request.basePath("/1/boards/"+proj_variable.getBoard_id()+"");
        request.header("Content-Type","application/json");

        request.queryParam("key",proj_variable.getKey());
        request.queryParam("token",proj_variable.getToken());
        request.queryParam("value","true");

        Response response=request.delete();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of Delete board is :"+response.getStatusCode());


    }
}
