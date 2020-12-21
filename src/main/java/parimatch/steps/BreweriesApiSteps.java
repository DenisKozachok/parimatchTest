package parimatch.steps;

import io.qameta.allure.Step;
import parimatch.apiClients.BreweryApiClient;

public class BreweriesApiSteps {
    BreweryApiClient breweryApiClient = new BreweryApiClient();

    @Step("BreweriesApi: search breweries")
    public BreweriesApiVerifyBrewerySteps searchBreweries(String query) {
        return new BreweriesApiVerifyBrewerySteps(breweryApiClient.searchBrewery(query));
    }
}
