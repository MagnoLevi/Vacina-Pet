package Classes;

public class Animal {
    protected int id;
    protected String nome;
    protected int ano_nascimento;
    protected Double peso;
    protected int id_raca;
    protected int id_tutor;

    public Animal(int id, String nome, int ano_nascimento, Double peso, int id_raca, int id_tutor) {
        this.id = id;
        this.nome = nome;
        this.ano_nascimento = ano_nascimento;
        this.peso = peso;
        this.id_raca = id_raca;
        this.id_tutor = id_tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public int getId_raca() {
        return id_raca;
    }

    public void setId_raca(int id_raca) {
        this.id_raca = id_raca;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    @Override
    public String toString() {
        return "Animal: " +
                "id = " + id +
                ", nome = " + nome +
                ", ano nascimento = " + ano_nascimento +
                ", peso = " + peso +
                ", id_raca = " + id_raca +
                ", id_tutor = " + id_tutor;
    }
}
