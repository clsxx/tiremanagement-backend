package com.adesso.tireManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The entity representation of an account.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    private Boolean isAdmin;

    /**
     * Creates a new instance of an account.
     */
    public Account() {
    }

    /**
     * Creates a new instance of an account with parameters.
     * @param username
     * @param password
     * @param isAdmin
     */
    public Account(String username, String password, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * Gets the username for this account.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this account.
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password for this account.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this account.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * If this account is an admin account.
     * @return isAdmin
     */
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sets if this account is an admin account.
     * @param isAdmin
     */
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
