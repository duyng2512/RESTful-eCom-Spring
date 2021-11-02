package com.modern.api.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.modern.api.exception.common.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Locale;

@Slf4j
@ControllerAdvice
public class ApiExceptionAdvisor {

    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionAdvisor(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(HttpServletRequest httpServletRequest, Exception exception, Locale locale){
        Error error = Error.builder().errorCode(ErrorCode.GENERIC_ERROR.getErrCode())
                                    .message(ErrorCode.GENERIC_ERROR.getErrMsgKey())
                                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                    .url(httpServletRequest.getRequestURL().toString())
                                    .reqMethod(httpServletRequest.getMethod())
                                    .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); /* 500 */
    };

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleMediaNotSupport(HttpServletRequest request, Exception exception, Locale locale){
        exception.printStackTrace();
        Error error = Error.builder()
                               .errorCode(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode())
                               .message(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey())
                               .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                               .url(request.getRequestURL().toString())
                               .reqMethod(request.getMethod())
                               .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); /* 415 */
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handleNotWritable(HttpServletRequest request, Exception exception, Locale locale){
        exception.printStackTrace();
        Error error = Error.builder()
                           .errorCode(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrCode())
                           .message(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey())
                           .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); /* 415 */
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleNotSupport(HttpServletRequest request, Exception exception, Locale locale){
        exception.printStackTrace();
        Error error = Error.builder()
                           .errorCode(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode())
                           .message(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey())
                           .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); /* 415 */
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex,
                                                                       Locale locale) {

        Error error = Error.builder()
                           .errorCode(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrCode())
                           .message(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrMsgKey())
                           .status(HttpStatus.NOT_ACCEPTABLE.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request,
                                                          JsonParseException ex,
                                                          Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.JSON_PARSE_ERROR.getErrCode())
                           .message(ErrorCode.JSON_PARSE_ERROR.getErrMsgKey())
                           .status(HttpStatus.NOT_ACCEPTABLE.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Error> handleHttpRequestMethodNotSupportedException(HttpServletRequest request,
                                                                              HttpRequestMethodNotSupportedException ex,
                                                                              Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getErrCode())
                           .message(ErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getErrMsgKey())
                           .status(HttpStatus.NOT_IMPLEMENTED.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(HttpServletRequest request,
                                                                IllegalArgumentException ex,
                                                                Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getErrCode())
                           .message(String.format("%s %s",ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.BAD_REQUEST.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleResourceNotFoundException(HttpServletRequest request,
                                                                 ResourceNotFoundException ex,
                                                                Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.RESOURCE_NOT_FOUND.getErrCode())
                           .message(String.format("%s %s",ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_FOUND.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Error> handleCustomerNotFoundException(HttpServletRequest request,
                                                                 CustomerNotFoundException ex,
                                                                 Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.CUSTOMER_NOT_FOUND.getErrCode())
                           .message(String.format("%s %s",ErrorCode.CUSTOMER_NOT_FOUND.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_FOUND.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Error> handleItemNotFoundException(HttpServletRequest request,
                                                             ItemNotFoundException ex,
                                                             Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.ITEM_NOT_FOUND.getErrCode())
                           .message(String.format("%s %s",ErrorCode.ITEM_NOT_FOUND.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_FOUND.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericAlreadyExistsException.class)
    public ResponseEntity<Error> handleGenericAlreadyExistsException(HttpServletRequest request,
                                                                     GenericAlreadyExistsException ex,
                                                                     Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.GENERIC_ALREADY_EXISTS.getErrCode())
                           .message(String.format("%s %s",ErrorCode.GENERIC_ALREADY_EXISTS.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_ACCEPTABLE.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Error> handleUsernameNotfoundException(HttpServletRequest request,
                                                                 GenericAlreadyExistsException ex,
                                                                 Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.USERNAME_NOT_FOUND.getErrCode())
                           .message(String.format("%s %s",ErrorCode.USERNAME_NOT_FOUND.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_FOUND.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    public ResponseEntity<Error> handleInvalidRefreshTokenException(HttpServletRequest request,
                                                                 GenericAlreadyExistsException ex,
                                                                 Locale locale) {
        Error error = Error.builder()
                           .errorCode(ErrorCode.RESOURCE_NOT_FOUND.getErrCode())
                           .message(String.format("%s %s",ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey(), ex.getMessage()))
                           .status(HttpStatus.NOT_FOUND.value())
                           .url(request.getRequestURL().toString())
                           .reqMethod(request.getMethod())
                           .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
