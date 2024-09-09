
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    static Atm atm = new Atm();

    public static void main(String[] args) throws Exception {
        System.out.println("INIZIO PROGRAMMA!");

        String risposta;

        //permette di effettuare il login se la scelta è del metodo LogInOrClose è 1
        do {
            risposta = LogInOrClose();
            if ("1".equals(risposta)) {
                do {
                    EffettuaLogIn();
                } while (atm.utenteLoggato == null);
                StampaHome();
            }
        } while (!"2".equals(risposta));

    }

    //effettua materialmente il login
    private static void EffettuaLogIn() {
        System.out.println("Inserisci codice carta");
        String codiceCarta = scanner.next();
        System.out.println("Inserisci il pin");
        String pin = scanner.next();
        atm.LogIn(new Carta(codiceCarta, pin));

    }

    //stampa un menu che permette all'utente di effettuare delle operazioni
    private static void StampaHome() {
        String risposta = "0";
        while (!"3".equals(risposta)) {
            do {
                try {
                    System.out.println("Scegli una tra le seguenti opzioni:\n1 - Deposito\n2 - Prelievo\n3 - Logout");
                    risposta = scanner.next();
                    if (!"1".equals(risposta) && !"2".equals(risposta) && !"3".equals(risposta)) {
                        throw new SceltaNonValidaException();
                    }
                } catch (SceltaNonValidaException e) {
                    System.err.println(e.getMessage());
                    risposta = "0";
                }
            } while ("0".equals(risposta));

            switch (risposta) {
                case "1" -> {
                    System.out.println("Inserisci ammontare da depositare");
                    int deposito = scanner.nextInt();
                    atm.Deposito(deposito);
                }

                case "2" -> {
                    System.out.println("Inserisci ammontare da prelevare");
                    int prelievo = scanner.nextInt();
                    try {
                        atm.Prelievo(prelievo);
                    } catch (SaldoNonSufficienteException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "3" -> {
                    atm.LogOut();
                }

            }
        }
    }

    //check sull'input della scelta tra login o chiudere
    private static String LogInOrClose() {
        String risposta = "";
        do {
            try {
                System.out.println("Premere 1 per effettuare il login.\nPremere 2 per chiudere.");
                risposta = scanner.next();
                if (!"1".equals(risposta) && !"2".equals(risposta)) {
                    throw new SceltaNonValidaException();
                }
            } catch (SceltaNonValidaException e) {
                System.err.println(e.getMessage());
                risposta = "";
            }
        } while ("".equals(risposta));
        return risposta;
    }
}
