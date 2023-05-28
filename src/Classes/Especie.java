package Classes;

public class Especie {
    protected int id;
    protected String especie;

    public Especie(int id, String especie) {
        this.id = id;
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Especie: " +
                "especie = " + especie;
    }
}
