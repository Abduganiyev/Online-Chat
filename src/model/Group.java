package model;

import java.util.Set;

public class Group implements Comparable<Group>{
    private Long id;
    private String title;
    private String description;
    private User adminGroup;
    private Set<User> users;

    public Group(Long id, String title, String description, User adminGroup, Set<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.adminGroup = adminGroup;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAdminGroup() {
        return adminGroup;
    }

    public void setAdminGroup(User adminGroup) {
        this.adminGroup = adminGroup;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public int compareTo(Group g) {
        return this.title.compareTo(g.getTitle());
    }
}
