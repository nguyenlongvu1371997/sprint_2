package com.example.backendchillvie.model;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String passwordUser;

    @ManyToOne
    @JoinColumn(name = "role_user_id", referencedColumnName = "id")
    private RoleUser roleUser;
    private boolean flagDeleted;

    public AppUser() {
    }

    public AppUser(Long id, String name, String passwordUser, RoleUser roleUser, boolean flagDeleted) {
        this.id = id;
        this.name = name;
        this.passwordUser = passwordUser;
        this.roleUser = roleUser;
        this.flagDeleted = flagDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    public boolean isFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
