package com.hana.app.service;

import com.hana.app.data.dto.AdminDto;
import com.hana.app.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    final AdminRepository adminRepository;
    public AdminDto findById(String id) {
        return adminRepository.findById(id);
    }
}
