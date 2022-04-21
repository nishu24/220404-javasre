package com.ex.Exceptions;

public class NotValidWithdrawAmountException extends Exception {
    public NotValidWithdrawAmountException(String s) {
    }

    /**
     *
     * @param message
     * @param cause
     */
    public NotValidWithdrawAmountException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidWithdrawAmountException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public NotValidWithdrawAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NotValidWithdrawAmountException() {
    }
}
