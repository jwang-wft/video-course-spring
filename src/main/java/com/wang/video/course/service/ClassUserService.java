package com.wang.video.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.video.course.entity.ClassUser;
import com.wang.video.course.jpa.ClassUserRepository;

@Service
public class ClassUserService implements UserDetailsService {

    @Autowired
    private ClassUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<ClassUser> user = userRepository.findByUsername( s );
        if ( user.isPresent() ) {
            return user.get();
        } else {
            throw new UsernameNotFoundException(String.format("Username[%s] not found", s));
        }
    }

    public Optional<ClassUser> findByUsername(String username) {
        Optional<ClassUser> user = userRepository.findByUsername( username );
        return user;
    }

    public ClassUser register(ClassUser user) {
    	return userRepository.save(user);
     }

    @Transactional // To successfully remove the date @Transactional annotation must be added
    public void removeAuthenticatedAccount() throws UsernameNotFoundException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<ClassUser> user = userRepository.findByUsername(username);
        if(!user.isPresent()) {
        	throw new UsernameNotFoundException(String.format("the user with email[%s] not found.", username));
        }
        userRepository.deleteById(user.get().getId());

    }
}
