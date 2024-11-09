import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete_organization_9 {


    @Test
    public void delete_organization() {

        Enviroment proj_variable=new Enviroment();

        //https://api.trello.com/1/organizations/{id}?key=APIKey&token=APIToken
        RestAssured.baseURI="https://api.trello.com";

        RequestSpecification request=RestAssured.given();
        request.basePath("/1/organizations/"+proj_variable.getOrganization_id()+"");
        request.header("Content-Type","application/json");

        request.queryParam("key",proj_variable.getKey());
        request.queryParam("token",proj_variable.getToken());
        request.queryParam("value","true");

        Response response=request.delete();
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("the status code of delete organization is :"+response.getStatusCode());

    }
}
