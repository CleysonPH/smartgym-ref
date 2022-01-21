package br.com.treinaweb.smartgym.api.v1.client.routes;

import br.com.treinaweb.smartgym.api.v1.common.routes.BaseRoutes;
import br.com.treinaweb.smartgym.api.v1.workoutsheet.routes.WorkoutSheetRoutes;

public class ClientRoutes {

    private ClientRoutes() {}

    public static final String COLLECTION_PATH = "/clients";
    public static final String RESOURCE_PATH = "/{clientId}";

    public static final String BASE_ROUTE = BaseRoutes.BASE_ROUTE + COLLECTION_PATH;
    public static final String CREATE_ROUTE = BASE_ROUTE;

    public static final String FIND_WORKOUTSHEETS_BY_CLIENT_ID = BASE_ROUTE
        + RESOURCE_PATH
        + WorkoutSheetRoutes.COLLECTION_PATH;

}
