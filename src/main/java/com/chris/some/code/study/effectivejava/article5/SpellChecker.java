package com.chris.some.code.study.effectivejava.article5;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

// Dependency injection provides flexibility and testability

/**
 * 5、依赖注入优于硬连接资源（hardwiring resources）
 * <p>
 * 许多类依赖于一个或多个底层资源
 */
@Getter
@ToString
public class SpellChecker {
    private final String[] dictionary;

    private SpellChecker(String[] dictionary) {
        this.dictionary = Optional.of(dictionary).get();
    }
}
