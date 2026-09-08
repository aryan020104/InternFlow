package com.internflow.internflow_backend.dto;

import com.internflow.internflow_backend.entity.Role;

public class RegisterRequest {

    private String fullname;
    private String email;
    private String password;
    private Role role;

    public RegisterRequest() {
    }

    public Role getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}