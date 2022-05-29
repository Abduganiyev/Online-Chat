package model;

import enums.UserRole;
import enums.UserStatus;

import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String password;
    private UserRole userRole;
    private Set<Group> groups;
    private UserStatus userStatus;

    public User(Long id, String username, String password, UserRole userRole, Set<Group> groups, UserStatus userStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.groups = groups;
        this.userStatus = userStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return userRole;
    }

    public void setRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public UserStatus getStatus() {
        return userStatus;
    }

    public void setStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
