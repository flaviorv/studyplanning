package com.frv.studyplanning.domain.model.exception;

public class NoSubjectsException extends RuntimeException {
    public NoSubjectsException() {
        super("No subjects found.");
    }

    public NoSubjectsException(String message) {
        super(message);
    }
}
