package com.aws.apprest.service;

import com.aws.apprest.entity.Profesor;
import com.aws.apprest.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    private int getIndex(long id) {
        int index = -1;
        if(profesorRepository.getProfesores().isEmpty()) {
            return index;
        }
        for(Profesor unProfesor : profesorRepository.getProfesores()) {
            index++;
            if(unProfesor.getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public Profesor get(long id) {
        for(Profesor unProfesor : profesorRepository.getProfesores()) {
            if(unProfesor.getId() == id) {
                return unProfesor;
            }
        }
        return null;
    }

    public ArrayList<Profesor> getAll() {
        return profesorRepository.getProfesores();
    }

    public boolean update(long id, Profesor profesor) {
        int index = getIndex(id);
        if( index != -1) {
            profesorRepository.getProfesores().set(index, profesor);
            return true;
        }
        return false;
    }

    public boolean save(Profesor profesor) {
        return profesorRepository.getProfesores().add(profesor);
    }

    public boolean delete(long id) {
        int index = getIndex(id);
        if( index != -1 ) {
            profesorRepository.getProfesores().remove(index);
            return true;
        }
        return false;
    }
}
