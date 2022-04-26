package com.aws.apprest.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
public class Alumno {
    private int id;
    private long matricula;
    private String nombres;
    private String apellidos;
    private float promedio;
}
