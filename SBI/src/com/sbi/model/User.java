package com.sbi.model;

import java.util.Arrays;
import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String passwordHash;
    private String fullName;
    private String email;
    private String phone;
    private String role;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private byte[] passportPhoto; // To store the image as byte array

    // Constructor
    public User(int userId, String username, String passwordHash, String fullName, String email, 
                String phone, String role, String status, Date createdAt, Date updatedAt, byte[] passportPhoto) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.passportPhoto = passportPhoto;
    }

    // Getters & Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public byte[] getPassportPhoto() { return passportPhoto; }
    public void setPassportPhoto(byte[] passportPhoto) { this.passportPhoto = passportPhoto; }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", passwordHash=" + passwordHash + ", fullName="
				+ fullName + ", email=" + email + ", phone=" + phone + ", role=" + role + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", passportPhoto="
				+ Arrays.toString(passportPhoto) + "]";
	}    
    
}
