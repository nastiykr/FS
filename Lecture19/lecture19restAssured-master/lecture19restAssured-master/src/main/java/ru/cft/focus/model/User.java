package ru.cft.focus.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public String login;
    public Integer id;
    public String node_id;

    public User(String login, Integer id, String node_id) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
    }

    public User() {
    }
}
