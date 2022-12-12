package com.techelevator.model;

import java.sql.Timestamp;
import java.util.Date;

public class Item {

    private int itemId;
    private int listId;
    private int addedBy; //should this return a user or a string?
    private String itemName;
    private int itemQuantity;
    private Date dateAdded;
    private boolean isCompleted;
    private Timestamp lastModified;
    private int lastModifiedBy;
    private String category;

    public Item() {};

    public Item(int itemId, int listId, int addedBy, String itemName, int itemQuantity, Date dateAdded,
                boolean isCompleted, Timestamp lastModified, int lastModifiedBy, String category) {
        this.itemId = itemId;
        this.listId = listId;
        this.addedBy = addedBy;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.dateAdded = dateAdded;
        this.isCompleted = isCompleted;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getlistId() {
        return listId;
    }

    public void setlistId(int listId) {
        this.listId = listId;
    }

    public int getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(int addedBy) {
        this.addedBy = addedBy;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
