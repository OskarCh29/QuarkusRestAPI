package org.acme.models.Entity;

public class Branch {
    private String branchName;
    private String lastCommitSha;

    public Branch(String branchName, String lastCommitSha) {
        this.branchName = branchName;
        this.lastCommitSha = lastCommitSha;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }
}

