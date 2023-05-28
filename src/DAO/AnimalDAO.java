package DAO;

import Classes.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Tutor;
import Connection.Conexao;

public class AnimalDAO {
    private Connection connection;

    public AnimalDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Animal animal){
        String sql = "INSERT INTO animais(nome, ano_nascimento, peso, id_raca, id_tutor) VALUES(?, ?, ?, ?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getAno_nascimento());
            stmt.setDouble(3, animal.getPeso());
            stmt.setInt(4, animal.getId_raca());
            stmt.setInt(5, animal.getId_tutor());
            stmt.execute();
            stmt.close();
            System.out.println("Registro inserido com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Animal animal){
        String sql = "DELETE FROM animais WHERE nome = ? AND id_tutor = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getId_tutor());
            stmt.execute();
            stmt.close();
            System.out.println("Registro deletado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Animal animal){
        String sql = "UPDATE animais SET nome = ?, ano_nascimento = ?, peso = ?, id_raca = ?, id_tutor = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getAno_nascimento());
            stmt.setDouble(3, animal.getPeso());
            stmt.setInt(4, animal.getId_raca());
            stmt.setInt(5, animal.getId_tutor());
            stmt.setInt(6, animal.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Animal> show_all(){
        try{
            ArrayList<Animal> retorno = new ArrayList<Animal>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM animais");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Animal animal = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nascimento"), rs.getDouble("peso"), rs.getInt("id_raca"), rs.getInt("id_tutor"));
                retorno.add(animal);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Animal show_filter(String nome, int id_tutor){
        String sql = "SELECT * FROM animais WHERE nome = ? AND id_tutor = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, id_tutor);
            ResultSet rs = stmt.executeQuery();
            Animal retorno = null;
            if (rs.next()){
                retorno = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nascimento"), rs.getDouble("peso"), rs.getInt("id_raca"), rs.getInt("id_tutor"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Animal show_by_id(int id){
        String sql = "SELECT * FROM animais WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Animal retorno = null;
            if (rs.next()){
                retorno = new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nascimento"), rs.getDouble("peso"), rs.getInt("id_raca"), rs.getInt("id_tutor"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
