package Niveau3_persistens;

public class Facade {

    public static void opretPostnr() {
        Mapper.opretPostnr();
    }

    public static void sletPostnr() {
        Mapper.sletPostnr();
    }

    public static void opretBog() {
        Mapper.opretBog();
    }

    public static void sletBog() {
        Mapper.sletBog();
    }

    public static void opretLåner() {
        Mapper.opretLåner();
    }

    public static void sletLåner() {
        Mapper.sletLåner();
    }

    public static void opretUdlån() {
        Mapper.opretUdlån();
    }

    static void sletUdlån() {
        Mapper.sletUdlån();
    }

    static void søgIUdlån() {
        Mapper.søgIUdlån();
    }


}
