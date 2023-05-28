package Classes;

public class Vacina {
    protected int id;
    protected String vacina;

    public Vacina(int id,String vacina) {
        this.id = id;
        this.vacina = vacina;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vacina:" +
                "vacina = " + vacina;
    }
}
