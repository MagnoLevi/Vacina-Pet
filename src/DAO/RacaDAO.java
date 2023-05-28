package DAO;



import Classes.Animal;
import Classes.Especie;
import Classes.Raca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.Conexao;

public class RacaDAO {
    private Connection connection;

    public RacaDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Raca r){
        String sql = "INSERT INTO racas(raca, id_especie) VALUES(?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, r.getRaca());
            stmt.setInt(2, r.getId_especie());
            stmt.execute();
            stmt.close();
            System.out.println("Raça " + r.getRaca() + " inserida com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Raca r){
        String sql = "DELETE FROM racas WHERE raca = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, r.getRaca());
            stmt.execute();
            stmt.close();
            System.out.println("Raça " + r.getRaca() + " deletada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Raca r){
        String sql = "UPDATE racas SET raca = ?, id_especie = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, r.getRaca());
            stmt.setInt(2, r.getId_especie());
            stmt.setInt(3, r.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Raça " + r.getRaca() + " atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Raca> show_all(){
        try{
            ArrayList<Raca> retorno = new ArrayList<Raca>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM racas ORDER BY raca");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Raca r = new Raca(rs.getInt("id"), rs.getString("raca"), rs.getInt("id_especie"));
                retorno.add(r);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Raca show_filter(String raca){
        String sql = "SELECT * FROM racas WHERE raca = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, raca);
            ResultSet rs = stmt.executeQuery();
            Raca retorno = null;
            if (rs.next()){
                retorno = new Raca(rs.getInt("id"), rs.getString("raca"), rs.getInt("id_especie"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Raca show_by_id(int id){
        String sql = "SELECT * FROM racas WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Raca retorno = null;
            if (rs.next()){
                retorno = new Raca(rs.getInt("id"), rs.getString("raca"), rs.getInt("id_especie"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
