package com.minidnd.user;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name ="user")
public class User {

    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(nullable=false, unique=true)
    private String userName;
    @Column(nullable=false, unique=true)
    private String email;
    @Column(nullable=false, unique=true)
    private String password;

    public User(@NonNull String userName, @NonNull String email, @NonNull String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User() {}

    public Long getId() {
        return id;
    }



    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
