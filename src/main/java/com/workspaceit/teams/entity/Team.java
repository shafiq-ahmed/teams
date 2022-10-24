package com.workspaceit.teams.entity;

import javax.persistence.*;

@Entity(name = "teams_table")
public class Team {
    @Id
    private int id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User host;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }
}
