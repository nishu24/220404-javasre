package com.ex.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnector {
    /**
     *
     * @param username
     * @param password
     * @param url
     * @return
     * @throws SQLException
     */
    Connection getConnection(String username, String password, String url) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    Connection getConnection() throws SQLException;
}
