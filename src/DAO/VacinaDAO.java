package DAO;

import Classes.Animal;
import Classes.Vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connection.Conexao;

public class VacinaDAO {
    private Connection connection;

    public VacinaDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Vacina v){
        String sql = "INSERT INTO vacinas(vacina) VALUES(?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getVacina());
            stmt.execute();
            stmt.close();
            System.out.println("Vacina " + v.getVacina() + " inserida com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Vacina v){
        String sql = "DELETE FROM vacinas WHERE vacina = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getVacina());
            stmt.execute();
            stmt.close();
            System.out.println("Vacina " + v.getVacina() + " deletada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Vacina v){
        String sql = "UPDATE vacinas SET vacina = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getVacina());
            stmt.setInt(2, v.getId());
            System.out.println("teste:" + stmt.toString());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Vacina " + v.getVacina() + "|" + v.getId() + " atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Vacina> show_all(){
        try{
            ArrayList<Vacina> retorno = new ArrayList<Vacina>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM vacinas");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Vacina v = new Vacina(rs.getInt("id"), rs.getString("vacina"));
                retorno.add(v);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Vacina show_filter(String vacina){
        String sql = "SELECT * FROM vacinas WHERE vacina = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, vacina);
            ResultSet rs = stmt.executeQuery();
            Vacina retorno = null;
            if (rs.next()){
                retorno = new Vacina(rs.getInt("id"), rs.getString("vacina"));
//                pessoa.setNome(rs.getString("nome"));
//                pessoa.setIdade(rs.getInt("idade"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Vacina show_by_id(int id){
        String sql = "SELECT * FROM vacinas WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Vacina retorno = null;
            if (rs.next()){
                retorno = new Vacina(rs.getInt("id"), rs.getString("vacina"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
