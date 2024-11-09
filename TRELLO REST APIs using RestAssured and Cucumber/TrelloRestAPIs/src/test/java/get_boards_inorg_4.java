import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class get_boards_inorg_4 {

    Enviroment proj_variable=new Enviroment();


    @Test
    public void get_board_inorg() {
        //'https://api.trello.com/1/organizations/{id}/boards?key=APIKey&token=APIToken'

        Enviroment proj_variable=new Enviroment();
        RestAssured.baseURI="https://api.trello.com";
        RequestSpecification request=RestAssured.given();
        request.basePath("/1/organizations/"+proj_variable.getOrganization_id()+"/boards");
        request.header("Content-Type","application/json");
        request.queryParam("token",proj_variable.getToken());
        request.queryParam("key",proj_variable.getKey());

        Response response=request.get();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of get boards in organization is :"+response.getStatusCode());

    }
}
