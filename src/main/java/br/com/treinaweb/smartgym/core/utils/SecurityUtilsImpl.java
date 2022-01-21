package br.com.treinaweb.smartgym.core.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.treinaweb.smartgym.core.enums.Role;
import br.com.treinaweb.smartgym.core.models.Client;
import br.com.treinaweb.smartgym.core.models.Instructor;
import br.com.treinaweb.smartgym.core.models.User;
import br.com.treinaweb.smartgym.core.repositories.ClientRepository;
import br.com.treinaweb.smartgym.core.repositories.InstructorRepository;
import br.com.treinaweb.smartgym.core.repositories.UserRepository;
import br.com.treinaweb.smartgym.core.repositories.WorkoutRepository;
import br.com.treinaweb.smartgym.core.repositories.WorkoutSheetRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityUtilsImpl implements SecurityUtils {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final WorkoutRepository workoutRepository;
    private final InstructorRepository instructorRepository;
    private final WorkoutSheetRepository workoutSheetRepository;

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public void setAuthentication(Authentication authentication) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public String getAuthenticatedUserEmail() {
        return getAuthentication().getName();
    }

    @Override
    public Instructor getAuthenticatedInstructor() {
        return instructorRepository.findByUserEmailOrElseThrow(getAuthenticatedUserEmail());
    }

    @Override
    public Client getAuthenticatedClient() {
        return clientRepository.findByUserEmailOrElseThrow(getAuthenticatedUserEmail());
    }

    @Override
    public User getAuthenticatedUser() {
        return userRepository.findByEmailOrElseThrow(getAuthenticatedUserEmail());
    }

    @Override
    public boolean isAuthenticatedClientOwnerOfWorkoutSheet(Long workoutSheetId) {
        return isAuthenticatedUserAnClient()
            && workoutSheetRepository.existsByIdAndClientUserEmail(
                workoutSheetId,
                getAuthenticatedUserEmail()
            );
    }

    @Override
    public boolean isAuthenticatedInstructorOwnerOfWorkoutSheet(Long workoutSheetId) {
        return isAuthenticatedUserAnInstructor()
            && workoutSheetRepository.existsByIdAndInstructorUserEmail(
                workoutSheetId,
                getAuthenticatedUserEmail()
            );
    }

    @Override
    public boolean isAuthenticatedClientOwnerOfWorkout(Long workoutId) {
        return isAuthenticatedUserAnClient()
            && workoutRepository.existsByIdAndWorkoutSheetClientUserEmail(
                workoutId,
                getAuthenticatedUserEmail()
            );
    }

    @Override
    public boolean isAuthenticatedUserAnClient() {
        return checkAuthenticatedUserAuthority(Role.CLIENT);
    }

    @Override
    public boolean isAuthenticatedUserAnInstructor() {
        return checkAuthenticatedUserAuthority(Role.INSTRUCTOR);
    }

    @Override
    public boolean isAuthenticatedUserAnAdmin() {
        return checkAuthenticatedUserAuthority(Role.ADMIN);
    }

    @Override
    public boolean isAuthenticatedClientItself(Long clientId) {
        return isAuthenticatedUserAnClient()
            && clientRepository.existsByIdAndUserEmail(clientId, getAuthenticatedUserEmail());
    }

    private boolean checkAuthenticatedUserAuthority(Role role) {
        var authentication = getAuthentication();
        return authentication.getAuthorities()
            .stream()
            .anyMatch(authority -> authority.getAuthority().equals(role.name()));
    }

}
