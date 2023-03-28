package sb.escola.repositories;

import sb.escola.configs.DataBaseConfig;
import sb.escola.entities.Professor;

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
}
