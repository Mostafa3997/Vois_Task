package TC;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.Argument;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class TC_02 {


  @Test
  public void getUserID() {
    Response response = given()
            .when()
            .get("https://jsonplaceholder.typicode.com/users?id=2")
            .then()
            .assertThat()
            .statusCode(200).
            extract().
            response();
    String responseInString = response.asString();
    System.out.println(responseInString);
    JsonPath jsonPath = new JsonPath(responseInString);
    String emailAddress = jsonPath.getString("email");
    System.out.println(emailAddress);
  }

  @Test
  public void userPost_Using_UserID() {
    Response response =
            given().
                    contentType(ContentType.JSON)
                    .when()
                    .get("https://jsonplaceholder.typicode.com/posts?userId=2")
                    .then().
                    assertThat()
                    .statusCode(200).log().all().
                    extract().
                    response();
    String responseInString = response.asString();
    System.out.println(responseInString);
    JsonPath jsonPath = new JsonPath(responseInString);
    String userPosts = jsonPath.getString("title");
    System.out.println(userPosts);



  }


}
