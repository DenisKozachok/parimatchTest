package parimatch.apiClients;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {
    public static final String BASE_URL = "https://api.openbrewerydb.org";

    @Step
    protected RequestSpecification setup() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }
}
