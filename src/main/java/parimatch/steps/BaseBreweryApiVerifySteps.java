package parimatch.steps;

import org.assertj.core.api.Condition;
import parimatch.apiClients.ApiResponse;
import parimatch.models.BaseDTO;
import parimatch.models.BreweryDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public abstract class BaseBreweryApiVerifySteps<T extends ApiResponse<? extends BaseDTO>, N extends BaseBreweryApiVerifySteps<T, N>>
        extends BaseApiVerifySteps<T, N> {

    public BaseBreweryApiVerifySteps(T response) {
        super(response);
    }

    protected void verifyBreweryDTO(BreweryDTO breweryDTO) {
        assertSoftly(softly -> {
            softly.assertThat(breweryDTO.getId())
                    .as("BreweryDTO -> 'Id' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getName())
                    .as("BreweryDTO -> 'Name' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getBreweryType())
                    .as("BreweryDTO -> 'Brewery Type' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getStreet())
                    .as("BreweryDTO -> 'Street' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getCity())
                    .as("BreweryDTO -> 'City' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getState())
                    .as("BreweryDTO -> 'State' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getPostalCode())
                    .as("BreweryDTO -> 'Postal Code' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getCountry())
                    .as("BreweryDTO -> 'Country' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getPhone())
                    .as("BreweryDTO -> 'Phone' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getWebsiteUrl())
                    .as("BreweryDTO -> 'Website Url' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getCreatedAt())
                    .as("BreweryDTO -> 'Created At' should not be null")
                    .isNotNull();
            softly.assertThat(breweryDTO.getUpdatedAt())
                    .as("BreweryDTO -> 'Updated At' should not be null")
                    .isNotNull();
        });
    }

    protected void verifyBreweryHasQuery(BreweryDTO breweryDTO, String query) {
        assertThat(breweryDTO.containsQuery(query))
                .as("BreweryDTO should contain query");
    }
}
