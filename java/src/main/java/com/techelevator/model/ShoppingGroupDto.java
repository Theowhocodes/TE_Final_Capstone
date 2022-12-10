package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingGroupDto {

    private int groupId;
    private String groupName;
    @JsonProperty("invitation_code")
    private int invitationCode;


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {

        groupId = groupId;

        this.groupId = groupId;

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {

        groupName = groupName;

        this.groupName = groupName;

    }

    public int getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(int invitationCode) {

        invitationCode = invitationCode;

        this.invitationCode = invitationCode;

    }
}
