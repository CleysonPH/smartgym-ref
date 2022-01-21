package br.com.treinaweb.smartgym;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.treinaweb.smartgym.core.enums.Role;
import br.com.treinaweb.smartgym.core.models.User;
import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SmartgymApplication implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SmartgymApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Creating ADMIN user");
		var admin = User.builder()
			.email("admin@mail.com")
			.password(passwordEncoder.encode("senha@123"))
			.role(Role.ADMIN)
			.build();
		userRepository.save(admin);
	}

}
