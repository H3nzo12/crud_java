package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexaoDAO {
    
    public Connection conexaoBD(){
        Connection conn = null;
        
        try{
            String host ="jdbc:mysql://localhost:3306/bfveiculos?user=root&password=";
            conn = DriverManager.getConnection(host);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO DE CONEXAO" + e.getMessage());        
            
        }
        
        return conn;
    }
    
}
