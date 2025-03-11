package org.acme.Exception;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.models.Response.ErrorMessage;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

@Provider
public class GitHubExceptionMapper implements ExceptionMapper<GitHubException>, ResponseExceptionMapper<GitHubException> {

    @Override
    public Response toResponse(GitHubException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getStatus(),e.getMessage());
        return Response.status(errorMessage.getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    @Override
    public GitHubException toThrowable(Response response) {
        int status = response.getStatus();
        String message;

        if (status == 404) {
            message = "No user found with provided credentials - check your request";
        } else if (status >= 500) {
            message = "GitHub API external error";
        } else if (status == 400) {
            message = "Bad request - check provided credentials";
        } else {
            message = "Unexpected GitHub API error";
        }
        return new GitHubException(status, message);
    }
}
