package com.chris.some.code.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * jackson工具类
 *
 * @author chris
 */
@Slf4j
public class JacksonUtils {

    private JacksonUtils() {
    }

    public static ObjectMapper objectMapper;

    /**
     * javaBean、列表数组转换为json字符串
     *
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("JavaBean转Json异常", e);
        }
        return null;
    }

    /**
     * 将JSON字符串转换为JavaBean
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String jsonStr, Class<T> clazz) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            log.error("将JSON字符串转换为JavaBean异常", e);
        }
        return null;
    }

    /**
     * json转map
     *
     * @param json
     * @return
     */
    public static Map<String, Object> jsonToMap(String json) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            log.error("json转map异常", e);
        }
        return null;
    }

    /**
     * map转json
     *
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(map);
        } catch (Exception e) {
            log.error("map转json异常", e);
        }
        return null;
    }

    /**
     * json转list
     *
     * @param json
     * @param collectionClass
     * @param elementClasses
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToCollection(String json, Class<?> collectionClass, Class<T> elementClasses) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        JavaType javaType = getCollectionType(collectionClass, elementClasses);
        List<T> list = null;
        try {
            list = objectMapper.readValue(json, javaType);
        } catch (Exception e) {
            log.error("json转list异常", e);
        }
        return list;
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass
     * @param elementClasses
     * @return
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
