package org.acme.models.Entity;

import java.util.List;


public class Repository {
    private String repoName;
    private String login;
    private List<Branch> branches;

    public Repository() {
    }

    public Repository(String repoName, String login, List<Branch> branches) {
        this.repoName = repoName;
        this.login = login;
        this.branches = branches;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getLogin() {
        return login;
    }

    public List<Branch> getBranches() {
        return branches;
    }
}
