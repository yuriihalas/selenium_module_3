package com.epam.model;

import java.util.Objects;

public class ProfileInfo {
    private String title;
    private String location;
    private String aboutMe;

    public ProfileInfo() {
    }

    public ProfileInfo(String title, String location, String aboutMe) {
        this.title = title;
        this.location = location;
        this.aboutMe = aboutMe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileInfo that = (ProfileInfo) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(location, that.location) &&
                Objects.equals(aboutMe, that.aboutMe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, location, aboutMe);
    }

    @Override
    public String toString() {
        return "ProfileInfo{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
