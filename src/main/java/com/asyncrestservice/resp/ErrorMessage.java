package com.asyncrestservice.resp;

/**
 * @author Kalidass Mahalingam
 *
 */
public class ErrorMessage {
    private String code;
    private String fieldName;
    private String message;

    public ErrorMessage(String code, String fieldName, String message) {
        this.code = code;
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String toString() {
        return "ErrorMessage [code=" + this.code + ", invalidField=" + this.fieldName + ", message=" + this.message + "]";
    }
}