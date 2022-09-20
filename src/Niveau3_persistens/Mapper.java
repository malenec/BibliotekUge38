package Niveau3_persistens;

import Niveau2_logik.TerminalIO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mapper {

    static void opretPostnr() {

    }

    static void sletPostnr() {

    }

    static void opretBog() {

    }

    static void sletBog() {

    }

    static void opretLåner() {

        String sql = "INSERT INTO Lånertabel (Navn, Adresse, Postnr) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setString(1, TerminalIO.getString("Indtast dit navn: "));
            ps.setString(2, TerminalIO.getString("Indtast din adresse: "));
            ps.setString(3, TerminalIO.getString("Indtast dit postnr: "));

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);

            System.out.println("Du har nu oprettet dig som låner, dit lånernummer er " + id);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void sletLåner() {

    }

    static void opretUdlån() {

    }


    static void sletUdlån() {

    }

    static void søgIUdlån() {

    }

}
