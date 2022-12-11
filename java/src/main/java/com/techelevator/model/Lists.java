package com.techelevator.model;




public class Lists {



    private int listId;
    private String listName;
    private int groupId;
    private boolean claimed;
    private int listOwner;
    private boolean completed;
    private int count;



    public Lists(int listId, String listName, int groupId, boolean claimed, int listOwner, boolean completed, int itemCount) {
        this.listId = listId;
        this.listName = listName;
        this.groupId = groupId;
        this.claimed = claimed;
        this.listOwner = listOwner;
        this.completed = completed;
        this.count = count;
    }

    public Lists() {
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public int getListOwner() {
        return listOwner;
    }

    public void setListOwner(int listOwner) {
        this.listOwner = listOwner;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}