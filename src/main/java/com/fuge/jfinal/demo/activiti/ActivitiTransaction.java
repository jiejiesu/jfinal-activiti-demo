package com.fuge.jfinal.demo.activiti;

/**
 * TODO.
 * <p>
 * User: sujie
 * Date: 2019/1/4
 * Time: 12:23 PM
 */
import com.jfinal.plugin.activerecord.DbKit;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ActivitiTransaction implements Transaction {

    protected Connection connection;
    protected DataSource dataSource;
    protected TransactionIsolationLevel level;
    protected boolean autoCommmit;

    public ActivitiTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
        dataSource = ds;
        level = desiredLevel;
        autoCommmit = desiredAutoCommit;
    }

    public ActivitiTransaction(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            openConnection();
        }
        return connection;
    }

    @Override
    public void commit() throws SQLException {
    }

    @Override
    public void rollback() throws SQLException {
    }

    @Override
    public void close() throws SQLException {
        if(connection!=null){
            DbKit.getConfig().close(connection);
        }
    }

    @Override
    public Integer getTimeout() throws SQLException
    {
        return null;
    }

    protected void openConnection() throws SQLException {
        connection = DbKit.getConfig().getConnection();
        if (level != null) {
            connection.setTransactionIsolation(level.getLevel());
        }
    }
}