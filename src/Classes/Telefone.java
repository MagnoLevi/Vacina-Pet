package Classes;

public class Telefone {
    protected int id;
    protected String telefone;
    protected int id_tutor;

    public Telefone(int id, String telefone, int id_tutor) {
        this.id = id;
        this.telefone = telefone;
        this.id_tutor = id_tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    @Override
    public String toString() {
        return "Telefone: " +
                "id = " + id +
                ", telefone = " + telefone +
                ", id_tutor = " + id_tutor;
    }
}
