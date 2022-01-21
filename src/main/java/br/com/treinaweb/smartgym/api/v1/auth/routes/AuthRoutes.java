package br.com.treinaweb.smartgym.api.v1.auth.routes;

import br.com.treinaweb.smartgym.api.v1.common.routes.BaseRoutes;

public class AuthRoutes {

    private AuthRoutes() {}

    public static final String COLLECTION_PATH = "/auth";

    public static final String BASE_ROUTE = BaseRoutes.BASE_ROUTE + COLLECTION_PATH;
    public static final String TOKEN_ROUTE = BASE_ROUTE + "/token";
    public static final String REFRESH_ROUTE = BASE_ROUTE + "/refresh";

}
