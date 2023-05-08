package DAO;

import DTO.VeiculoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VeiculoDAO {
    Connection conn;
    
    public void inserirVeiculo(VeiculoDTO veiculo){
        conn = new ConexaoDAO().conexaoBD();
        
        try {
            String sql = "INSERT INTO veiculos(placa, modelo, marca, km, anofabri, anomodelo) VALUES(?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,veiculo.getPlaca());
            pstm.setString(2,veiculo.getModelo());
            pstm.setString(3,veiculo.getMarca());
            pstm.setDouble(4,veiculo.getKm());
            pstm.setInt(5,veiculo.getAnoFabri());
            pstm.setInt(6,veiculo.getAnoModelo());
            
            pstm.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR VEICULO"+e.getMessage());
      
        }
        
        
    }
    
    ArrayList<VeiculoDTO> veiculoc = new ArrayList<>();
    public ArrayList<VeiculoDTO> consultar(){
        conn = new ConexaoDAO().conexaoBD();
        
        try {
            String sql = "SELECT * FROM veiculos";
            PreparedStatement pstc = conn.prepareStatement(sql);
            
            
            ResultSet rs = pstc.executeQuery();
            
            while(rs.next()){
                VeiculoDTO vDTO = new VeiculoDTO();
                
                vDTO.setId(rs.getInt("id"));
                vDTO.setPlaca(rs.getString("placa"));
                vDTO.setModelo(rs.getString("modelo"));
                vDTO.setMarca(rs.getString("marca"));
                vDTO.setKm(rs.getDouble("km"));
                vDTO.setAnoFabri(rs.getInt("anofabri"));
                vDTO.setAnoModelo(rs.getInt("anomodelo"));
                
                veiculoc.add(vDTO);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO usuario e senha DAO"+e.getMessage());
        }
        return veiculoc;
        
    }
    
    public void deletarVeiculo(VeiculoDTO veiculod){
        conn = new ConexaoDAO().conexaoBD();
        
        try {
            String sql = "DELETE FROM veiculos WHERE id = ?";
            PreparedStatement pstd = conn.prepareStatement(sql);
            
            pstd.setInt(1,veiculod.getId());
            pstd.execute();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO DELETAR"+e.getMessage());
        
        }
        
        JOptionPane.showMessageDialog(null, "Veiculo deletado");
        
   
    }
    
    public void alterarVeiculo(VeiculoDTO veiculo){
        conn = new ConexaoDAO().conexaoBD();
        
        try {
            String sql = "UPDATE veiculos SET placa = ?, modelo = ?, marca = ?, km = ?, anofabri = ?, anomodelo = ? WHERE id = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,veiculo.getPlaca());
            pstm.setString(2,veiculo.getModelo());
            pstm.setString(3,veiculo.getMarca());
            pstm.setDouble(4,veiculo.getKm());
            pstm.setInt(5,veiculo.getAnoFabri());
            pstm.setInt(6,veiculo.getAnoModelo());
            
            pstm.setInt(7,veiculo.getId());
            
            pstm.execute();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR VEICULO"+e.getMessage());
      
        }
        
        
    }
}