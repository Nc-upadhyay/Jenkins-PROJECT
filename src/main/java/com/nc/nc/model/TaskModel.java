package com.nc.nc.model;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TaskModel {
    private Long id;
    private String taskname;
    private String description;
    private String status;
    private Long user;
}
