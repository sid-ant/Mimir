package com.sidant.mimir.TelegramBot.Types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Chat {

    Integer id;
    String type;
    String title;
    String username;
    String firstName;
    String lastname;
    Boolean isForum;
    Object photo;
    String[] activeUsernames;
    String emojiStatusCustomEmojiId;
    String bio;

    public Chat() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getForum() {
        return isForum;
    }

    public void setForum(Boolean forum) {
        isForum = forum;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String[] getActiveUsernames() {
        return activeUsernames;
    }

    public void setActiveUsernames(String[] activeUsernames) {
        this.activeUsernames = activeUsernames;
    }

    public String getEmojiStatusCustomEmojiId() {
        return emojiStatusCustomEmojiId;
    }

    public void setEmojiStatusCustomEmojiId(String emojiStatusCustomEmojiId) {
        this.emojiStatusCustomEmojiId = emojiStatusCustomEmojiId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    // there are more fields, but they are optional & I don't need them

}
