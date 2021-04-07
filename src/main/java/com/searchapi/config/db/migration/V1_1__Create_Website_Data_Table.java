package com.searchapi.config.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_1__Create_Website_Data_Table extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {

        String createTable = "CREATE TABLE IF NOT EXISTS Website_Data("+
                "\tId SERIAL PRIMARY KEY NOT NULL,\n"+
                "\tLink VARCHAR(255) NOT NULL,\n"+
                "\tTitle VARCHAR(50) NOT NULL,\n"+
                "\tDescription VARCHAR(255) NOT NULL,\n"+
                "\tCategory_id INT NOT NULL,\n"+
                "\tCONSTRAINT fk_category\n"+
                "\t \tFOREIGN KEY(Category_id)\n"+
                "\t \tREFERENCES Category(Id)\n"+
                ")";

        Statement insert = context.getConnection().createStatement();
        insert.execute(createTable);

    }
}
