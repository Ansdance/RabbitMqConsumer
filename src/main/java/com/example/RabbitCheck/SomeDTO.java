package com.example.RabbitCheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SomeDTO implements Serializable{
    private static final long serialVersionUID = 2000930311021589529L;
    public String message;
}
