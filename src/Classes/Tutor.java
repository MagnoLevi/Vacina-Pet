package Classes;

public class Tutor {
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;
    protected int id_endereco;

    public Tutor(int id, String nome, String email, String senha, int id_endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id_endereco = id_endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    @Override
    public String toString() {
        return "Tutor: " +
                "id = " + id +
                ", nome = " + nome +
                ", email = " + email +
                ", senha = " + senha +
                ", id_endereco = " + id_endereco;
    }
}
