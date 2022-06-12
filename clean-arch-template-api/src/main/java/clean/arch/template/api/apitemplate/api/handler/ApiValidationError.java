package clean.arch.template.api.apitemplate.api.handler;

import lombok.Data;

@Data
public class ApiValidationError {

    private String field;
    private String message;

    ApiValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
