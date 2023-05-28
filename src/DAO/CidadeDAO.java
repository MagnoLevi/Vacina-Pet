package DAO;

import Classes.Cidade;
import Classes.Especie;
import Connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CidadeDAO {
    private Connection connection;

    public CidadeDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Cidade c){
        String sql = "INSERT INTO cidades(cidade, estado) VALUES(?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getCidade());
            stmt.setString(2, c.getEstado());
            stmt.execute();
            stmt.close();
            System.out.println("Cidade " + c.getCidade() + " inserida com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Cidade c){
        String sql = "DELETE FROM cidades WHERE cidade = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getCidade());
            stmt.execute();
            stmt.close();
            System.out.println("Especie " + c.getCidade() + " deletada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Cidade c){
        String sql = "UPDATE cidades SET cidade = ?, estado = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getCidade());
            stmt.setString(2, c.getEstado());
            stmt.setInt(3, c.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Especie " + c.getCidade() + " atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cidade> show_all(){
        try{
            ArrayList<Cidade> retorno = new ArrayList<Cidade>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cidades");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Cidade c = new Cidade(rs.getInt("id"), rs.getString("cidade"), rs.getString("estado"));
                retorno.add(c);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Cidade show_filter(String cidade){
        String sql = "SELECT * FROM cidades WHERE cidade = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cidade);
            ResultSet rs = stmt.executeQuery();
            Cidade retorno = null;
            if (rs.next()){
                retorno = new Cidade(rs.getInt("id"), rs.getString("cidade"), rs.getString("estado"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
