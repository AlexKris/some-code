package com.chris.some.code.study.effectivejava.article2;

import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

// Builder pattern for class hierarchies
@Getter
@ToString
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T, N>, N extends Pizza> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Optional.of(topping).get());
            return self();
        }

        abstract N build();

        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?, ?> builder) {
        toppings = builder.toppings.clone();
    }
}
