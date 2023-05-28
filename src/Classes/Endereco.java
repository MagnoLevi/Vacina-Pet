package Classes;

public class Endereco {
    protected int id;
    protected String rua;
    protected String numero;
    protected String bairro;
    protected int id_cidade;

    public Endereco(int id, String rua, String numero, String bairro, int id_cidade) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.id_cidade = id_cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    @Override
    public String toString() {
        return "Enderecos: " +
                "id=" + id +
                ", rua = " + rua +
                ", numero = " + numero +
                ", bairro = " + bairro +
                ", id_cidade = " + id_cidade;
    }
}
