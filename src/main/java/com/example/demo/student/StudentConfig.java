package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean //Bunu eklemezsek verilerimiz data basemize eklenmiyor.
    CommandLineRunner commandLineRunner(StudentRepository repository){  //Bu taraf bize uygulama ayağa kalktıgında bu işledigimiz verilerinde calısmasını saglıyor.

        return  args -> {                     //Buranın neden return args olduğunu sor.
            Student mariam = new  Student(
                    "Mariam",
                    "Mariam@gmail.com",
                    LocalDate.of(1997, 11, 21)


                    //id leri sildik database otomatik atıcak.
            );
            Student alex = new  Student(
                    "Alex",
                    "Alex@gmail.com",
                    LocalDate.of(2001, 02, 12)



            );
            repository.saveAll(List.of(mariam, alex));

        };



    }
}
