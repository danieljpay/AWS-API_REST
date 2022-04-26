package com.aws.apprest.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
public class Profesor {
    private int id;
    private int numeroEmpleado;
    private String nombres;
    private String apellidos;
    private int horasClase;
}
