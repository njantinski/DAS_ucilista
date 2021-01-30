package com.example.demo.repository;


import com.example.demo.model.School;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository {
    public List<School> getSchools();
    public School getSchoolById(Long id);

}
