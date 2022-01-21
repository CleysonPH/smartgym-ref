package br.com.treinaweb.smartgym.core.utils;

import org.springframework.security.core.Authentication;

import br.com.treinaweb.smartgym.core.models.Client;
import br.com.treinaweb.smartgym.core.models.Instructor;
import br.com.treinaweb.smartgym.core.models.User;

public interface SecurityUtils {

    Authentication getAuthentication();

    void setAuthentication(Authentication authentication);

    String getAuthenticatedUserEmail();

    Instructor getAuthenticatedInstructor();

    Client getAuthenticatedClient();

    User getAuthenticatedUser();

    boolean isAuthenticatedClientOwnerOfWorkoutSheet(Long workoutSheetId);

    boolean isAuthenticatedClientOwnerOfWorkout(Long workoutId);

    boolean isAuthenticatedInstructorOwnerOfWorkoutSheet(Long workoutSheetId);

    boolean isAuthenticatedClientItself(Long clientId);

    boolean isAuthenticatedUserAnClient();

    boolean isAuthenticatedUserAnInstructor();

    boolean isAuthenticatedUserAnAdmin();

}
