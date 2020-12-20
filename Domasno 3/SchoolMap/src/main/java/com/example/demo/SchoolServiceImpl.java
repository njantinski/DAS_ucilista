package com.example.demo;

import com.example.demo.model.School;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SchoolServiceImpl{

    private HashMap<Long, School> schools;

    private  BufferedReader br;



    public SchoolServiceImpl(){
        schools = new HashMap();
    }

    @PostConstruct
    public void init(){
        try{
            Long num = 1L;
            br = new BufferedReader(new FileReader("src/main/resources/assets/db.csv"));
            String line;
            List<School> tmp = new ArrayList<>();
            while((line = br.readLine()) != null){

                String[] csv = line.split(",");
                Double longitude = Double.parseDouble(csv[0]);
                Double latitude = Double.parseDouble(csv[1]);
                String name = csv[2];

                tmp.add(new School(num++,longitude,latitude,name));
            }

            for(School s : tmp){
                schools.put(s.getId(),s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<School> getSchools() {
        return new ArrayList<School>(schools.values());
    }

    public School getById(Long id) throws SchoolNotFoundException {
        School toReturn = schools.get(id);
        if(toReturn == null){
            throw new SchoolNotFoundException(id);
        }
        return toReturn;
    }
}