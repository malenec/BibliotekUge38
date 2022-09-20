package Niveau2_logik;

// jeg er i tvivl om denne klasse skal bo i dette niveau, måske skal den rykkes.. :)

import Niveau3_persistens.Facade;

public class Bibliotek {

    public static void menu() {

        int svar;

        while (true) {

            svar = TerminalIO.getInt("Hvad ønsker du? \n" +
                    "  1. Vil du oprette et nyt postnummer tast 1 \n" +
                    "  2. Vil du slette et postnummer tast 2 \n" +
                    "  3. Vil du oprette en ny bog tast 3 \n" +
                    "  4. Vil du slette en bog tast 4 \n" +
                    "  5. Vil du oprette en ny låner tast 5 \n" +
                    "  6. Vil du slette en låner tast 6 \n" +
                    "  7. Vil du låne en bog tast 7 \n" +
                    "  8. Vil du aflevere en bog tast 8 \n" +
                    "  9. Vil du søge i udlånstabellen tast 9 \n ");

            switch (svar) {

                case 1:
                    Facade.opretPostnr();
                    break;
                case 2:
                    Facade.sletPostnr();
                    break;
                case 3:
                    Facade.opretBog();
                    break;
                case 4:
                    Facade.sletBog();
                    break;
                case 5:
                    Facade.opretLåner();
                    break;
                case 6:
                    Facade.sletLåner();
                    break;
                case 7:
                    Facade.opretUdlån();
                    break;
                case 8:
                    Facade.sletUdlån();
                    break;
                case 9:
                    Facade.søgIUdlån();
                    break;
                default:
                    System.out.println("Du valgte ikke en af de givne muligheder, prøv igen");
            }
        }
    }
}



