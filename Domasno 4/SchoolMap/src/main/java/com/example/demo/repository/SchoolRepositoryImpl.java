package com.example.demo.repository;


import com.example.demo.exception.SchoolNotFoundException;
import com.example.demo.model.School;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SchoolRepositoryImpl implements SchoolRepository{

    /**
     * Bidejki imame mal broj na koordinati
     * podatocite gi citame vo fajl i gi
     * cuvame vo hash mapa vo nasata aplikacija
     */
    private HashMap<Long, School> schoolsInfo;


    /**
     * citac za csv fajlot so koordinatite od ucilistata
     */
    private BufferedReader schoolsReader;
    /**
     *
     * pri start na aplikacijata se
     * povikuva metodot za da se procitaat
     * podatocite za ucilistata od fajlot od
     * prvoto domasno
     */

    public SchoolRepositoryImpl() throws FileNotFoundException {
        schoolsInfo = new HashMap<Long, School>();
        /**
         * setiranje na citacot da cita od csv fajlot
         */
        schoolsReader = new BufferedReader(new FileReader("src/main/resources/assets/db.csv"));
    }

    @PostConstruct
    public void init(){
            /**
             So metodot citajucilista zemame lista od site ucilista i gi smestuvame vo
             mapata spored nivnoto id
             */

        try {
            for(School s : readFile(schoolsReader)) {
                schoolsInfo.put(s.getId(), s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<School> readFile(BufferedReader br) throws IOException {
        /**
         * brojac koj ni e kluc vo mapata, unikaten za sekoe uciliste
         */
        Long keyId = 1L;
        /**
         * edna procitana linija od fajlot
         */
        String schoolLine;


        /**
         * lista na ucilista sto treba da ja vratime
         */
        List<School> tmp = new ArrayList<>();
        /**
         * citanje na linija po linija dodeka ne dojde kraj na dokumentot
         */
        while((schoolLine = br.readLine()) != null){

            /**
             * delenje na csv redot
             */
            String[] csv = schoolLine.split(",");
            Double longitude = Double.parseDouble(csv[0]);
            Double latitude = Double.parseDouble(csv[1]);
            String name = csv[2];

            tmp.add(new School(keyId++,longitude,latitude,name));
        }
        return tmp;
    }



    public List<School> getSchools() {
        return new ArrayList<School>(schoolsInfo.values());
    }

    public School getSchoolById(Long id) throws SchoolNotFoundException {
        School toReturn = schoolsInfo.get(id);
        if(toReturn == null){
            throw new SchoolNotFoundException(id);
        }
        return toReturn;
    }
}
