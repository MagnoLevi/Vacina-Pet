package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection geraConexao(){
        Connection conexao = null;

        try{
            String url = "jdbc:mysql://localhost/vacina_pet";
            String usuario = "seu user aqui";
            String senha = "sua senha aqui";
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso\n");
        } catch (SQLException e){
            System.out.println("Ocorreu um erro ao tentar conectar: " + e.getMessage() + "\n");
            conexao = null;
        }

        return conexao;
    }
}
