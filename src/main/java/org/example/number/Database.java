
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    public Database() {
        if (connection != null) return;

        withSql(() -> {
            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:mem:mymemdb.db", "SA", "");

            connection.setAutoCommit(false);

            try (var preparedStatement = connection.prepareStatement(
                    "create table if not exists shoppingcart (" +
                            "type varchar(100), " +
                            "name varchar(100), " +
                            "quantity int, " +
                            "priceperunit double)"
            )) {
                preparedStatement.execute();
                connection.commit();
            }
            return null;
        });
    }

    public Connection getConnection() {
        return connection;
    }

    public void resetDatabase() {
        withSql(() -> {
            try (var preparedStatement = connection.prepareStatement(
                    "delete from shoppingcart"
            )) {
                preparedStatement.execute();
                connection.commit();
            }
            return null;
        });
    }

    public interface SqlSupplier<T> {
        T doSql() throws SQLException;
    }

    public <T> T withSql(SqlSupplier<T> sqlSupplier) {
        try {
            return sqlSupplier.doSql();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        withSql(() -> {
            if (connection != null) {
                connection.close();
            }
            return null;
        });
        connection = null;
    }
}