package com.example.security.auth;

import com.example.security.configuration.ApplicationUserRole;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.security.configuration.ApplicationUserRole.*;

@Repository("fake")
@RequiredArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    STUDENT.getGrantedAuthorities(),
                    passwordEncoder.encode("1234"),
                    "min",
                    true,
                   true,
                    true,
                    true
            ),
            new ApplicationUser(
                    ADMIN.getGrantedAuthorities(),
                    passwordEncoder.encode("1234"),
                    "linda",
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    ADMINTRAINEE.getGrantedAuthorities(),
                    passwordEncoder.encode("1234"),
                    "tom",
                    true,
                    true,
                    true,
                    true
            )
        );
        return applicationUsers;
    }
}
