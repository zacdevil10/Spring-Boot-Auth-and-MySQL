package uk.co.appsbystudio.rockets.rockets.users.model;

public class Authentication {

    public String username;

    public Integer userId;

    public String pid;

    public String picUri;

    public Integer findByEmail;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setPID(String pID) {
        this.pid = pID;
    }

    public String getPID() {
        return pid;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setFindByEmail(Integer findByEmail) {
        this.findByEmail = findByEmail;
    }

    public Integer getFindByEmail() {
        return findByEmail;
    }
}
