package com.nc.nc.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long user_id;
    private String username;
    private String password;
    private String user_mobile;
    private String user_email;
}
