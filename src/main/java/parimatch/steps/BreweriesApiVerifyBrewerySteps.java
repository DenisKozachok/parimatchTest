package parimatch.steps;

import io.qameta.allure.Step;
import parimatch.apiClients.ApiResponse;
import parimatch.models.BreweryDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreweriesApiVerifyBrewerySteps extends BaseBreweryApiVerifySteps<ApiResponse<BreweryDTO>, BreweriesApiVerifyBrewerySteps> {

    public BreweriesApiVerifyBrewerySteps(ApiResponse<BreweryDTO> response) {
        super(response);
    }

    @Step("BreweriesApi: Verify structure of BreweriesDTO")
    public BreweriesApiVerifyBrewerySteps verifyStructure() {
        List<BreweryDTO> breweriesDTO = getResponse().getListDTO();
        breweriesDTO.forEach(this::verifyBreweryDTO);
        return this;
    }

    @Step("BreweriesApi: Verify BreweriesDTO contain qeury")
    public BreweriesApiVerifyBrewerySteps verifyHaveQuery(String query) {
        List<BreweryDTO> breweriesDTO = getResponse().getListDTO();
        breweriesDTO.forEach(brewery -> verifyBreweryHasQuery(brewery, query));
        return this;
    }

    @Step("BreweriesApi: Verify BreweriesDTO has size")
    public BreweriesApiVerifyBrewerySteps verifyHasSize(int size) {
        List<BreweryDTO> breweriesDTO = getResponse().getListDTO();
        assertThat(breweriesDTO)
                .as("Breweries should have size")
                .hasSize(size);
        return this;
    }
}
