package com.chris.some.code.study.onjava.enums.switchuse;

/**
 * 通常 switch 只能使用整形或字符串类型
 * 由于 enum 内部构建了一个整形序列，并且可以通过 ordinal() 方法获取枚举实例的顺序
 * 所以可以用在 switch
 *
 * @author grt
 * @since 2022-07-22 13:45:08
 */
public class TrafficLight {

    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            // 在 case 语句中，不需要使用 Signal.RED
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println("t = " + t);
            t.change();
        }
    }
}
