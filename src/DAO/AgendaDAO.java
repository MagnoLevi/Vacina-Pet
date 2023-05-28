package DAO;

import Classes.Agenda;
import Classes.Animal;
import Connection.Conexao;

import java.sql.*;
import java.util.ArrayList;


public class AgendaDAO {

    private Connection connection;

    public AgendaDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Agenda agenda){

        String sql = "INSERT INTO agenda(data_vacinacao, id_vacina, id_animal) VALUES(?, ?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, agenda.getData_vacinacao());
            stmt.setInt(2, agenda.getId_vacina());
            stmt.setInt(3, agenda.getId_animal());
            stmt.execute();
            stmt.close();
            System.out.println("Registro inserido com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Agenda agenda){
        String sql = "DELETE FROM agenda WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, agenda.getId());
            stmt.execute();
            stmt.close();
            System.out.println("Registro deletado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Agenda agenda){
        String sql = "UPDATE agenda SET data_vacinacao = ?, id_vacina = ?, id_animal = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDate(1, agenda.getData_vacinacao());
            stmt.setInt(2, agenda.getId_vacina());
            stmt.setInt(3, agenda.getId_animal());
            stmt.setInt(4, agenda.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Agenda> show_all(){
        try{
            ArrayList<Agenda> retorno = new ArrayList<Agenda>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM agenda");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Agenda agenda = new Agenda(rs.getInt("id"), rs.getDate("data_vacinacao"), rs.getInt("id_vacina"), rs.getInt("id_animal"));
                retorno.add(agenda);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Agenda> show_filter(int id_tutor){
        String sql = "SELECT " +
                "agenda.id," +
                "agenda.data_vacinacao," +
                "agenda.id_vacina," +
                "agenda.id_animal" +
                " FROM agenda " +
                "LEFT JOIN animais ON animais.id = agenda.id_animal " +
                "WHERE animais.id_tutor = ?" +
                " ORDER BY agenda.data_vacinacao";

        try{
            ArrayList<Agenda> retorno = new ArrayList<Agenda>();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_tutor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Agenda agenda = new Agenda(rs.getInt("id"), rs.getDate("data_vacinacao"), rs.getInt("id_vacina"), rs.getInt("id_animal"));
                retorno.add(agenda);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Agenda show_by_id(int id){
        String sql = "SELECT * FROM agenda WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Agenda retorno = null;

            if (rs.next()){
                retorno = new Agenda(rs.getInt("id"), rs.getDate("data_vacinacao"), rs.getInt("id_vacina"), rs.getInt("id_animal"));
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
