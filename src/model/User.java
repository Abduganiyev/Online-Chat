package model;

import enums.UserRole;
import enums.UserStatus;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class User implements Comparable<User> {
    private Long id;
    private String username;
    private String password;
    private UserRole userRole;
    private Set<Group> groups;
    private UserStatus userStatus;
    private String dateTime;
    private boolean singedIn;

    public User(Long id, String username, String password, UserRole userRole, Set<Group> groups, UserStatus userStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.groups = groups;
        this.userStatus = userStatus;
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(now);
        this.singedIn = false;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isSingedIn() {
        return singedIn;
    }

    public void setSingedIn(boolean signedIn) {
        this.singedIn = signedIn;
    }

    @Override
    public int compareTo(User o) {
        return this.username.compareTo(o.getUsername());
    }
}
