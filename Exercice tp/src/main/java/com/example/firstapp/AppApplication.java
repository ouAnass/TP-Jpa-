package com.example.firstapp;

import com.example.firstapp.Entities.Etudiant;
import com.example.firstapp.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        etudiantRepository.save(new Etudiant(null, "A1","Amine",new Date(),true,null));
        etudiantRepository.save(new Etudiant(null, "A2","Ilyas",new Date(),true,null));

        System.out.println("Count : "+ etudiantRepository.count());

        List<Etudiant> etudiants = etudiantRepository.findAll();
        etudiants.forEach(etudiant -> {
            System.out.println(etudiant.toString());
        });

        Etudiant etudiant = etudiantRepository.findById(3).orElse(null);
        System.out.println(etudiant.toString());

        etudiant.setRegistrationNumber("S3");
        etudiantRepository.save(etudiant);

        etudiantRepository.delete(etudiant);
        System.out.println("Count : "+ etudiantRepository.count());

        etudiantRepository.deleteById(5);
        System.out.println("Count : "+ etudiantRepository.count());
    }
}