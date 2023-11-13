package Obj;
import java.util.Calendar;

public class Veiculo {

    private String   placa;
    private String   modelo;
    private String   tipoCombustivel;
    private int      anoFab;
    private int      anoModelo;
    private int      quilometragem;
    private Calendar ultimaAtualizacao;
    private String   observacao;


    //Construtor
    public Veiculo(){
        this.ultimaAtualizacao = Calendar.getInstance();
    }

    /**
     * Atualiza a km do veiculo e a data da ultima atualização.
     * Retorna IllegalArgumentException caso km seja menor que a quilometragem atual.
     */
    public void addKm(int km){
        if(km < this.quilometragem){
            throw new IllegalArgumentException();
        }else{
            this.quilometragem = km;
            this.ultimaAtualizacao = Calendar.getInstance();
        }
    }

    //Get e set
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

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public Calendar getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }
}
