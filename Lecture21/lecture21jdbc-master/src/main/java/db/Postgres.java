package db;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.*;
import java.util.*;

public class Postgres {

    private Connection connection = null;
    private String dbUrl = "jdbc:postgresql://focusdb.c2d2h4vzk0ps.us-east-2.rds.amazonaws.com:5431/focus";
    private String user = "focus";
    private String password = "parol1234";
    private String driver;

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isOpen() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet execute(String queryStr) {
            try{ Statement stmt = connection.createStatement();
                return stmt.executeQuery(queryStr);
            } catch (SQLException e) {e.printStackTrace();}
        return null; // Let's handle it on upper levels. (e.g. database.Comparator.compareLists())
    }

    public ResultSet executeWithParams(String queryStr, String... params) {
        try{ PreparedStatement stmt = connection.prepareStatement(queryStr);
            for (int i=1; i < params.length + 1; i++){
                stmt.setString(i, params[i - 1]);
            }
            return  stmt.executeQuery();
            } catch (SQLException e) {e.printStackTrace();}
        return null; // Let's handle it on upper levels. (e.g. database.Comparator.compareLists())
    }

    public int executeUpdate(String queryStr) {
            try (Statement stmt = connection.createStatement()) {
                return stmt.executeUpdate(queryStr);
            } catch (SQLException e) {e.printStackTrace();}
        return -1;
    }

    private List<Map<String, String>> createResultMapping(ResultSet resultSet) throws SQLException {
        List<Map<String, String>> dbResultList = new ArrayList<>();
        Map<Integer, String> columnLabelToIndex = new HashMap<>();
        ResultSetMetaData metaData = resultSet.getMetaData();

        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columnLabelToIndex.put(i, metaData.getColumnName(i));
        }
        while (resultSet.next()) {
            Map<String, String> columnValueMap = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnValueMap.put(columnLabelToIndex.get(i), resultSet.getString(i));
            }
            dbResultList.add(resultSet.getRow() - 1, columnValueMap);

        }

        return dbResultList;
    }

    public List<Map<String, String>> executeNew(String queryStr) {
        if (isOpen()) {
            try (Statement stmt = connection.createStatement();
                 ResultSet result = stmt.executeQuery(queryStr);
            ) {
                return createResultMapping(result);
            } catch (SQLException e) {e.printStackTrace();}
        }
        return null; // Let's handle it on upper levels. (e.g. database.Comparator.compareLists())
    }


    public void executeScript(String queryStr) {
            Reader targetReader = new StringReader(queryStr);
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setStopOnError(true);
            runner.setSendFullScript(true);
            runner.runScript(targetReader);
            runner.closeConnection();

            try {
                targetReader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
    }

}
