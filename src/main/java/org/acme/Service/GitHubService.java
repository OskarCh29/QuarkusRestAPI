package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Exception.GitHubException;
import org.acme.GitHubClient;
import org.acme.models.Entity.Branch;
import org.acme.models.Entity.Repository;
import org.acme.models.Response.BranchResponse;
import org.acme.models.Response.RepositoryResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GitHubService {

    @Inject
    @RestClient
    GitHubClient gitHubClient;


    public List<Repository> getUserRepositoryInfo(String username) {
        try {
            List<RepositoryResponse> repoResponse = gitHubClient.getUserRepositories(username);
            return repoResponse.stream().filter(repo -> !repo.isFork())
                    .map(repo -> new Repository(repo.getName(), repo.getOwner().getLogin(), getBranches(username, repo.getName())))
                    .collect(Collectors.toList());
        } catch (GitHubException e) {
            throw new GitHubException(e.getStatus(), e.getMessage());
        }
    }

    public List<Branch> getBranches(String username, String repoName) {
        List<BranchResponse> branchResponses = gitHubClient.getBranches(username, repoName);
        return branchResponses.stream().map(branch -> new Branch(branch.getName(), branch.getCommit().getSha()))
                .collect(Collectors.toList());

    }
}
