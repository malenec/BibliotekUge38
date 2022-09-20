import Niveau2_logik.TerminalIO;
import Niveau3_persistens.Facade;

public class Main {

    public static void main(String[] args) {

        int svar;

        while (true) {

            svar = TerminalIO.getInt("Hvad ønsker du? \n" +
                    "  1. Vil du oprette en ny låner tast 1 \n" +
                    "  2. Vil du oprette en ny bog tast 2 \n" +
                    "  3. Vil du låne en bog tast 3");

            switch (svar) {

                case 1:
                    Facade.opretLåner();
                    break;
                case 2:
                    Facade.opretBog();
                    break;
                case 3:
                    Facade.opretUdlån();
                    break;
                default:
                    System.out.println("Du valgte ikke en af de givne muligheder, prøv igen");
            }
        }
    }

}
