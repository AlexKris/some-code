package com.chris.some.code.y2020.m07.d16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domain implements Serializable {
    private static final long serialVersionUID = -3207535080148402552L;
    String accountNo;
}
