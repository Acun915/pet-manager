package com.petmanager.jwtHandling.security.services;

import com.petmanager.Family.FamilyDto;
import com.petmanager.Family.FamilyEntity;
import com.petmanager.Family.FamilyMapper;
import com.petmanager.Family.FamilyRepository;
import com.petmanager.jwtHandling.models.User;
import com.petmanager.jwtHandling.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    FamilyRepository familyRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public void addUserToFamily(Long userId, Long familyId) {
        FamilyEntity familyEntity = familyRepository.findById(familyId).get();
        userRepository.updateFamily(userId, familyEntity);
    }

}
