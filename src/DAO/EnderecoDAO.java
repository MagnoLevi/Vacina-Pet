package DAO;



import Classes.Endereco;
import Classes.Raca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.Conexao;

public class EnderecoDAO {
    private Connection connection;

    public EnderecoDAO(){
        this.connection = new Conexao().geraConexao();
    }

    public void insert(Endereco es){
        String sql = "INSERT INTO enderecos(rua, numero, bairro, id_cidade) VALUES(?, ?, ?, ?)";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getRua());
            stmt.setString(2, es.getNumero());
            stmt.setString(3, es.getBairro());
            stmt.setInt(4, es.getId_cidade());
            stmt.execute();
            stmt.close();
            System.out.println("Endereço inserido com sucesso");
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void delete(Endereco es){
        String sql = "DELETE FROM enderecos WHERE rua = ? AND numero = ? AND bairro = ? AND id_cidade = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getRua());
            stmt.setString(2, es.getNumero());
            stmt.setString(3, es.getBairro());
            stmt.setInt(4, es.getId_cidade());
            stmt.execute();
            stmt.close();
            System.out.println("Endereço deletado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Endereco es){
        String sql = "UPDATE enderecos SET rua = ?, numero = ?, bairro = ?, id_cidade = ? WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, es.getRua());
            stmt.setString(2, es.getNumero());
            stmt.setString(3, es.getBairro());
            stmt.setInt(4, es.getId_cidade());
            stmt.setInt(5, es.getId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Endereço atualizada com sucesso");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Endereco> show_all(){
        try{
            ArrayList<Endereco> retorno = new ArrayList<Endereco>();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM enderecos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Endereco en = new Endereco(rs.getInt("id"), rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"), rs.getInt("id_cidade"));
                retorno.add(en);
            }

            rs.close();
            stmt.close();
            return retorno;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Endereco show_filter(String rua, String numero, String bairro, int id_cidade){
        String sql = "SELECT * FROM enderecos WHERE rua = ? AND numero = ? AND bairro = ? AND id_cidade = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, rua);
            stmt.setString(2, numero);
            stmt.setString(3, bairro);
            stmt.setInt(4, id_cidade);
            ResultSet rs = stmt.executeQuery();
            Endereco retorno = null;
            if (rs.next()){
                retorno = new Endereco(rs.getInt("id"), rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"), rs.getInt("id_cidade"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Endereco show_by_id(int id){
        String sql = "SELECT * FROM enderecos WHERE id = ?";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Endereco retorno = null;
            if (rs.next()){
                retorno = new Endereco(rs.getInt("id"), rs.getString("rua"), rs.getString("numero"), rs.getString("bairro"), rs.getInt("id_cidade"));
            }
            rs.close();
            stmt.close();
            return retorno;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
