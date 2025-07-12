package com.tsc.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ErrorDetails {

    private LocalDate currentTime;

    private String message;

    private String details;

    public LocalDate getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDate currentTime) {
        this.currentTime = currentTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "currentTime=" + currentTime +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
