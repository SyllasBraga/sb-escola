package sb.escola.repositories;

import sb.escola.Configs.DataBaseConfig;
import sb.escola.entities.Aluno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    private DataBaseConfig db;

    public AlunoRepository() {
        this.db = new DataBaseConfig();
    }

    public List<Aluno> getAll(){

        String sql = "select * from aluno";
        List<Aluno> lista = new ArrayList<>();

        try {
            PreparedStatement statement = db.connectDatase().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()){
                Aluno aluno = new Aluno();
                aluno.setMatricula(Long.valueOf(rs.getInt("id")));
                aluno.setNomeCompleto(rs.getString("nome_completo"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setDataMatricula(rs.getDate("data_matricula"));
                aluno.setTurma(null);
                lista.add(aluno);
            }

            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
