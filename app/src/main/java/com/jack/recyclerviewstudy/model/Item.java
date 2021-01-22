package com.jack.recyclerviewstudy.model;

public class Item {
    String groupId;
    String data;

    public Item(String groupId, String data) {
        this.groupId = groupId;
        this.data = data;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
