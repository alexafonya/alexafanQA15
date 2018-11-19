package com.addressbook.lessons.tests.model;

public class Group {
    public String groupName;
    public String groupHeder;
    public String groupFooter;


    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Group setGroupHeader(String groupHeder) {
        this.groupHeder = groupHeder;
        return this;
    }

    public Group setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeder() {
        return groupHeder;
    }

    public String getGroupFooter() {
        return groupFooter;
    }
}
