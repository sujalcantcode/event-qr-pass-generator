package com.sujal.eventpass.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EventDetails {
    @NotBlank(message = "Name can't be empty")
    private String name;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Event name is required")
    private String eventName;

    public EventDetails() {}

    public EventDetails(String name, String email, String eventName) {
        this.name = name;
        this.email = email;
        this.eventName = eventName;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
}
