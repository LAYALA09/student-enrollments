package ar.com.learning.University.advice;

import ar.com.learning.University.advice.validation.RestErrorsResponse;
import ar.com.learning.University.exception.BusinessLogicException;
import ar.com.learning.University.exception.EntityError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;

@RestControllerAdvice
public class BusinessLogicExceptionHandler {
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity handleBusinessLogicException(BusinessLogicException e, NativeWebRequest req) {

        HttpStatus httpStatus = e.getHttpStatus() != null
                ? e.getHttpStatus()
                : HttpStatus.INTERNAL_SERVER_ERROR;

        RestErrorsResponse restErrorsResponse = new RestErrorsResponse<EntityError>(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getEntityErrors()
        );

        return ResponseEntity
                .status(httpStatus)
                .body(restErrorsResponse);

    }
}
