package dio.my_first_web_api.handler;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.UndeclaredThrowableException;
import java.net.http.HttpHeaders;

public class GlobalExceptionHandler {
    @Resource
    private MessageSource messageSource;
    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    private ResponseError responseError(String message, HttpStatus statusCode) {
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(message);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral (Exception e WebRequest request) {
        if (e.getClass().isAssignableFrom(UnderclaredThrowableException.class)) {
            UnderclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBussinesException((BussinesException) exception.getUnderclaredThrowableException(), request);
        } else {
            String message = messageSource.getMessage("error.server", new Object[] {e.getMessage}, null);
            ResponseError error = responseError(message,HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }
    @ExceptionHandler({BussinesException.class})
    private ResponseEntity<Object> handleBussinesException(BussinesException e, WebRequest request) {
        ResponseError error = ResponseError(e.getMessage(), HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }
}
