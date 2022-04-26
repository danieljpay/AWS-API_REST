package com.aws.apprest.controller;

import com.aws.apprest.entity.Profesor;
import com.aws.apprest.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping(path = "/profesores")
    public ArrayList<Profesor> getAll() {
        return profesorService.getAll();
    }

    @GetMapping(path = "/profesores/{id}")
    public ResponseEntity<Profesor> getProfesor(@PathVariable int id) {
        Profesor profesor = profesorService.get(id);
        if (profesor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    @PostMapping(path = "/profesores")
    public ResponseEntity<String> addProfesor(@RequestBody @Validated Profesor profesor) {
        profesorService.save(profesor);
        return new ResponseEntity<>("Profesor agregado", HttpStatus.CREATED);
    }

    @PutMapping(path = "/profesores/{id}")
    public ResponseEntity<String> updateProfesor(@PathVariable int id, @RequestBody @Validated Profesor profesor) {
        if(!profesorService.update(id, profesor)) {
            return new ResponseEntity<>("Profesor: ", HttpStatus.OK);
        }
        return new ResponseEntity<>("Profesor actualizado", HttpStatus.OK);
    }

    @DeleteMapping(path = "/profesores/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable int id) {
        if (!profesorService.delete(id)) {
            return new ResponseEntity<>("Profesor: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Profesor eliminado ", HttpStatus.OK);
    }
}
