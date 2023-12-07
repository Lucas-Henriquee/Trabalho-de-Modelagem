package Obj;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Veiculo implements Serializable {

    private String   placa;
    private String   modelo;
    private int      anoModelo;
    private int      quilometragem;
    private Calendar ultimaAtualizacao;
    private String   observacao;

    private List<Revisao>  revisoes;
    private List<Servico>  servicos;


    //Construtor
    public Veiculo(Cliente cliente, String placa, String modelo, int anoModelo, int quilometragem, String observacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.quilometragem = quilometragem;
        this.anoModelo = anoModelo;
        this.ultimaAtualizacao = null;
        this.observacao = observacao;

        this.revisoes = new LinkedList<Revisao>();
        this.servicos = new LinkedList<Servico>();
        cliente.addVeiculo(this);
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
        }
    }

    public void addAtualizacao(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();     
        try {
            c.setTime(sdf.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void addRevisao(Revisao revisao) {
        this.revisoes.add(revisao);
    }

    public void addServico(Servico servico) {
        this.servicos.add(servico);
    }

    public void save_in_db(){

    }

    public boolean removeRevisao(Revisao revisao) {
        return revisoes.remove(revisao);
    }

    public boolean removeServico(Servico servico) {
        return servicos.remove(servico);
    }

    public Object[] toObjectArray(){
        Object[] a = {modelo};
        return a;
    }

    //Gets e sets

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

    public List<Revisao> getRevisoes() {
        return this.revisoes;
    }

    public List<Servico> getServicos() {
        return this.servicos;
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

    public Calendar getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    @Override
    public String toString() {
        String str = "";

        str += "Modelo: " + this.modelo;
        str += "\nPlaca: " + this.placa;
        str += "\nAno do modelo: " + this.anoModelo;
        str += "\n ------ Revisões ------ \n";

        for(int i = 0; i < this.revisoes.size(); i++){
            str += this.revisoes.get(i).toString();
            str += "\n------------------";
        }

        return str;
    }
}
