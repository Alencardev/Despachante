/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package despach.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class ConnectionFactory {
    static public Connection getConnection(){
        try {
            //URL para conexão com o BD
            final String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [alencar1995 on Default schema]"
                    //Comandos extras para estabelecer uma conexão segura com o BD
                    //Ficou curioso? Estude sobre SSL
                    + "?verifyServerCertificate=false&useSSL=true";
            final String user = "alencar1995";
            final String password = "1808";
            
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //Lança a exceção na tela em tempo de execução para sabermos o que aconteceu
            throw new RuntimeException(e);
        }
    }
    
}
