package com.chris.some.code.study.onjava.enums.customize;

public enum OzWitch {
    // 实例必须在方法之前定义
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Clinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy', house"),
    ;

    private String description;

    // 构造器的访问权限必须是包级或 private
    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + ": " + witch.getDescription());
        }
    }
}
