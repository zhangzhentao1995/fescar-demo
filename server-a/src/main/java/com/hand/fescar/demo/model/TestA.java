package com.hand.fescar.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestA implements Serializable {
    private Long id;

    private String name;

    private String value;
}
