package com.workspaceit.teams.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "team_table")
public class Team {
    @Id
    private int id;
    @ManyToOne
    private User host;
    @OneToOne
    private User guest;

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

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }
}
