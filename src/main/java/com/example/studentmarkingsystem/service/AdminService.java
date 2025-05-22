package com.example.studentmarkingsystem.service;

import com.example.studentmarkingsystem.entity.Admin;
import com.example.studentmarkingsystem.entity.Users;
import com.example.studentmarkingsystem.repository.AdminRepository;
import com.example.studentmarkingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = getAdminById(id);
        admin.setAdminUsername(adminDetails.getAdminUsername());
        admin.setAdminPassword(adminDetails.getAdminPassword());
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

//    @Autowired
//    private JWTService jwtService;
//
//    @Autowired
//    AuthenticationManager authManager;
//
//    @Autowired
//    private AdminRepository repo;
//
//
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//
//    public Admin register(Admin admin) {
//        admin.setAdminPassword(encoder.encode(admin.getAdminPassword()));
//        repo.save(admin);
//        return admin;
//    }
//
//    public String verify(Users user) {
//        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//        if (authentication.isAuthenticated()) {
//            return jwtService.generateToken(user.getUsername());
//        } else {
//            return "fail";
//        }
//    }
}