package com.endava.Twitter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class TwitterTest {

    String ApiKey = "Q1EmXFX1Li9RT52qaYcst0Jeu";
    String ApiSecret = "qyL7ib1q75aZm0DZngaUWhKg3KcBr1lMv06t5l5vOZCcHtw5P5";
    String AccessToken = "278136668-9oPX13k1xCZqJUAyR7VcO4w4xo4l0wKDGdL6JdfA";
    String AccessSecret = "GvHligKLxmUJmGejFLrTKvJ7lyToFen4Ct8iDwjGFJuPq";
    String TweetId;
    String id1;

    @Test
    public void CreateTweet() {

        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

        Response Resp =	given().
                auth().oauth(ApiKey, ApiSecret, AccessToken, AccessSecret).
                queryParam("status", "Twitter API Testing").log().all().
                when().
                post("/update.json").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        String CreateTweet=Resp.asString();
        JsonPath js=new JsonPath(CreateTweet);

        System.out.println("id is"+js.get("id"));

        TweetId=(js.get("id")).toString();

        System.out.println("Id of newly Created Tweet is \t"+TweetId);
    }

/*    public void DeleteTweet() {

        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

        Response Resp = given().
                auth().oauth(ApiKey, ApiSecret, AccessToken, AccessSecret).
                when().
                post("/destroy/"+TweetId+".json").
                then().assertThat().statusCode(200).log().all().
                extract().response();

        String DelTwe=Resp.asString();
        JsonPath js1=new JsonPath(DelTwe);

        logger.info("Deleted Tweet id is"+js1.get("id"));

        id1=(js1.get("id")).toString();

        logger.info("Tweet has been Delted Sucesfully\t"+id1);


    }
*/
}
