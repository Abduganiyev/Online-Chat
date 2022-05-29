package model;

import enums.MsgStatus;

public class Message {
    private Long id;
    private String subject;
    private String text;
    private User sender;
    private User recipient;
    private MsgStatus status;

    public Message(Long id, String subject, String text, User sender, User recipient, MsgStatus status) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public MsgStatus getStatus() {
        return status;
    }

    public void setStatus(MsgStatus status) {
        this.status = status;
    }
}
