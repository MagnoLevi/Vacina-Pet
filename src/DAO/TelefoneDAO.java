package DAO;

import Classes.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classes.Tutor;
import Connection.Conexao;
public class TelefoneDAO {

    private Connection connection;

    public TelefoneDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Telefone t){

        if (show_filter(t.getTelefone()) != null){
            System.out.println("Não foi possível inserir este telefone");
            return;
        }

        String sql = "INSERT INTO telefones(telefone, id_tutor) VALUES(?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getTelefone());
            stmt.setInt(2, t.getId_tutor());
            stmt.execute();
            stmt.close();
            System.out.println("Registro inserido com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Telefone t){
        String sql = "DELETE FROM telefones WHERE telefone = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getTelefone());
            stmt.execute();
            stmt.close();
            System.out.println("Registro deletado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Telefone t){
        String sql = "UPDATE telefones SET telefone = ?, id_tutor = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, t.getTelefone());
            stmt.setInt(2, t.getId_tutor());
            stmt.setInt(3, t.getId());

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Registro atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Telefone> show_all(){
        try{
            ArrayList<Telefone> retorno = new ArrayList<Telefone>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM telefones");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Telefone t = new Telefone(rs.getInt("id"), rs.getString("telefone"), rs.getInt("id_tutor"));
                retorno.add(t);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Telefone show_filter(String telefone){
        String sql = "SELECT * FROM telefones WHERE telefone = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, telefone);
            ResultSet rs = stmt.executeQuery();
            Telefone retorno = null;
            if (rs.next()){
                retorno = new Telefone(rs.getInt("id"), rs.getString("telefone"), rs.getInt("id_tutor"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
