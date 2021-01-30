package com.example.demo.service;

import com.example.demo.model.School;
import com.example.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacija na servisot
 * so kojsto gi zimame
 * koordinatite na ucilistata
 * od bazata na podatoci
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;


    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository){
          this.schoolRepository = schoolRepository;
    }


    @Override
    public List<School> getSchools() {
        return schoolRepository.getSchools();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.getSchoolById(id);
    }
}