package com.github.model.enums;

public enum AuthResourceEnum {
    ACCOUNT_READ("ACCOUNT_READ","account read","可以获取 account 信息"),
    ;

    private String value;

    private String name;

    private String comment;

    AuthResourceEnum(String value, String name, String comment) {
        this.value = value;
        this.name = name;
        this.comment = comment;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getComment(){return comment;}
}
