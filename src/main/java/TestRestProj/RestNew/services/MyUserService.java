package TestRestProj.RestNew.services;

import TestRestProj.RestNew.entity.Users;
import TestRestProj.RestNew.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findAllByEmail(username);
       if(user == null){
           throw new UsernameNotFoundException("Username not found");
       }
       return user;
    }
}
