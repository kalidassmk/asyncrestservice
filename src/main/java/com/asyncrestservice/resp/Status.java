package com.asyncrestservice.resp;

/**
 * @author Kalidass Mahalingam
 *
 */
public abstract class Status {
    protected Status.Type type;
    protected Object cause;

    public Status() {
    }

    public Status.Type getType() {
        return this.type;
    }

    @SuppressWarnings("rawtypes")
	protected abstract Enum getCode();

    public Object getCause() {
        return this.cause;
    }

    public static enum Type {
        INFO,
        WARNING,
        ERROR,
        CRITICAL;

        private Type() {
        }
    }
}