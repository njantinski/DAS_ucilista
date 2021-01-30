package com.example.demo.service;

import com.example.demo.model.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolService {
    public List<School> getSchools();
    public School getSchoolById(Long id);
}
