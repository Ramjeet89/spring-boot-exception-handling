package com.springboot.exception.exception;

public class OrderServiceException extends Exception {
    private static final long serialVersionUID = 4227171665478076830L;

    public OrderServiceException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "OrderServiceException{}";
    }
}
