package Obj;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Servico implements Serializable {
    String   tipoRevisao;
    Calendar data;
    int      quilometragem;
    String   descricao;

    List<Revisao> revisoesFeitas;

    public Servico(int km, Calendar data) {
        this.data = data;
        this.quilometragem = km;
        this.revisoesFeitas = new LinkedList<Revisao>();
    }

    public void addRevisaoFeita(Revisao revisao){
        revisao.atualiza(this.quilometragem, this.data);
        revisoesFeitas.add(revisao);
    }

    public Object[] toObjectArray(){
        Object[] a = {tipoRevisao, data, quilometragem, descricao};
        return a;
    }

    //gets e sets

    public Calendar getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public List<Revisao> getRevisoesFeitas() {
        return revisoesFeitas;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

}
