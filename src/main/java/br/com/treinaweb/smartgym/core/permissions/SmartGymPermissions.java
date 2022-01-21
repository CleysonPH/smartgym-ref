package br.com.treinaweb.smartgym.core.permissions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PreAuthorize;

public @interface SmartGymPermissions {

    @PreAuthorize("hasAuthority('ADMIN')")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isAdmin {}

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isInstructor {}

    @PreAuthorize("hasAnyAuthority('INSTRUCTOR', 'ADMIN')")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isInstructorOrAdmin {}

    @PreAuthorize("""
        hasAnyAuthority('INSTRUCTOR', 'ADMIN')
        or
        @securityUtilsImpl.isAuthenticatedClientOwnerOfWorkoutSheet(#workoutSheetId)
    """)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isInstructorOrAdminOrClientOwnerOfWorkoutSheet {}

    @PreAuthorize("""
        hasAuthority('ADMIN')
        or
        @securityUtilsImpl.isAuthenticatedInstructorOwnerOfWorkoutSheet(#workoutSheetId)
    """)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isAdminOrInstructorOwnerOfWorkoutSheet {}

    @PreAuthorize("""
        hasAnyAuthority('ADMIN', 'INSTRUCTOR')
        or
        @securityUtilsImpl.isAuthenticatedClientItself(#clientId)
    """)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isAdminOrInstructorOrClientItself {}

    @PreAuthorize("""
        hasAnyAuthority('ADMIN', 'INSTRUCTOR')
        or
        @securityUtilsImpl.isAuthenticatedClientOwnerOfWorkout(#workoutId)
    """)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isAdminOrInstructorOrClientOwnerOfWorkout {}

    @PreAuthorize("isAuthenticated")
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface isAuthenticated {}

}
