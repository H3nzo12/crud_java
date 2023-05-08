package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn;
    
    public ResultSet autentica(UsuarioDTO usuario){
        conn = new ConexaoDAO().conexaoBD();
        
        try {
            String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha =?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,usuario.getUsuario());
            pstm.setString(2,usuario.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO usuario e senha DAO"+e.getMessage());
            return null;
        }
        
        
    }
    
}
