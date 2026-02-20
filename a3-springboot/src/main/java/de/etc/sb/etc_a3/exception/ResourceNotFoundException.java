package de.etc.sb.etc_a3.exception;

public class ResourceNotFoundException extends RuntimeException {

    private String internalMessage;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, String internalMessage) {
        super(message);
        this.internalMessage = internalMessage;
    }

    public String getInternalMessage() {
        return internalMessage;
    }
}