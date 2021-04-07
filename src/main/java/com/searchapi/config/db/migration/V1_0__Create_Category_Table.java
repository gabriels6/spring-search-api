package com.searchapi.config.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_0__Create_Category_Table extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {

        String createTable = "CREATE TABLE IF NOT EXISTS Category("+
                "\tId SERIAL PRIMARY KEY,\n"+
                "\tName VARCHAR(75) NOT NULL\n"+
                ")";

        Statement insert = context.getConnection().createStatement();
        insert.execute(createTable);

    }
}
