package com.asyncrestservice.resp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * @author Kalidass Mahalingam
 *
 */
public class ErrorStatus extends Status {
    private ErrorStatus.ErrorType error;
    private List<ErrorMessage> errorList;

    public ErrorStatus(ErrorStatus.ErrorType error) {
        this.type = Type.ERROR;
        this.error = error;
    }

    public ErrorStatus(List<ErrorMessage> errorMessageList) {
        this.type = Type.ERROR;
        this.errorList = errorMessageList;
    }

    public ErrorStatus(ErrorStatus.ErrorType error, Object errorCause) {
        this.type = Type.ERROR;
        this.error = error;
    }

    protected Enum<ErrorStatus.ErrorType> getCode() {
        return this.error;
    }

    public String toString() {
        return "Error [type=" + this.type + ", error=" + this.error + ", errorMessageList=" + this.errorList + "]";
    }

    public ErrorStatus.ErrorType getError() {
        return this.error;
    }

    public List<ErrorMessage> getErrorList() {
        return this.errorList;
    }

    public void setErrorList(List<ErrorMessage> errorList) {
        this.errorList = errorList;
    }

    @JsonFormat(
        shape = Shape.OBJECT
    )
    public static enum ErrorType {
        INVALID_INPUT(400, "INVALID_INPUT"),
        INTERNAL_ERROR(500, "INTERNAL_ERROR");

        private final int code;
        private final String msg;

        private ErrorType(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
