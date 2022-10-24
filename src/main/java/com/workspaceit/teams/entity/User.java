package com.workspaceit.teams.entity;

import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity(name = "user_table_3")
public class User {
    @Id
    private String email;
    private String password;
    private UserType type;
    @OneToOne(fetch = FetchType.LAZY)
    @Nullable
    private Team team;

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
