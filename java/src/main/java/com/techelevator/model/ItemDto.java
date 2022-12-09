package com.techelevator.model;

import java.sql.Timestamp;
import java.util.Date;

public class ItemDto {
    private int itemId;
    private int itemListId;
    private User addedBy;
    private String itemName;
    private int itemQuantity;
    private Date dateAdded;
    private boolean isCompleted;
    private Timestamp lastModified;
    private User lastModifiedBy;
    private String category;

    public ItemDto(int itemId, int itemListId, User addedBy, String itemName, int itemQuantity, Date dateAdded, boolean isCompleted, Timestamp lastModified, User lastModifiedBy, String category) {
        this.itemId = itemId;
        this.itemListId = itemListId;
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

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemListId() {
        return itemListId;
    }

    public void setItemListId(int itemListId) {
        this.itemListId = itemListId;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
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

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
