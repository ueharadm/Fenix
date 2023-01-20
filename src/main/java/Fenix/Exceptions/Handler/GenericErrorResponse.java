package Fenix.Exceptions.Handler;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

public class GenericErrorResponse implements ErrorResponse {
    private String message;
    private String worshipfulMasterId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWorshipfulMasterId() {
        return worshipfulMasterId;
    }

    public void setWorshipfulMasterId(String worshipfulMasterId) {
        this.worshipfulMasterId = worshipfulMasterId;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return HttpStatusCode.valueOf(404);
    }

    @Override
    public ProblemDetail getBody() {
        return ProblemDetail.forStatus(404);
    }
}