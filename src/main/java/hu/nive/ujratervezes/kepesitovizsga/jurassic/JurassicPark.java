package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {

    private DataSource dataSource;

    public JurassicPark(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<String> checkOverpopulation() {
        List<String> dinoNames = new ArrayList();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT breed FROM dinosaur WHERE actual > expected ORDER BY breed ASC")) {
            return getDinoNamesByPreparedStatement(ps);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }

    }

    private List<String> getDinoNamesByPreparedStatement(PreparedStatement ps) throws SQLException {
        List<String> dinoNames = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String dinoName = rs.getString("breed");
                dinoNames.add(dinoName);
            }
            return dinoNames;
        }
    }


}
