package com.aws.apprest.repository;

import com.aws.apprest.entity.Profesor;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
public class ProfesorRepository {
    private ArrayList<Profesor> profesores = new ArrayList<>();
}
