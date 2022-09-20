package Niveau3_persistens;

import Niveau2_logik.TerminalIO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mapper {

    static void opretPostnr() {

        String sql = "INSERT INTO Postnr (Postnr, `By`) VALUES (?, ?);";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            ps.setInt(1, TerminalIO.getInt("Indtast postnummeret: "));
            ps.setString(2, TerminalIO.getString("Indtast byens navn: "));

            ps.executeUpdate();

            System.out.println("Du har nu oprettet en ny by");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sletPostnr() {

        // der mangler en try / catch der giver en besked,
        // hvis en låner er registret med postnummeret og derfor ikke kan slettes

        String sql = "delete from Postnr where Postnr = ?";

        try (Connection con = ConnectionConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            int postNr = TerminalIO.getInt("Skriv postnummeret du vil slette: ");

            ps.setInt(1, postNr);


            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println("Postnummeret er nu slettet");

            } else {

                System.out.println("Der findes ikke et postnummer med tallene: " + "\"" + postNr);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

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

        // der mangler en try / catch der giver en besked,
        // hvis bogen er udlånt og derfor ikke kan slettes

        String sql = "delete from Bogtabel where Titel = ?";

        try (Connection con = ConnectionConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String titel = TerminalIO.getString("Skriv navnet på den bog du vil slette: ");

            ps.setString(1, titel);


            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println("Bogen " + "\"" + titel + "\"" + " er nu slettet");

            } else {

                System.out.println("Der findes ikke en bog med titlen: " + "\"" + titel);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


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

        // der mangler en try / catch der giver en besked,
        // hvis låneren stadig har aktive udlån og derfor ikke kan slettes

        String sql = "delete from Lånertabel where Navn = ?";

        try (Connection con = ConnectionConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String lånerNavn = TerminalIO.getString("Skriv navnet på den låner du vil slette: ");

            ps.setString(1, lånerNavn);


            int res = ps.executeUpdate();

            if (res > 0) {

                System.out.println(lånerNavn + " er nu slettet som låner");

            } else {

                System.out.println("Der findes ikke en låner med navnet: " + "\"" + lånerNavn);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

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
        System.out.println("Jeg er en tom metode, husk at bygge mig :)");
    }

    static void søgIUdlån() {
        System.out.println("Jeg er en tom metode, husk at bygge mig :)");
    }

}
