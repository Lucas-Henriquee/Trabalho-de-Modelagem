package Obj;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Veiculo implements Serializable {

    private String   placa;
    private String   modelo;
    private String   tipoCombustivel;
    private int      anoFab;
    private int      anoModelo;
    private int      quilometragem;
    private Calendar ultimaAtualizacao;
    private String   observacao;

    private List<Revisao>  revisoes;
    private List<Servico>  servicos;


    //Construtor
    public Veiculo() {
        this.placa = "";
        this.modelo = "";
        this.tipoCombustivel = "";
        this.quilometragem = 0;
        this.anoFab = 0;
        this.anoModelo = 0;
        this.ultimaAtualizacao = Calendar.getInstance();
        this.observacao = "";

        this.revisoes = new LinkedList<Revisao>();
        this.servicos = new LinkedList<Servico>();
    }

    /**
     * Atualiza a km do veiculo e a data da ultima atualização.
     * Retorna IllegalArgumentException caso km seja menor que a quilometragem atual.
     */
    public void attKm(int km) {
        if(km < this.quilometragem){
            throw new IllegalArgumentException();
        }else{
            this.quilometragem = km;
            this.ultimaAtualizacao = Calendar.getInstance();
        }
    }

    public void addRevisao(Revisao revisao) {
        this.revisoes.add(revisao);
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public boolean removeRevisao(Revisao revisao) {
        return revisoes.remove(revisao);
    }

    public boolean removeServico(Servico servico) {
        return servicos.remove(servico);
    }

    //Gets e sets
    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public List<Revisao> getRevisoes() {
        return this.revisoes;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public int getAnoModelo() {
        return anoModelo;
    }
    public String getModelo() {
        return modelo;
    }
    public String getObservacao() {
        return observacao;
    }
    
    public String getPlaca() {
        return placa;
    }

    public int getKm() {
        return quilometragem;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public Calendar getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    @Override
    public String toString() {
        String str = "";

        str += "Modelo: " + this.modelo;
        str += "\nPlaca: " + this.placa;
        str += "\nAno de Fabricação: " + this.anoFab;
        str += "\nAno do modelo: " + this.anoModelo;
        str += "\nTipo de combustivel: " + this.tipoCombustivel;
        str += "\n ------ Revisões ------ \n";

        for(int i = 0; i < this.revisoes.size(); i++){
            str += this.revisoes.get(i).toString();
            str += "\n------------------";
        }

        return str;
    }
}
