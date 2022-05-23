package com.aws.apprest.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Component
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
public class Alumno {

    @NotNull(message = "El campo no puede estar vacío")
    @PositiveOrZero(message = "El campo no puede ser negativo")
    private long id;

    @NotEmpty(message = "El campo no puede estar vacío")
    private String matricula;

    @NotEmpty(message = "El campo no puede estar vacío")
    private String nombres;

    @NotEmpty(message = "El campo no puede estar vacío")
    private String apellidos;

    @NotNull(message = "El campo no puede estar vacío")
    @PositiveOrZero(message = "El campo no puede ser negativo")
    private double promedio;
}
