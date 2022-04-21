package com.ex.Exceptions;

public class ListEmptyException extends RuntimeException {
    /**
     *
     * @param customer_list_cannot_be_empty
     */
    public ListEmptyException(String customer_list_cannot_be_empty) {
    }

    public ListEmptyException() {
        super();
    }

    public ListEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListEmptyException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    protected ListEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
