package com.example.c0782918_ex4;

import java.util.ArrayList;

public class ComplaintDetail
{
    private String firstName;
    private String lastName;
    private String number;
    private String designation;
    private ArrayList Issue;
    private String issueDate;
    private ArrayList address;

    public ComplaintDetail(String firstName, String lastName, String number, String designation, ArrayList issue, String issueDate, ArrayList address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.designation = designation;
        this.Issue = issue;
        this.issueDate = issueDate;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public ArrayList getIssue() {
        return Issue;
    }

    public void setIssue(ArrayList issue) {
        Issue = issue;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public ArrayList getAddress() {
        return address;
    }

    public void setAddress(ArrayList address) {
        this.address = address;
    }
}
