package com.modern.api.exception.common;

import com.modern.api.exception.ErrorCode;
import lombok.Getter;

import java.io.Serial;

@Getter
public class ItemNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public ItemNotFoundException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.ITEM_NOT_FOUND.getErrMsgKey();
        this.errorCode = ErrorCode.ITEM_NOT_FOUND.getErrCode();
    }
}
