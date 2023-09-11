package by.refor.mobilefarm.exception;

import lombok.Data;

@Data
public class ExceptionResponseBody {
    private String errorMessage;
    private String errorCode;
    private Object value;

    public ExceptionResponseBody(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public ExceptionResponseBody(String errorMessage, String errorCode, Object value) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.value = value;
    }
}
