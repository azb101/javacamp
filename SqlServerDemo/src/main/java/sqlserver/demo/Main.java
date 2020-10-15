package sqlserver.demo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import javax.sql.rowset.spi.TransactionalWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

class Main {

    public static final String DB_URL = "jdbc:sqlserver://localhost:1433";

    /**
     * BDCP2 is not super performant
     * C3PO is better
     * Hikari is even better, used in SPringBoot by default
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        try (var bds = new BasicDataSource())
        {
            bds.setUrl(DB_URL);
            bds.setUsername("sa");
            bds.setPassword("Password!123");
            bds.setMinIdle(5);
            bds.setMaxIdle(10);
            bds.setMaxOpenPreparedStatements(100);

            try(var connection = bds.getConnection())
            {
                connection.setCatalog("SpeakNativeDB");
                connection.setAutoCommit(false);

                DSLContext ctx = DSL.using(connection, SQLDialect.DEFAULT);

                var result = ctx
                        .select()
                        .from("Phrases")
                        .fetch();

                for(var item : result)
                {
                    System.out.println(item.get("ReferenceLang"));
                }

                connection.commit();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
