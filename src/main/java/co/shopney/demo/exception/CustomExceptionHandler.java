package co.shopney.demo.exception;

import co.shopney.demo.core.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j @ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    log.error("Server Error: " + ex.getLocalizedMessage());
    return new ResponseEntity<>(GenericResponse.internal(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnauthorizedException.class)
  public final ResponseEntity<Object> handleRecordNotFoundException(UnauthorizedException ex, WebRequest request) {
    log.error("Authentication Error: " + ex.getLocalizedMessage());
    return new ResponseEntity<>(GenericResponse.unauthorized(), HttpStatus.UNAUTHORIZED);
  }
}
