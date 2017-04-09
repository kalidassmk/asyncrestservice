package com.asyncrestservice.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * @author Kalidass Mahalingam
 *
 */
public class Info extends Status {
    private Info.InfoType info;

    public Info(Info.InfoType info) {
        this.type = Type.INFO;
        this.info = info;
    }

    protected Enum<Info.InfoType> getCode() {
        return this.info;
    }

    public String toString() {
        return "Info [type=" + this.type + ", info=" + this.info + "]";
    }

    public Info.InfoType getInfo() {
        return this.info;
    }

    @JsonFormat(
        shape = Shape.OBJECT
    )
    public static enum InfoType {
        INFO_OK(1000, "OK");

        private final int code;
        private final String msg;

        private InfoType(int code, String msg) {
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
