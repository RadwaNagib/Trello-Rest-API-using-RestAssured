import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_lists_in_board_6 {

    @Test
    public void get_list_inboard() {
        Enviroment proj_variable=new Enviroment();

        //https://api.trello.com/1/boards/{id}/lists?key=APIKey&token=APIToken

        RestAssured.baseURI="https://api.trello.com";
        RequestSpecification request=RestAssured.given();
        request.basePath("/1/boards/"+proj_variable.getBoard_id()+"/lists");
        request.queryParam("name","list1");

        request.queryParam("key",proj_variable.getKey());
        request.queryParam("token",proj_variable.getToken());

        request.header("Accept","application/json");

        Response response=request.get();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of get lists in board id :"+response.getStatusCode());
    }
}
