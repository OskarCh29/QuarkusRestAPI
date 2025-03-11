package org.acme.models.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BranchResponse {
    private String name;
    private Commit commit;

    public BranchResponse(String name, Commit commit) {
        this.name = name;
        this.commit = commit;
    }

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }


    public static class Commit {
        private String sha;

        public String getSha() {
            return sha;
        }
    }
}
