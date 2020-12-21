package parimatch.apiClients;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import parimatch.models.BreweryDTO;

public class BreweryApiClient extends BaseApiClient{
    private static final String SEARCH_ENDPOINT = "/breweries/search";

    @Step
    public ApiResponse<BreweryDTO> searchBrewery(String name) {
        Response response = setup()
                .queryParam("query", name)
                .when()
                .get(SEARCH_ENDPOINT)
                .then().extract().response();
        return new ApiResponse<>(response, BreweryDTO.class);
    }
}
