package com.ex.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector implements DBConnector {

    private String username;
    private String password;
    private String url;

    public MySQLConnector() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @param username
     * @param password
     * @param url
     */
    public MySQLConnector(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    /**
     *
     * @param username
     * @param password
     * @param url
     * @return
     * @throws SQLException
     */
    @Override
    public Connection getConnection(String username, String password, String url) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        return this.getConnection(username,password,url);
    }
}
