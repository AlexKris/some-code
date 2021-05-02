package com.chris.some.code.y2018.m09.d14;

import java.util.HashMap;
import java.util.Map;

/**
 * gitChat上王晓华的课
 * 警察抓了 A、B、C、D 四名罪犯，其中一名是小偷，审讯的时候：
 * A说：“我不是小偷。”     x != 0
 * B说：“C是小偷。”       x = 2
 * C说：“小偷肯定是D。”    x = 3
 * D说：“C是在冤枉人。”    x != 3
 * 现在已经知道四个人中三个人说的是真话，一个人说了假话，请判断一下到底谁是小偷？
 *
 * @author chris
 */
public class ArrayTest {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(8);
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        for (int x = 0; x < 4; x++) {
            int disA = (x != 0) ? 1 : 0;
            int disB = (x == 2) ? 1 : 0;
            int disC = (x == 3) ? 1 : 0;
            int disD = 1 - disC;

            if ((disA + disB + disC + disD) == 3) {
                String thief = "The thief is " + map.get(x);
                System.out.println(thief);
                break;
            }
        }
    }
}
