import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class create_board_inOrganization_3 {

    @Test
    public void create_board_inorg() {
      //https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken
        Enviroment proj_variable=new Enviroment();

        RestAssured.baseURI="https://api.trello.com/1/boards/";
        RequestSpecification request=RestAssured.given();
        request.queryParam("name","Myboard");
        request.queryParam("token",proj_variable.getToken());
        request.queryParam("key",proj_variable.getKey());

        request.header("Content-Type","application/json");

        Response response=request.post();
        response.prettyPrint();

        JsonPath path=response.jsonPath();
        String idbord=path.getString("id");
        proj_variable.setBoard_id(idbord);

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the statusCode of create board in organization is :"+response.getStatusCode());

    }
}
