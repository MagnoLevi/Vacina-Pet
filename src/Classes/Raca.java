package Classes;

public class Raca {
    protected int id;
    protected String raca;
    protected int id_especie;

    public Raca(int id, String raca, int id_especie) {
        this.id = id;
        this.raca = raca;
        this.id_especie = id_especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getId_especie() {
        return id_especie;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Raca: " +
                "raca=" + raca +
                ", id_especie=" + id_especie;
    }
}
