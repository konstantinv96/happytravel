package bg.softuni.happytravel.service;


import bg.softuni.happytravel.model.UserEntity;
import bg.softuni.happytravel.model.dto.UserRegistrationDTO;
import bg.softuni.happytravel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserRegistrationDTO registrationDTO){

        if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())){

            throw new RuntimeException("passwords.match");
        }

        Optional<UserEntity> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());

        if(byEmail.isPresent()){
            throw new RuntimeException("email.used");
        }

        UserEntity user = createUser(registrationDTO);

        this.userRepository.save(user);
    }

    private UserEntity createUser(UserRegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity(
                registrationDTO.getUsername(),
                passwordEncoder.encode(registrationDTO.getPassword()),
                registrationDTO.getEmail(),
                registrationDTO.getFullName());
        return user;
    }

    public UserEntity getUser (String username){
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }

}
