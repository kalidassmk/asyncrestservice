package com.asyncrestservice.resp;

/**
 * @author Kalidass Mahalingam
 *
 * @param <T>
 */
public class Response<T> {
    private T payLoad = null;
    private Status status = null;

    public Response() {
    }

    public T getPayLoad() {
        return this.payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
