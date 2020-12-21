package parimatch.steps;

import lombok.RequiredArgsConstructor;
import parimatch.apiClients.ApiResponse;
import parimatch.models.BaseDTO;

import static org.apache.http.HttpStatus.SC_OK;

@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public abstract class BaseApiVerifySteps<T extends ApiResponse<? extends BaseDTO>, N extends BaseApiVerifySteps<T, N>>{
    private final T response;

    public T getResponse() {
        return response;
    }

    public N verifyGetResponse() {
        return verifyResponse(SC_OK);
    }

    private N verifyResponse(int statusCode) {
        getResponse().verifyResponse(response ->
                response.verifyStatusCode(statusCode));
        return (N) this;
    }
}
