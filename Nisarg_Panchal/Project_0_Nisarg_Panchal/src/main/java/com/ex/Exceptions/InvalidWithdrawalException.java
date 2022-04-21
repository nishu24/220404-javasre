package com.ex.Exceptions;

public class InvalidWithdrawalException extends RuntimeException{

    public InvalidWithdrawalException() {
    }

    public InvalidWithdrawalException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param cause
     */
    public InvalidWithdrawalException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidWithdrawalException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public InvalidWithdrawalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
