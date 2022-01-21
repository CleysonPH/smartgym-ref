package br.com.treinaweb.smartgym.core.services.authentication.providers;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import br.com.treinaweb.smartgym.core.services.authentication.adapters.AuthenticationService;
import br.com.treinaweb.smartgym.core.services.authentication.dtos.AuthenticatedUser;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var message = String.format("Usuário com email %s não econtrado", email);
        return userRepository.findByEmail(email)
            .map(AuthenticatedUser::new)
            .orElseThrow(() -> new UsernameNotFoundException(message));
    }

}
