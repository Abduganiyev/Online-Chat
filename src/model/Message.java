package model;

import enums.MsgStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private Long id;
    private String subject;
    private String text;
    private User sender;
    private User recipient;
    private MsgStatus status;
    private String dateTime;

    public Message(Long id, String subject, String text, User sender, User recipient, MsgStatus status) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.status = status;
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now());
    }

    public Message(Long id, String text,User sender,User recipient, MsgStatus status) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.sender = sender;
        this.recipient = recipient;
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now());
    }

    public Message() {
        this.dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.now());
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return  "Recipient: " + recipient.getUsername() + '\n' +
                "Subject: " + subject + '\n' +
                "Text: " + text + '\n' +
                "DateTime: " + dateTime + '\n';
    }
}
