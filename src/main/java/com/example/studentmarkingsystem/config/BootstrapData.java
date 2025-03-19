package com.example.studentmarkingsystem.config;

import com.example.studentmarkingsystem.entity.Student;
import com.example.studentmarkingsystem.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public BootstrapData(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student alice = new Student();
        alice.setStudentUsername("Alice Johnson");
        alice.setStudentPassword("alice123");

        Student bob = new Student();
        bob.setStudentUsername("Bob Smith");
        bob.setStudentPassword("bob456");

        Student aliceSaved = studentRepository.save(alice);
        Student bobSaved = studentRepository.save(bob);

        System.out.println("In Bootstrap");
        System.out.println("Added Student: " + aliceSaved.getStudentUsername() + ", Password: " + aliceSaved.getStudentPassword());
        System.out.println("Added Student: " + bobSaved.getStudentUsername() + ", Password: " + bobSaved.getStudentPassword());
    }
}