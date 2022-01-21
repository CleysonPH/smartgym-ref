package br.com.treinaweb.smartgym.api.v1.instructor.routes;

import br.com.treinaweb.smartgym.api.v1.common.routes.BaseRoutes;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.routes.WorkoutSheetRoutes;

public class InstructorRoutes {

    private InstructorRoutes() {}

    public static final String COLLECTION_PATH = "/instructors";
    public static final String RESOURCE_PATH = "/{instructorId}";

    public static final String BASE_ROUTE = BaseRoutes.BASE_ROUTE + COLLECTION_PATH;
    public static final String CREATE_ROUTE = BASE_ROUTE;
    public static final String FIND_WORKOUTSHEETS_BY_INSTRUCTOR_ID = BASE_ROUTE
        + RESOURCE_PATH
        + WorkoutSheetRoutes.COLLECTION_PATH;

}
