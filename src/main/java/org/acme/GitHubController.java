package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.Service.GitHubService;
import org.acme.models.Entity.Repository;

import java.util.List;

@Path("/")
@ApplicationScoped
public class GitHubController {

    @Inject
    GitHubService gitHubService;

    @GET
    @Path("{username}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Repository> getUserRepositories(@PathParam("username") String username) {
        return gitHubService.getUserRepositoryInfo(username);
    }
}
