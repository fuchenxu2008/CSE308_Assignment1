package com.accenture.model;

import java.util.ArrayList;

public class Client {

    private String clientId;

    private String short_name;

    private String full_name;

    private String address;

    private String contact_first_name;

    private String contact_last_name;

    private String contact_phone;

    private String contact_email;

    private ArrayList<String> projectId;

    private String city;

    private String isHostedOnClouds;

    private boolean deleted = false;

    // AWS
    private String accessKey;

    private String secretKey;

    public String getShort_name() {
        return short_name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getContact_first_name() {
        return contact_first_name;
    }

    public void setContact_first_name(String contact_first_name) {
        this.contact_first_name = contact_first_name;
    }

    public String getContact_last_name() {
        return contact_last_name;
    }

    public void setContact_last_name(String contact_last_name) {
        this.contact_last_name = contact_last_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public ArrayList<String> getProjectId() {
        return projectId;
    }

    public void setProjectId(ArrayList<String> projectId) {
        this.projectId = projectId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getIsHostedOnClouds() {
        return isHostedOnClouds;
    }

    public void setIsHostedOnClouds(String isHostedOnClouds) {
        this.isHostedOnClouds = isHostedOnClouds;
    }

    @Override
    public String toString() {
        return "Client [clientId=" + clientId + ", short_name=" + short_name + ", full_name=" + full_name + ", address="
                + address + ", contact_first_name=" + contact_first_name + ", contact_last_name=" + contact_last_name
                + ", contact_phone=" + contact_phone + ", contact_email=" + contact_email + ", projectId=" + projectId
                + ", city=" + city + ", isHostedOnClouds=" + isHostedOnClouds + ", deleted=" + deleted + ", accessKey="
                + accessKey + ", secretKey=" + secretKey + "]";
    }

}
