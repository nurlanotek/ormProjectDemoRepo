package org.uca.sas.cs.course1.lesson5.model;

import java.time.Instant;

public class Message {
    private Integer messageId;
    private String username;
    private String messagetext;

    public Message(Integer messageId, String username, String messagetext) {
        this.messageId = messageId;
        this.username = username;
        this.messagetext = messagetext;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    @Override
    public String toString() {
        return String.format("%d, username=%s: %s [Timestamp: %s]",
                getMessageId(), getUsername(), getMessagetext(), Instant.now().toString());
    }
}
