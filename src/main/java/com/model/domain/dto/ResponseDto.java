package com.model.domain.dto;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@XmlRootElement
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    // response message
    private String message;

    // response status
    private ResponseStatus status;

    public void addMessage(String message) {
        this.message = this.message == null ? message : this.message + ",\r\n" + message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(final ResponseStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseDto [" +
                "message='" + message + '\'' +
                ", status=" + status +
                ']';
    }
}
