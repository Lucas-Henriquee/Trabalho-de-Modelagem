package Obj;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
    
    private String nome;
    private int intervaloNotificacao;

    private List<Veiculo> veiculos;

    public Cliente(String nome){
        this.nome = nome;
        this.veiculos = new LinkedList<Veiculo>();
    }

    public void addVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        return this.veiculos.remove(veiculo);
    }
    
    //gets e sets

    public String getNome() {
        return nome;
    }

    public int getIntervaloNotificacao() {
        return intervaloNotificacao;
    }

    public void setIntervaloNotificacao(int intervalo) {
        this.intervaloNotificacao = intervalo;
    }
}
