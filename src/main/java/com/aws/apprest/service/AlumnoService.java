package com.aws.apprest.service;

import com.aws.apprest.entity.Alumno;
import com.aws.apprest.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public int getIndex(int id) {
        int index = -1;
        if(alumnoRepository.getAlumnos().isEmpty()) {
            return index;
        }
        for(Alumno unAlumno : alumnoRepository.getAlumnos()) {
            index++;
            if(unAlumno.getId() == id) {
                return index;
            }
        }
        return index;
    }

    public Alumno get(int id) {
        for(Alumno unAlumno : alumnoRepository.getAlumnos()) {
            if(unAlumno.getId() == id) {
                return unAlumno;
            }
        }
        return null;
    }

    public ArrayList<Alumno> getAll() {
        return alumnoRepository.getAlumnos();
    }

    public boolean update(int id, Alumno alumno) {
        int index = getIndex(id);
        if (index > -1) {
            alumnoRepository.getAlumnos().set(index, alumno);
            return true;
        }
        return false;
    }

    public boolean save(Alumno alumno) {
        return alumnoRepository.getAlumnos().add(alumno);
    }

    public boolean delete(int id) {
        int index = getIndex(id);
        if(index > -1) {
            alumnoRepository.getAlumnos().remove(index);
            return true;
        }
        return false;
    }

}
