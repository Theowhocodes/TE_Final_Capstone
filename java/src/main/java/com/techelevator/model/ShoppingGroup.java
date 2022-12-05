package com.techelevator.model;

public class ShoppingGroup {
    private int groupId;
    private String groupName;
    private int invitationCode;

    public ShoppingGroup(int groupId, String groupName, int invitationCode) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.invitationCode = invitationCode;
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
