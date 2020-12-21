package parimatch.apiClients;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import parimatch.models.BaseDTO;
import parimatch.steps.ResponseVerificationSteps;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class ApiResponse<T extends BaseDTO> {
    private final Response response;
    private final Class<T> clazz;
    private T responseDTO;
    private List<T> responseDTOs;

    public T getDTO() {
        if (null == responseDTO) {
            try {
                responseDTO = response.as(clazz);
            } catch (Exception e) {
                String msg = String.format("Unexpected response: %n%s", response.asString());
                throw new RuntimeException(msg, e);
            }
        }
        return responseDTO;
    }

    public List<T> getListDTO() {
        if (null == responseDTOs) {
            responseDTOs = response.jsonPath().getList(".", clazz);
        }
        return responseDTOs;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String asString() {
        return response.asString();
    }

    public ApiResponse<T> verifyResponse(Consumer<ResponseVerificationSteps<T>> consumer) {
        consumer.accept(new ResponseVerificationSteps<>(this));
        return this;
    }
}
