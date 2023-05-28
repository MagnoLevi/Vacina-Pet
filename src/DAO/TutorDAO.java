package DAO;

import Classes.Endereco;
import Classes.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.Conexao;

public class TutorDAO {
    private Connection connection;

    public TutorDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Tutor t){

        if (show_filter(t.getNome()) != null){
            System.out.println("Já existe um usuário com este nome");
            return;
        }

        String sql = "INSERT INTO tutores(nome, email, senha, id_endereco) VALUES(?, ?, ?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getEmail());
            stmt.setString(3, t.getSenha());
            stmt.setInt(4, t.getId_endereco());
            stmt.execute();
            stmt.close();
            System.out.println("Tutor inserido com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Tutor t){
        String sql = "DELETE FROM tutores WHERE nome = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.execute();
            stmt.close();
            System.out.println("Tutor deletado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Tutor t){
        String sql = "UPDATE tutores SET nome = ?, email = ?, senha = ?, id_endereco = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getEmail());
            stmt.setString(3, t.getSenha());
            stmt.setInt(4, t.getId_endereco());
            stmt.setInt(5, t.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Tutor atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Tutor> show_all(){
        try{
            ArrayList<Tutor> retorno = new ArrayList<Tutor>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tutores");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Tutor t = new Tutor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("id_endereco"));
                retorno.add(t);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Tutor show_filter(String nome){
        String sql = "SELECT * FROM tutores WHERE nome = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Tutor retorno = null;
            if (rs.next()){
                retorno = new Tutor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("id_endereco"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Tutor show_by_id(int id){
        String sql = "SELECT * FROM tutores WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Tutor retorno = null;
            if (rs.next()){
                retorno = new Tutor(rs.getInt("id"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("id_endereco"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
