package yh.sqli.hackton.seats_reservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yh.sqli.hackton.seats_reservation.domain.Seat;
import yh.sqli.hackton.seats_reservation.domain.User;
import yh.sqli.hackton.seats_reservation.repository.UserRepository;
import yh.sqli.hackton.seats_reservation.services.UserService;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addBookedSeatToUser(String username, Seat seat) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setSeat(seat);
            userRepository.save(user);
        }
    }
}
