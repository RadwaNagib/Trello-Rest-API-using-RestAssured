import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class create_new_list_5 {

    Enviroment proj_variable=new Enviroment();
    @Test
    public void create_new_list() {
       //https://api.trello.com/1/lists?name={name}&idBoard=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken
        RestAssured.baseURI="https://api.trello.com/1/lists";

        RequestSpecification request=RestAssured.given();

        request.header("Content-Type","application/json");
        request.queryParam("name","{list1}");
        request.queryParam("idBoard",proj_variable.getBoard_id());

        request.queryParam("key",proj_variable.getKey());
        request.queryParam("token",proj_variable.getToken());


        Response response=request.post();
        response.prettyPrint();

        JsonPath path=response.jsonPath();

      String idlist=path.getString("id");
      proj_variable.setList_id(idlist);

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of list id is "+response.getStatusCode());



    }
}
