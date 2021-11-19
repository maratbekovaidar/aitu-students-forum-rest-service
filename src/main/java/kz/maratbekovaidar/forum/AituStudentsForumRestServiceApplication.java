package kz.maratbekovaidar.forum;

import kz.maratbekovaidar.forum.model.Role;
import kz.maratbekovaidar.forum.model.User;
import kz.maratbekovaidar.forum.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class AituStudentsForumRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AituStudentsForumRestServiceApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MODERATOR"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(
//					new User(null, "maratbekovaidar", "11qwerty", "maratbekovaidar@gmail.com", "87088893456", "Aidar", "Maratbekov", new ArrayList<>(), new ArrayList<>())
//			);
//
//			userService.addRoleToUser("maratbekovaidar", "ROLE_USER");
//			userService.addRoleToUser("maratbekovaidar", "ROLE_MODERATOR");
//			userService.addRoleToUser("maratbekovaidar", "ROLE_ADMIN");
//			userService.addRoleToUser("maratbekovaidar", "ROLE_SUPER_ADMIN");
		};
	}
}
