import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Archive_list_7 {

    @Test
    public void archive_list() {
        //https://api.trello.com/1/lists/{id}/closed?key=APIKey&token=APIToken

        Enviroment proj_variable=new Enviroment();

        RestAssured.baseURI="https://api.trello.com";

        RequestSpecification request=RestAssured.given();
        request.basePath("/1/lists/"+proj_variable.getList_id()+"/closed");

        request.header("Accept","application/json");

        request.queryParam("key",proj_variable.getKey());
        request.queryParam("token",proj_variable.getToken());
        request.queryParam("value","true");


        Response response=request.put();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of archive the list is:"+response.getStatusCode());
    }
}
