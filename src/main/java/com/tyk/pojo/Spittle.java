package com.tyk.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Spittle implements Serializable {
    private Long id;
    private Spitter spitter;
    private String message;
    private Date postedTime;
}
