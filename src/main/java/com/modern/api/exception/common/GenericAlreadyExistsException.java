package com.modern.api.exception.common;

import com.modern.api.exception.ErrorCode;
import lombok.Getter;

import java.io.Serial;

@Getter
public class GenericAlreadyExistsException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public GenericAlreadyExistsException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.GENERIC_ALREADY_EXISTS.getErrMsgKey();
        this.errorCode = ErrorCode.GENERIC_ALREADY_EXISTS.getErrCode();
    }
}
