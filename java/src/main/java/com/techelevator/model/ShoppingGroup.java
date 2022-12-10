package com.techelevator.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class ShoppingGroup {
    private int groupId;
    private String groupName;

    private int membershipAge;
    private String memberSince;

    public ShoppingGroup(int groupId, String groupName, String memberSince) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.memberSince = memberSince;
    }

    public ShoppingGroup() {

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


    public int getMembershipAge() {
        return membershipAge;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public void setMembershipAge(int membershipAge) {
        this.membershipAge = membershipAge;


    }
}
