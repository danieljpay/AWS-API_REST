package com.aws.apprest.controller;


import com.aws.apprest.entity.Alumno;
import com.aws.apprest.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping(path = "/alumnos")
    public ArrayList<Alumno> getAll() {
        return alumnoService.getAll();
    }

    @GetMapping(path = "/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable long id) {
        Alumno alumno = alumnoService.get(id);
        if(alumno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alumno, HttpStatus.OK);
    }

    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addAlumno(@RequestBody @Validated Alumno alumno) {
        alumnoService.save(alumno);
        return new ResponseEntity<>("Alumno agregado", HttpStatus.CREATED);
    }

    @PutMapping(path = "/alumnos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateAlumno(@PathVariable long id, @RequestBody @Validated Alumno alumno) {
        if(!alumnoService.update(id, alumno)) {
            return new ResponseEntity<>("Alumno: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Alumno actualizado", HttpStatus.OK);
    }

    @DeleteMapping(path = "/alumnos/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable long id) {
        if(!alumnoService.delete(id)) {
            return new ResponseEntity<>("Alumno: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Alumno eliminado", HttpStatus.OK);
    }

}
