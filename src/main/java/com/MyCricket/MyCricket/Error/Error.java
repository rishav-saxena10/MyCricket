package com.MyCricket.MyCricket.Error;

public class Error {
    private String errorDescription;

    public Error(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    // Getters and setters
    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}

