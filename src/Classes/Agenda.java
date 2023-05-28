package Classes;

import java.sql.Date;

public class Agenda {
    protected int id;
    protected java.sql.Date data_vacinacao;
    protected int id_vacina;
    protected int id_animal;

    public Agenda(int id, Date data_vacinacao, int id_vacina, int id_animal) {
        this.id = id;
        this.data_vacinacao = data_vacinacao;
        this.id_vacina = id_vacina;
        this.id_animal = id_animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.sql.Date getData_vacinacao() {
        return data_vacinacao;
    }

    public void setData_vacinacao(java.sql.Date data_vacinacao) {
        this.data_vacinacao = data_vacinacao;
    }

    public int getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(int id_vacina) {
        this.id_vacina = id_vacina;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    @Override
    public String toString() {
        return "Agenda: " +
                "id = " + id +
                ", data vacinacao = " + data_vacinacao +
                ", id_vacina = " + id_vacina +
                ", id_animal = " + id_animal;
    }
}
