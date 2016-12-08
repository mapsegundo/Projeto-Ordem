/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.OrdemServicos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shall
 */
public class OrdemServicoDAO {
    
    private Connection conexao;
    
    public OrdemServicoDAO() throws SQLException{
        this.conexao = (Connection) new ConnectionFactory().getConnection();
    }
    
    public void cadastrarOS(OrdemServicos os){
        try {
            //Criar comando SQL
            String cmdSql = "insert into tbordemservicos (fkIdCliente, fkIdServico, fkIdUsuario, descricaoServico, dataCadastro, horaServico) values(?,?,?,?,?,?)";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, os.getFkIdCliente());
            stmt.setInt(2, os.getFkIdServico());
            stmt.setInt(3, os.getFkIdUsuario());
            stmt.setString(4, os.getDescricaoServico());
            stmt.setString(5, os.getDataCadastro());
            stmt.setString(6, os.getHoraServico());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public void alterarOS(OrdemServicos os){
        try {
            //Criar comando SQL
            String cmdSql = "update tbordemservicos set fkIdCliente=?, fkIdServico=?, fkIdUsuario=?, descricaoServico=?, dataCadastro=?, horaServico=? where idOrdem=?";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, os.getFkIdCliente());
            stmt.setInt(2, os.getFkIdServico());
            stmt.setInt(3, os.getFkIdUsuario());
            stmt.setString(4, os.getDescricaoServico());
            stmt.setString(5, os.getDataCadastro());
            stmt.setString(6, os.getHoraServico());
            stmt.setInt(7, os.getIdOrdem());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public void excluirOS(OrdemServicos os){
        try {
            //Criar comando SQL
            String cmdSql = "delete from tbordemservicos where idOrdem=?";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, os.getIdOrdem());

            //Executar o comando
            stmt.execute();

            //Fechar a conexao
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
    public List<OrdemServicos> listarTodasOS() {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbordemservicos";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            while(rs.next()){
                os = new OrdemServicos();
                os.setIdOrdem(rs.getInt("idOrdem"));
                os.setFkIdCliente(rs.getInt("fkIdCliente"));
                os.setFkIdServico(rs.getInt("fkIdServico"));
                os.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                os.setDescricaoServico(rs.getString("descricaoServico"));
                os.setDataCadastro(rs.getString("dataCadastro"));
                os.setHoraServico(rs.getString("horaServico"));
                
                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaOS;
    }
    
    public List<OrdemServicos> consultarPorData(String data) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbordemservicos where dataCadastro=?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            while(rs.next()){
                os = new OrdemServicos();
                os.setIdOrdem(rs.getInt("idOrdem"));
                os.setFkIdCliente(rs.getInt("fkIdCliente"));
                os.setFkIdServico(rs.getInt("fkIdServico"));
                os.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                os.setDescricaoServico(rs.getString("descricaoServico"));
                os.setDataCadastro(rs.getString("dataCadastro"));
                os.setHoraServico(rs.getString("horaServico"));
                
                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaOS;
    }
    
    public List<OrdemServicos> consultarPorServico(int servico) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbordemservicos where fkServicoId=?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, servico);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            while(rs.next()){
                os = new OrdemServicos();
                os.setIdOrdem(rs.getInt("idOrdem"));
                os.setFkIdCliente(rs.getInt("fkIdCliente"));
                os.setFkIdServico(rs.getInt("fkIdServico"));
                os.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                os.setDescricaoServico(rs.getString("descricaoServico"));
                os.setDataCadastro(rs.getString("dataCadastro"));
                os.setHoraServico(rs.getString("horaServico"));
                
                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaOS;
    }
    
    public List<OrdemServicos> consultarPorId(int id) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT * from tbordemservicos where idOrdem=?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            while(rs.next()){
                os = new OrdemServicos();
                os.setIdOrdem(rs.getInt("idOrdem"));
                os.setFkIdCliente(rs.getInt("fkIdCliente"));
                os.setFkIdServico(rs.getInt("fkIdServico"));
                os.setFkIdUsuario(rs.getInt("fkIdUsuario"));
                os.setDescricaoServico(rs.getString("descricaoServico"));
                os.setDataCadastro(rs.getString("dataCadastro"));
                os.setHoraServico(rs.getString("horaServico"));
                
                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: "+e);
        }
        return listaOS;
    }
}
