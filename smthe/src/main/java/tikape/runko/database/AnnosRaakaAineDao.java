/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.AnnosRaakaAine;

public class AnnosRaakaAineDao implements Dao<AnnosRaakaAine, Integer> {

    private Database database;

    public AnnosRaakaAineDao(Database database) {
        this.database = database;
    }

    @Override
    public AnnosRaakaAine findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM RaakaAine WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer raakaaine_id = rs.getInt("raakaaine_id");
        Integer annos_id = rs.getInt("annos_id");
        String jarjestys = rs.getString("jarjestys");
        String maara = rs.getString("maara");
        String ohje = rs.getString("ohje");

        AnnosRaakaAine o = new AnnosRaakaAine(raakaaine_id, annos_id, jarjestys, maara, ohje);

        rs.close();
        stmt.close();
        connection.close();

        return o;
    }

    @Override
    public List<AnnosRaakaAine> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM AnnosRaakaAine");

        ResultSet rs = stmt.executeQuery();
        List<AnnosRaakaAine> annosraakaaine = new ArrayList<>();
        while (rs.next()) {
            Integer raakaaine_id = rs.getInt("raakaaine_id");
            Integer annos_id = rs.getInt("annos_id");
            String jarjestys = rs.getString("jarjestys");
            String maara = rs.getString("maara");
            String ohje = rs.getString("ohje");

            annosraakaaine.add(new AnnosRaakaAine(raakaaine_id,annos_id, jarjestys,maara,ohje));
        }

        rs.close();
        stmt.close();
        connection.close();

        return annosraakaaine;
    }

    public void insert(AnnosRaakaAine a) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO AnnosRaakaAine VALUES (?,?,?,?,?);");
        stmt.setObject(1, a.getRaakaaine_Id());
        stmt.setObject(1, a.getAnnos_Id());
        stmt.setObject(2, a.getJarjestys());
        stmt.setObject(2, a.getMaara());
        stmt.setObject(2, a.getOhje());
        stmt.executeUpdate();        
        stmt.close();
        connection.close();
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }

}
