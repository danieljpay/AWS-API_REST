package com.aws.apprest.repository;

import com.aws.apprest.entity.Alumno;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @ToString
public class AlumnoRepository {
    private ArrayList<Alumno> alumnos = new ArrayList<>();
}
