package com.chris.some.code.study.effectivejava.article5;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

// Dependency injection provides flexibility and testability
@Getter
@ToString
public class SpellChecker {
    private final String[] dictionary;

    private SpellChecker(String[] dictionary) {
        this.dictionary = Optional.of(dictionary).get();
    }
}
