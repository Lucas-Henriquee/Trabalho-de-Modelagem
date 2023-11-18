package Obj;

import java.io.Serializable;
import java.util.Calendar;

public class Revisao implements Serializable {
    
    private int intervaloMeses;    
    private int intervaloKm;

    private Calendar dataUltimaRevisao;
    private int      kmUltimaRevisao;

    private String descricao;

    public Revisao(int intervaloKm, int intevaloMeses) {
        this.intervaloKm = intervaloKm;
        this.intervaloMeses = intevaloMeses;
        this.dataUltimaRevisao = Calendar.getInstance();
        this.kmUltimaRevisao = 0;
        this.descricao = "";
    }

    /**
     * Atualiza a km e a data da utlima revisao feita.
     * Retorna IllegalArgumentException caso km seja menor que a quilometragem atual.
     * @param km - Quilometragem em que foi feita a revisão.
     */
    public void atualiza(int km, Calendar data) {
        if(this.kmUltimaRevisao < km){
            this.kmUltimaRevisao = km;
            this.dataUltimaRevisao = data;
        }
    }
    /**
     * Ferifica se a revisão está pendente ou não.
     * @param km - Quilometragem atual do veículo.
     * @return true caso esteja pendente.
     */
    public boolean pendente(int km) {
        if((km - kmUltimaRevisao) > intervaloKm) {
            return true;
        }

        if(Revisao.calcDiffMeses(dataUltimaRevisao, Calendar.getInstance()) > intervaloMeses) {
            return true;
        }
        
        return false;
    }

    /**
     * Calcula a diferença em meses de duas datas (data_2 - data_1).
     * @param data_1 - Calendar
     * @param data_2 - Calendar
     * @return Diferença em meses.
     */
    public static int calcDiffMeses(Calendar data_1, Calendar data_2){
        int mes = data_1.get(Calendar.MONTH);
        int ano = data_1.get(Calendar.YEAR);
        int mesAtual = data_2.get(Calendar.MONTH);
        int anoAtual = data_2.get(Calendar.YEAR);

        int diffDias = data_2.get(Calendar.DAY_OF_MONTH) - data_1.get(Calendar.DAY_OF_MONTH);
        int diffMeses = (mesAtual + (12 *(anoAtual - ano))) - mes;

        if(diffDias < 0){
            diffMeses = diffMeses - 1;
        }

        return diffMeses;
    }
    
    //gets e sets    
    public int getIntervaloMeses() {
        return intervaloMeses;
    }

    public int getIntervaloKm() {
        return intervaloKm;
    }
    
    public Calendar getDataUltimaRevisao() {
        return dataUltimaRevisao;
    }

    public int getKmUltimaRevisao() {
        return kmUltimaRevisao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setIntervaloKm(int intervaloKm) {
        this.intervaloKm = intervaloKm;
    }

    public void setIntervaloMeses(int intervaloMeses) {
        this.intervaloMeses = intervaloMeses;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        String str = "";

        str += "Descrição: " + this.descricao;
        str += "\nIntervalo em Km: " + this.intervaloKm;
        str += "\nIntervalo em em meses: " + this.intervaloMeses;

        return str;
    }
}
