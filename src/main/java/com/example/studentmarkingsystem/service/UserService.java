package com.example.studentmarkingsystem.service;

import com.example.studentmarkingsystem.dto.auth.RegistrationRequest;
import com.example.studentmarkingsystem.entity.Admin;
import com.example.studentmarkingsystem.entity.Parent;
import com.example.studentmarkingsystem.entity.Student;
import com.example.studentmarkingsystem.entity.Teacher;
import com.example.studentmarkingsystem.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(AdminRepository adminRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, ParentRepository parentRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegistrationRequest request, String role) {
        String username = request.getUsername();
        String password = passwordEncoder.encode(request.getPassword());

        switch (role.toUpperCase()) {
            case "ADMIN":
                if (adminRepository.findByAdminUsername(username).isPresent()) {
                    throw new IllegalArgumentException("Admin with that username or email already exists");
                }
                Admin newAdmin = new Admin();
                newAdmin.setAdminUsername(username);
                newAdmin.setAdminPassword(password);
                adminRepository.save(newAdmin);
                break;
            case "TEACHER":
                if (teacherRepository.findByTeacherUsername(username).isPresent()) {
                    throw new IllegalArgumentException("Teacher with that username or email already exists");
                }
                Teacher newTeacher = new Teacher();
                newTeacher.setTeacherUsername(username);
                newTeacher.setTeacherPassword(password);
                teacherRepository.save(newTeacher);
                break;
            case "STUDENT":
                if (studentRepository.findByStudentUsername(username).isPresent()) {
                    throw new IllegalArgumentException("Student with that username or email already exists");
                }
                Student newStudent = new Student();
                newStudent.setStudentUsername(username);
                newStudent.setStudentPassword(password);
                studentRepository.save(newStudent);
                break;
            case "PARENT":
                if (parentRepository.findByParentUsername(username).isPresent()) {
                    throw new IllegalArgumentException("Parent with that username or email already exists");
                }
                Parent newParent = new Parent();
                newParent.setParentUsername(username);
                newParent.setParentPassword(password);
                parentRepository.save(newParent);
                break;
            default:
                throw new IllegalArgumentException("Invalid registration role: " + role);
        }
        // Potentially trigger email verification process here
    }
}
