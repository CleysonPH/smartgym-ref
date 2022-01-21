package br.com.treinaweb.smartgym.api.v1.workoutsheet.routes;

import br.com.treinaweb.smartgym.api.v1.common.routes.BaseRoutes;

public class WorkoutSheetRoutes {

    private WorkoutSheetRoutes() {}

    public static final String COLLECTION_PATH = "/workoutsheets";
    public static final String RESOURCE_PATH = "/{workoutSheetId}";

    public static final String BASE_ROUTE = BaseRoutes.BASE_ROUTE + COLLECTION_PATH;
    public static final String CREATE_ROUTE = BASE_ROUTE;
    public static final String FIND_ALL_ROUTE = BASE_ROUTE;
    public static final String FIND_BY_ID = BASE_ROUTE + RESOURCE_PATH;
    public static final String DELETE_BY_ID = BASE_ROUTE + RESOURCE_PATH;
    public static final String UPDATE_BY_ID = BASE_ROUTE + RESOURCE_PATH;

}
