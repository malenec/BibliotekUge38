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

        String sql = "INSERT INTO Bogtabel (Forfatternavn, Titel, Udgivelsesår) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setString(1, TerminalIO.getString("Indtast forfatterens navn: "));
            ps.setString(2, TerminalIO.getString("Indtast bogens titel: "));
            ps.setInt(3, TerminalIO.getInt("Indtast bogens udgivelsesår: "));

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);

            System.out.println("Du har nu oprettet en ny bog, bogens ID er nummer " + id);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            ps.setInt(3, TerminalIO.getInt("Indtast dit postnr: "));

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

        String sql = "INSERT INTO Udlånstabel (BogID, LånerID) VALUES (?, ?)";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setInt(1, TerminalIO.getInt("Indtast bogens ID nummer: "));
            ps.setInt(2, TerminalIO.getInt("Indtast dit lånernummer: "));

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);

            System.out.println("Du har nu lånt bogen, god læselyst");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static void sletUdlån() {

    }

    static void søgIUdlån() {

    }

}
