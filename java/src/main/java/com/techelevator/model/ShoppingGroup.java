package com.techelevator.model;

import java.time.LocalDate;

public class ShoppingGroup {
    private int groupId;
    private String groupName;
    private int invitationCode;
    private LocalDate dateJoined;

    public ShoppingGroup(int groupId, String groupName, int invitationCode, LocalDate dateJoined) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.invitationCode = invitationCode;
        this.dateJoined = dateJoined;
    }

    public ShoppingGroup() {

    }

    // public LocalDate getDateJoined() {
       // return this.dateJoined;
    // }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(int invitationCode) {
        this.invitationCode = invitationCode;
    }
}
