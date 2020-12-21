package parimatch.steps;

import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import parimatch.apiClients.ApiResponse;
import parimatch.models.BaseDTO;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class ResponseVerificationSteps<T extends BaseDTO> {
    private final ApiResponse<T> response;

    @Step("Response code should be equal to expected")
    public ResponseVerificationSteps<T> verifyStatusCode(int expectedStatusCode) {
        assertThat(response.getStatusCode())
                .as("Response code should be equal to expected")
                .isEqualTo(expectedStatusCode);
        return this;
    }
}
