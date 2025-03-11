package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.Exception.GitHubExceptionMapper;
import org.acme.models.Response.BranchResponse;
import org.acme.models.Response.RepositoryResponse;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "github-api")
@RegisterProvider(GitHubExceptionMapper.class)
public interface GitHubClient {

    @GET
    @Path("/users/{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    List<RepositoryResponse> getUserRepositories(@PathParam("username") String username);

    @GET
    @Path("/repos/{username}/{repo}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    List<BranchResponse> getBranches(@PathParam("username") String username,
                                     @PathParam("repo") String repo);
}
