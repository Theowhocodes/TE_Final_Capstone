package com.techelevator.model;

public class ShoppingGroupDto {

    private int GroupId ;
    private String GroupName;
    private int InvitationCode;

    public ShoppingGroupDto(int groupId, String groupName, int invitationCode) {
        GroupId = groupId;
        GroupName = groupName;
        InvitationCode = invitationCode;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public int getInvitationCode() {
        return InvitationCode;
    }

    public void setInvitationCode(int invitationCode) {
        InvitationCode = invitationCode;
    }
}
