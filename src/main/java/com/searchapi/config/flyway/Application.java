package com.searchapi.config.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;

public class Application {

    public static void main(String[] args){

        String url = "jdbc:postgresql://localhost:YOUR_POSTGRESQL_SERVER_PORT/search-api";
        String user = "YOUR_POSTGRESQL_USER";
        String password = "YOUR_POSTGRESQL_PASS";

        Location migrationLoc = new Location("com/searchapi/config/db/migration");

        Flyway flyway = Flyway
                .configure()
                .dataSource(url,user,password)
                .locations(migrationLoc)
                .load();

        flyway.clean();

        flyway.migrate();
        flyway.info();

    }
}
