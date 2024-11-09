import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class createorganization_1 {

@Test
public void createorganization()
{
    Enviroment proj_variable=new Enviroment();

//https://api.trello.com/1/organizations?displayName={displayName}&key=APIKey&token=APIToken'
    RestAssured.baseURI = "https://api.trello.com/1/organizations";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        request.queryParam("displayName", "{org_trello}");
        request.queryParam("token", proj_variable.getToken());
        request.queryParam("key",proj_variable.getKey());

        Response response = request.post();
        response.prettyPrint();
        JsonPath path= response.jsonPath();

        String organization_id=path.getString("id");
        System.out.println("organization id is"+organization_id);
        proj_variable.setOrganization_id(organization_id);

        System.out.println("the organization id is"+proj_variable.getOrganization_id());
        int statuscode=response.getStatusCode();
        Assert.assertEquals(statuscode,200);
        System.out.println("the status code is :"+statuscode);


     }

    }
