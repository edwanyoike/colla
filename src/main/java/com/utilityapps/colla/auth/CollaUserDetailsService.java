package com.utilityapps.colla.auth;

import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.repositories.AuthGroupRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaUserDetailsService implements UserDetailsService {

    private final UserServiceI userService;
    private final AuthGroupRepository authGroupRepository;

    public CollaUserDetailsService(UserServiceI userService, AuthGroupRepository authGroupRepository) {
        this.userService = userService;

        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUsername(username);
           if( user != null)
           {
               List<AuthGroup>  authGroups = authGroupRepository.findByUsername(user.getUsername());
               return new CollaUserPrincipal( user, authGroups);

           }
           else
           {

               throw new UsernameNotFoundException("can't find username");
           }

    }
}
