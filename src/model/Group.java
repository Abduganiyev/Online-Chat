package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Group implements Comparable<Group>{
    private Long id;
    private String title;
    private String description;
    private List<Message> messageList;
    private User groupAdmin;
    private Set<User> users;
    private String dateTime;

    public Group(Long id, String title, String description, User groupAdmin, Set<User> users) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.groupAdmin = groupAdmin;
        this.users = users;
        this.messageList = null;
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(now);
    }

    public Group(Long id, String title, String description, User groupAdmin) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.groupAdmin = groupAdmin;
        this.users = new TreeSet<>();
        this.messageList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(now);
    }

    public Group() {
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(now);
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

    public User getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(User groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void addUser(User u) {
        this.users.add(u);
    }

    public void addMessage(Message m) {
        this.messageList.add(m);
    }
    @Override
    public int compareTo(Group g) {
        return this.title.compareTo(g.getTitle());
    }
}
