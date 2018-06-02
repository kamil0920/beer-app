package org.moveApp.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
        super();
    }

    public ResourceNotFound(String s) {
        super(s);
    }

    public ResourceNotFound(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ResourceNotFound(Throwable throwable) {
        super(throwable);
    }

    protected ResourceNotFound(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
