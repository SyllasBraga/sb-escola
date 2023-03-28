package sb.escola.repositories;

import sb.escola.configs.DataBaseConfig;
import sb.escola.entities.Professor;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    private DataBaseConfig db;

    public ProfessorRepository(){
        this.db = new DataBaseConfig();
    }

    public List<Professor> getAll(){

        String sql = "select * from professor";
        List<Professor> lista = new ArrayList<>();

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Professor professor = new Professor();

                professor.setMatricula(rs.getLong("id"));
                professor.setNomeCompleto(rs.getString("nome_completo"));
                professor.setGraduacao(rs.getString("graduacao"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setDataMatricula(rs.getDate("data_matricula"));

                lista.add(professor);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Professor getById(Long id){

        String sql = "select * from professor where id=?";
        Professor professor = new Professor();

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setInt(1, id.intValue());
            ResultSet rs = statement.executeQuery();

            while (rs.next()){

                professor.setMatricula(rs.getLong("id"));
                professor.setNomeCompleto(rs.getString("nome_completo"));
                professor.setGraduacao(rs.getString("graduacao"));
                professor.setEndereco(rs.getString("endereco"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setDataMatricula(rs.getDate("data_matricula"));
            }

            return professor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean create(Professor professor){

        String sql = "insert into professor values (default,?,?,?,?,?)";

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, professor.getNomeCompleto());
            statement.setDate(2, new Date(professor.getDataMatricula().getTime()));
            statement.setString(3, professor.getEndereco());
            statement.setDouble(4, professor.getSalario());
            statement.setString(5, professor.getGraduacao());

            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean update(Professor professor){

        String sql = "update professor set nome_completo=?, data_matricula=?, endereco=?, salario=?," +
                "graduacao=? where id=?";

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setString(1, professor.getNomeCompleto());
            statement.setDate(2, new Date(professor.getDataMatricula().getTime()));
            statement.setString(3, professor.getEndereco());
            statement.setDouble(4, professor.getSalario());
            statement.setString(5, professor.getGraduacao());
            statement.setInt(6, professor.getMatricula().intValue());

            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean delete(Professor professor){

        String sql = "delete from professor where id=?";

        try{
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            statement.setInt(1, professor.getMatricula().intValue());

            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
