package Obj;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

import Conect.Conexao;
import Conect.Criptografia;

public class Cliente implements Serializable {
    
    private String email;
    private String senha;
    private String nome;
    private boolean online;
    private int diasIntervaloNotificacao;
    private LocalDate ultimaAtualizacao;

    private List<Veiculo> veiculos;

    public Cliente(String nome){
        boolean online = false;
        email = null;
        senha = null;
        this.nome = nome;
        this.veiculos = new LinkedList<Veiculo>();
        this.ultimaAtualizacao = LocalDate.now();
        this.diasIntervaloNotificacao = 3; 
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Cliente(String nome, String email, String senha){
        boolean online = true;
        this.email = email;
        this.senha = Criptografia.senha(senha);
        this.nome = nome;
        this.veiculos = new LinkedList<Veiculo>();
        this.ultimaAtualizacao = LocalDate.now();
        this.diasIntervaloNotificacao = 3; 
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return this.veiculos.remove(veiculo);
    }

    public void save_in_db(){
        Connection con = Conexao.getConnection();
        String str = "INSERT INTO usuarios(nome, senha, email) VALUES ('"+nome+"', '"+senha+"', '"+email+"')";
        try {
            PreparedStatement pstmt = con.prepareStatement(str);
            pstmt.execute();
            con.close();
        } catch (SQLException e) {

        }
    }
    
    public boolean checkAtualizacao(){
        long diffDias = ChronoUnit.DAYS.between(this.ultimaAtualizacao, LocalDate.now());
        if(diffDias > this.diasIntervaloNotificacao){
            return true;
        }
        return false;
    }

    public void atualizaUltimaNotificacao(){
        this.ultimaAtualizacao = LocalDate.now();
    }

    //gets e sets

    public boolean getOnline(){
        return online;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getDiasIntervaloNotificacao() {
        return diasIntervaloNotificacao;
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setdiasIntervaloNotificacao(int dias) {
        this.diasIntervaloNotificacao = dias;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String str = "";

        str += "Nome: " + this.nome;
        str += "\nVeiculos:\n";
        for(int i = 0; i < this.veiculos.size(); i++){
            str += "------------------------------\n";
            str += this.veiculos.get(i).toString();
        }
        str += "\n------------------------------\n";
        return str;
    }
}
