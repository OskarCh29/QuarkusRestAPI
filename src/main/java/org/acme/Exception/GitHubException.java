package org.acme.Exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.acme.models.Response.ErrorMessage;

public class GitHubException extends RuntimeException {
    private final int status;
    private final String message;

    public GitHubException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
