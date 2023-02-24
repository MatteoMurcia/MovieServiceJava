package com.example.demo.controller.dto;

public class privateDTO {
    private String email;

    public privateDTO() {
    }

    public privateDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
