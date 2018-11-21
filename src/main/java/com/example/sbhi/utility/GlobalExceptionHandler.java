package com.example.sbhi.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.sbhi.exception.BadRequestException;
import com.example.sbhi.service.SleuthService;


//@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private SleuthService sleuthSvc;

    /**
     * Method for handling global IllegalArgumentException, BadRequestException and
     * MethoArgumentNotValidException.
     * 
     * @param ex
     *            Exception
     * @return - Returns ResponseEntity of ARServerResponse
     */
    /*@ExceptionHandler({ IllegalArgumentException.class, BadRequestException.class,
            HttpMessageNotReadableException.class, HttpClientErrorException.class })
    public ResponseEntity<Result<String>> handleExceptions(final Exception ex) {

        LOGGER.error(Constants.BAD_REQUEST_ERROR_CODE, ex);

        Result<String> result = new Result<>();
        result.setResponseMessage(RelationshipServiceUtility
                .createBadReqResponseMessage(sleuthSvc.getSpanId(), ex.getMessage()));

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }*/

    /**
     * Method for handling global Exception.
     * 
     * @param ex
     *            A Exception
     * @return - Returns ResponseEntity of Result&lt;String&gt;
     */
   /* @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Result<String>> handleAnyException(final Exception ex) {

        LOGGER.error(Constants.INTERNAL_SERVER_ERROR_CODE, ex);

        Result<String> result = new Result<>();
        result.setResponseMessage(RelationshipServiceUtility
                .createInternalServerResponseMessage(sleuthSvc.getSpanId(), ex.getMessage()));

        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    /**
     * Method for handling 404 Exception.
     * 
     * @param ex
     *            Exception
     * @return - Returns ResponseEntity of Result&lt;String&gt;
     */
    /*@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Result<String>> handleError404(final Exception ex) {

        Result<String> result = new Result<>();
        result.setResponseMessage(RelationshipServiceUtility.createResponseMessage(
                HttpStatus.NOT_FOUND.toString(), ex.getMessage(), sleuthSvc.getSpanId()));

        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }*/

    /**
     * Method for handling global MethodArgumentNotValidException.
     * 
     * @param ex
     *            Exception
     * @return - Returns Result&lt;String&gt;
     */
   /* @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<String> validationErr(final MethodArgumentNotValidException ex) {

        LOGGER.error(Constants.BAD_REQUEST_ERROR_CODE, ex);

        String errorMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Result<String> result = new Result<>();
        result.setResponseMessage(RelationshipServiceUtility
                .createBadReqResponseMessage(sleuthSvc.getSpanId(), errorMessage));
        return result;
    }*/

    /**
     * Method for handling 405 MethodNotSupportedException Exception.
     * 
     * @param ex
     *             HttpRequestMethodNotSupportedExceptionException
     * 
     * @return - Returns ResponseEntity of Result&lt;String&gt;
     */
   /* @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Result<String>> handleMethodNotSupportedException(
            final HttpRequestMethodNotSupportedException ex) {

        Result<String> result = new Result<>();
        result.setResponseMessage(RelationshipServiceUtility.createResponseMessage(
                HttpStatus.METHOD_NOT_ALLOWED.toString(), ex.getMessage(), sleuthSvc.getSpanId()));

        return new ResponseEntity<>(result, HttpStatus.METHOD_NOT_ALLOWED);
    }*/
}
