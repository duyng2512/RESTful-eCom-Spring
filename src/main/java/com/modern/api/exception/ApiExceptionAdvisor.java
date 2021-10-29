package com.modern.api.exception;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Locale;

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

}
