package com.chris.some.code.y2022.m09;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldDTO {

    private String opTable;

    private String opField;

    private String oldValue;

    private String newValue;
}
