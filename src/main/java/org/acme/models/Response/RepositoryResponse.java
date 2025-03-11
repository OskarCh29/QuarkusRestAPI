package org.acme.models.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryResponse {
    private String name;
    private Owner owner;
    private boolean fork;

    public RepositoryResponse(String name, Owner owner, boolean fork) {
        this.name = name;
        this.owner = owner;
        this.fork = fork;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }

    public static class Owner {
        private String login;

        public String getLogin() {
            return login;
        }
    }
}
