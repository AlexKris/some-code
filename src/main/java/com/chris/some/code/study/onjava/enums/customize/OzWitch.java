package com.chris.some.code.study.onjava.enums.customize;

/**
 * 如想新增自定义方法，必须先用分号结束枚举实例的序列
 * 枚举实例必须先定义，否则会抛出编译时错误
 *
 * @author grt
 * @since 2022-07-20 17:02:03
 */
public enum OzWitch {
    // 实例必须在方法之前定义
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing"),
    ;

    private final String description;

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
