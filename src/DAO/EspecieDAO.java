package DAO;

import Classes.Especie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Vacina;
import Connection.Conexao;

public class EspecieDAO {
    private Connection connection;

    public EspecieDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Especie es){
        String sql = "INSERT INTO especies(especie) VALUES(?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getEspecie());
            stmt.execute();
            stmt.close();
            System.out.println("Especie " + es.getEspecie() + " inserida com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Especie es){
        String sql = "DELETE FROM especies WHERE especie = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getEspecie());
            stmt.execute();
            stmt.close();
            System.out.println("Especie " + es.getEspecie() + " deletada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Especie es){
        String sql = "UPDATE especies SET especie = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getEspecie());
            stmt.setInt(2, es.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Especie " + es.getEspecie() + " atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Especie> show_all(){
        try{
            ArrayList<Especie> retorno = new ArrayList<Especie>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM especies ORDER BY especie");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Especie e = new Especie(rs.getInt("id"), rs.getString("especie"));
                retorno.add(e);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Especie show_filter(String especie){
        String sql = "SELECT * FROM especies WHERE especie = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, especie);
            ResultSet rs = stmt.executeQuery();
            Especie retorno = null;
            if (rs.next()){
                retorno = new Especie(rs.getInt("id"), rs.getString("especie"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
