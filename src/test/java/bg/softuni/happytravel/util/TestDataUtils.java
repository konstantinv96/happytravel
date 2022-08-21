package bg.softuni.happytravel.util;


import bg.softuni.happytravel.model.Role;
import bg.softuni.happytravel.model.UserEntity;
import bg.softuni.happytravel.model.enums.UserRoles;
import bg.softuni.happytravel.repository.RoleRepository;
import bg.softuni.happytravel.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class TestDataUtils {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public TestDataUtils(UserRepository userRepository , RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
}
