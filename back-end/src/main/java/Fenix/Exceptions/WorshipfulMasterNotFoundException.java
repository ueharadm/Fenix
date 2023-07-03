package Fenix.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorshipfulMasterNotFoundException extends RuntimeException {
    private final Integer worshipfulMasterId;

    public WorshipfulMasterNotFoundException(Integer worshipfulMasterId) {
        super(String.format("WorshipfulMaster with id %d not found", worshipfulMasterId));
        this.worshipfulMasterId = worshipfulMasterId;
    }

    public Integer getWorshipfulMasterId() {
        return worshipfulMasterId;
    }
}
