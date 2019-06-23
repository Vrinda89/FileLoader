package com.loader.pro.model;

import java.util.List;

public class ProfileResponse {

    public List<Profile> profiles;

    public class Profile {
        public String created_at;
        public int likes;
        public User user;
    }

    public class User {
        public String name;
        public String username;
        public ProfileImage profile_image;
    }

    public class ProfileImage {
        public String large;
    }

}
