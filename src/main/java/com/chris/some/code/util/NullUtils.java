package com.chris.some.code.util;

import java.util.Collection;
import java.util.Map;

/**
 * 判空工具类
 *
 * @author chris
 */
public class NullUtils {

    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null) return true;

        if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection) return ((Collection) obj).isEmpty();

        if (obj instanceof Map) return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) return true;

            boolean empty = true;
            for (Object o : object) {
                if (!isNullOrEmpty(o)) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }
}
