package org.xxharutoxx.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConnectionSQlite {
    protected static Connection conexion;
    protected static PreparedStatement consulta;
    protected static ResultSet resultado;

    protected static final String DRIVER="org.sqlite.JDBC";
    //    protected static final String DRIVER="SQLite.JDBCDriver";
//    protected static final String DB_URL=String.format("jdbc:sqlite:%s",Conexion.class.getResource("motoSystem.sqlite"));
    protected static final String DB_URL="jdbc:sqlite::resource:com/xxharutoxx/db/softlibre.sqlite";

    protected static boolean openConexion(){
        try{
            Class.forName(DRIVER);
            conexion= DriverManager.getConnection(DB_URL);
            return false;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
    protected static boolean closeConexion(){
        try{
            if(!conexion.isClosed()){
                consulta.close();
                conexion.close();
            }
            return false;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
}

