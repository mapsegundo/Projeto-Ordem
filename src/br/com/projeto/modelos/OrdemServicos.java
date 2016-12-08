/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.modelos;

/**
 *
 * @author Shall
 */
public class OrdemServicos {

    private int idOrdem;
    private int fkIdCliente;
    private int fkIdServico;
    private int fkIdUsuario;
    private String descricaoServico;
    private String dataCadastro;
    private String horaServico;

    public int getIdOrdem() {
        return idOrdem;
    }

    public void setIdOrdem(int idOrdem) {
        this.idOrdem = idOrdem;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public int getFkIdServico() {
        return fkIdServico;
    }

    public void setFkIdServico(int fkIdServico) {
        this.fkIdServico = fkIdServico;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getHoraServico() {
        return horaServico;
    }

    public void setHoraServico(String horaServico) {
        this.horaServico = horaServico;
    }

}
