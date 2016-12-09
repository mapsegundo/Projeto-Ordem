/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.modelos.Clientes;
import br.com.projeto.modelos.OrdemServicos;
import br.com.projeto.modelos.Servicos;
import br.com.projeto.modelos.Usuarios;
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

    public OrdemServicoDAO() throws SQLException {
        this.conexao = (Connection) new ConnectionFactory().getConnection();
    }

    public void cadastrarOS(OrdemServicos os) {
        try {
            //Criar comando SQL
            String cmdSql = "insert into tbordemservicos (fkIdCliente, fkIdServico, fkIdUsuario, descricaoServico, dataCadastro, horaServico) values(?,?,?,?,?,?)";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, os.getFkIdCliente().getIdCliente());
            stmt.setInt(2, os.getFkIdServico().getIdServico());
            stmt.setInt(3, os.getFkIdUsuario().getIdUsuario());
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

    public void alterarOS(OrdemServicos os) {
        try {
            //Criar comando SQL
            String cmdSql = "update tbordemservicos set fkIdCliente=?, fkIdServico=?, fkIdUsuario=?, descricaoServico=?, dataCadastro=?, horaServico=? where idOrdem=?";

            //Estruturar comando SQL 
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, os.getFkIdCliente().getIdCliente());
            stmt.setInt(2, os.getFkIdServico().getIdServico());
            stmt.setInt(3, os.getFkIdUsuario().getIdUsuario());
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

    public void excluirOS(OrdemServicos os) {
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

    // Fazendo inner join
    public List<OrdemServicos> listarTodasOSComInnerJoin() {
        List<OrdemServicos> listaOS = null;
        
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT os.idOrdem, cli.nome, ser.nomeServico, usu.usuario, "
                    + "os.descricaoServico, os.dataCadastro, os.horaServico "
                    + "from tbordemservicos as os "
                    + "inner join tbclientes as cli on (os.fkIdCliente = cli.idCliente) "
                    + "inner join tbservicos as ser on (os.fkIdServico = ser.idServico) "
                    + "inner join tbusuarios as usu on (os.fkIdUsuario = usu.idUsuario)";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            Clientes cli;
            Servicos ser;
            Usuarios usu;
            while (rs.next()) {
                os = new OrdemServicos();
                cli = new Clientes();
                ser = new Servicos();
                usu = new Usuarios();
                os.setIdOrdem(rs.getInt("os.idOrdem"));
                cli.setNome(rs.getString("cli.nome"));
                ser.setNomeServico(rs.getString("ser.nomeServico"));
                usu.setUsuario(rs.getString("usu.usuario"));
                os.setDescricaoServico(rs.getString("os.descricaoServico"));
                os.setDataCadastro(rs.getString("os.dataCadastro"));
                os.setHoraServico(rs.getString("os.horaServico"));

                os.setFkIdCliente(cli);
                os.setFkIdServico(ser);
                os.setFkIdUsuario(usu);
                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaOS;
    }

    public List<OrdemServicos> consultarPorData(String data) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT os.idOrdem, cli.nome, ser.nomeServico, usu.usuario, "
                    + "os.descricaoServico, os.dataCadastro, os.horaServico "
                    + "from tbordemservicos as os "
                    + "inner join tbclientes as cli on (os.fkIdCliente = cli.idCliente) "
                    + "inner join tbservicos as ser on (os.fkIdServico = ser.idServico) "
                    + "inner join tbusuarios as usu on (os.fkIdUsuario = usu.idUsuario) "
                    + "where os.dataCadastro =?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setString(1, data);
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            Clientes cli;
            Servicos ser;
            Usuarios usu;
            while (rs.next()) {
                os = new OrdemServicos();
                cli = new Clientes();
                ser = new Servicos();
                usu = new Usuarios();
                os.setIdOrdem(rs.getInt("os.idOrdem"));
                cli.setNome(rs.getString("cli.nome"));
                ser.setNomeServico(rs.getString("ser.nomeServico"));
                usu.setUsuario(rs.getString("usu.usuario"));
                os.setDescricaoServico(rs.getString("os.descricaoServico"));
                os.setDataCadastro(rs.getString("os.dataCadastro"));
                os.setHoraServico(rs.getString("os.horaServico"));

                os.setFkIdCliente(cli);
                os.setFkIdServico(ser);
                os.setFkIdUsuario(usu);

                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaOS;
    }

    public List<OrdemServicos> consultarPorServico(int servico) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT os.idOrdem, cli.nome, ser.nomeServico, usu.usuario, "
                    + "os.descricaoServico, os.dataCadastro, os.horaServico "
                    + "from tbordemservicos as os "
                    + "inner join tbclientes as cli on (os.fkIdCliente = cli.idCliente) "
                    + "inner join tbservicos as ser on (os.fkIdServico = ser.idServico) "
                    + "inner join tbusuarios as usu on (os.fkIdUsuario = usu.idUsuario) "
                    + "where ser.idServico=?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, servico);
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            Clientes cli;
            Servicos ser;
            Usuarios usu;
            while (rs.next()) {
                os = new OrdemServicos();
                cli = new Clientes();
                ser = new Servicos();
                usu = new Usuarios();
                os.setIdOrdem(rs.getInt("os.idOrdem"));
                cli.setNome(rs.getString("cli.nome"));
                ser.setNomeServico(rs.getString("ser.nomeServico"));
                usu.setUsuario(rs.getString("usu.usuario"));
                os.setDescricaoServico(rs.getString("os.descricaoServico"));
                os.setDataCadastro(rs.getString("os.dataCadastro"));
                os.setHoraServico(rs.getString("os.horaServico"));

                os.setFkIdCliente(cli);
                os.setFkIdServico(ser);
                os.setFkIdUsuario(usu);

                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaOS;
    }

    public List<OrdemServicos> consultarPorId(int id) {
        List<OrdemServicos> listaOS = null;
        try {
            //Criar vetor que vai armazenar as ordens de servico
            listaOS = new ArrayList<>();

            //Criar comando SQL
            String cmdSql = "SELECT os.idOrdem, cli.nome, ser.nomeServico, usu.usuario, "
                    + "os.descricaoServico, os.dataCadastro, os.horaServico "
                    + "from tbordemservicos as os "
                    + "inner join tbclientes as cli on (os.fkIdCliente = cli.idCliente) "
                    + "inner join tbservicos as ser on (os.fkIdServico = ser.idServico) "
                    + "inner join tbusuarios as usu on (os.fkIdUsuario = usu.idUsuario) "
                    + "where os.idOrdem = ?";

            //Executar o comando
            PreparedStatement stmt = conexao.prepareStatement(cmdSql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            //Percorrer os resultados no RS e colocados dentro da lista
            OrdemServicos os;
            Clientes cli;
            Servicos ser;
            Usuarios usu;
            while (rs.next()) {
                os = new OrdemServicos();
                cli = new Clientes();
                ser = new Servicos();
                usu = new Usuarios();
                os.setIdOrdem(rs.getInt("os.idOrdem"));
                cli.setNome(rs.getString("cli.nome"));
                ser.setNomeServico(rs.getString("ser.nomeServico"));
                usu.setUsuario(rs.getString("usu.usuario"));
                os.setDescricaoServico(rs.getString("os.descricaoServico"));
                os.setDataCadastro(rs.getString("os.dataCadastro"));
                os.setHoraServico(rs.getString("os.horaServico"));

                os.setFkIdCliente(cli);
                os.setFkIdServico(ser);
                os.setFkIdUsuario(usu);

                listaOS.add(os);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao montar a lista: " + e);
        }
        return listaOS;
    }
}
