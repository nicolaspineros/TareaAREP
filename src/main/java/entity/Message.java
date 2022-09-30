package entity;

import java.util.UUID;

public class Message {
    private String id;
    private String content;
    private String creationDate;

    public Message(String content){
        this.id = UUID.randomUUID().toString();
    }
    public Message(String id, String content, String creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
