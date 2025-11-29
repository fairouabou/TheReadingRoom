package com.thereadingroom.model;

public class Post {

    private int id;
    private int discussionId;
    private int userId;
    private String content;
    private String createdAt;

    public Post(int id, int discussionId, int userId, String content, String createdAt) {
        this.id = id;
        this.discussionId = discussionId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Post(int discussionId, int userId, String content, String createdAt) {
        this(-1, discussionId, userId, content, createdAt);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return content;
    }
}
