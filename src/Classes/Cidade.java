package Classes;

public class Cidade {
    protected int id;
    protected String cidade;
    protected String estado;

    public Cidade(int id, String cidade, String estado) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cidade: " +
                "id = " + id +
                ", cidade = '" + cidade +
                ", estado = '" + estado;
    }
}
