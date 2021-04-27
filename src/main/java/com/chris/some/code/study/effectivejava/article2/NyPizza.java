package com.chris.some.code.study.effectivejava.article2;

import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@Getter
@ToString
public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder, NyPizza> {
        private final Size size;

        public Builder(Size size) {
            this.size = Optional.of(size).get();
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
