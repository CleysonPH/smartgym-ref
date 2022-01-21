package br.com.treinaweb.smartgym.api.v1.workout.routes;

import br.com.treinaweb.smartgym.api.v1.common.routes.BaseRoutes;

public class WorkoutRoutes {

    private WorkoutRoutes() {}

    public static final String COLLECTION_PATH = "/workouts";
    public static final String RESOURCE_PATH = "/{workoutId}";

    public static final String BASE_ROUTE = BaseRoutes.BASE_ROUTE + COLLECTION_PATH;
    public static final String CREATE_ROUTE = BASE_ROUTE;
    public static final String FIND_BY_ID = BASE_ROUTE + RESOURCE_PATH;
    public static final String UPDATE_BY_ID = BASE_ROUTE + RESOURCE_PATH;
    public static final String DELETE_BY_ID = BASE_ROUTE + RESOURCE_PATH;

}
