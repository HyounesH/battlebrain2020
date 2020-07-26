package yh.sqli.hackton.seats_reservation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yh.sqli.hackton.seats_reservation.domain.User;
import yh.sqli.hackton.seats_reservation.repository.UserRepository;

import java.util.UUID;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(UUID identify) {
        User user = userRepository.findByUid(identify)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + identify)
                );
        return UserPrincipal.create(user);
    }
}
