package uz.pdp.ecommerce.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.ecommerce.entity.Role;
import uz.pdp.ecommerce.entity.RoleName;
import uz.pdp.ecommerce.entity.User;
import uz.pdp.ecommerce.repo.RoleRepository;
import uz.pdp.ecommerce.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Override
    public void run(String... args) throws Exception {
        if (ddlAuto.equals("create")) {
            Role role1 = Role.builder()
                    .roleName(RoleName.ROLE_USER)
                    .build();
            Role role2 = Role.builder()
                    .roleName(RoleName.ROLE_ADMIN)
                    .build();
            List<Role> allRoles = roleRepository.saveAll(new ArrayList<>(List.of(role1, role2)));

            User user1 = User.builder()
                    .roles(new ArrayList<>(List.of(allRoles.get(0))))
                    .username("a")
                    .password(passwordEncoder.encode("1"))
                    .fullName("Eshmat Toshmatov")
                    .build();
            userRepository.save(user1);
            User user2 = User.builder()
                    .roles(new ArrayList<>(List.of(allRoles.get(1))))
                    .username("b")
                    .password(passwordEncoder.encode("2"))
                    .fullName("Hikmat Nusratov")
                    .build();
            userRepository.save(user2);

        }
    }
}

