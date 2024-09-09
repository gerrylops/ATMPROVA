
import java.util.ArrayList;
import java.util.List;

public class Atm {

    Utente utenteLoggato = null;
    List<Utente> listaUtenti = new ArrayList<>();

    //crea una lista di utenti di prova, per usare il programma
    public Atm() {
        setListaUtenti(new ArrayList<Utente>() {
            {
                add(new Utente("Aldo", "Piccolomo", "a.piccolomo", new Carta("001", "1234"), 1254.04));
                add(new Utente("Gerry", "Lops", "g.lops", new Carta("002", "0000"), 15402.95));
                add(new Utente("Pio", "Lupo", "p.lupo", new Carta("003", "1240"), 12.70));
            }
        });
    }

    public void setListaUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    public void setUtenteLoggato(Utente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    //verifica le credenziali di accesso
    public void LogIn(Carta carta) {
        try {
            for (Utente utente : listaUtenti) {
                if (carta.codiceCarta.equals(utente.carta.codiceCarta) && carta.pin.equals(utente.carta.pin)) {
                    utenteLoggato = utente;
                    System.out.println("Hai loggato il seguente utente: \n" + utenteLoggato);
                    break;
                }
            }
            if (utenteLoggato == null) {
                throw new CartaNonTrovataException();
            }
        } catch (CartaNonTrovataException exception) {
            System.out.println(exception.getMessage());
        }

    }

    //effettua il deposito
    public void Deposito(int soldi) {
        utenteLoggato.saldo += soldi;
        System.out.println("Il saldo attuale è " + utenteLoggato.saldo);
    }

    //effettua un prelievo
    public void Prelievo(int soldi) throws SaldoNonSufficienteException {
        if (utenteLoggato.saldo >= soldi) {
            utenteLoggato.saldo -= soldi;
            System.out.println("Il saldo attuale è " + utenteLoggato.saldo);
        } else {
            throw new SaldoNonSufficienteException(utenteLoggato.saldo);
        }
    }

    //effettua il logout
    public void LogOut() {
        utenteLoggato = null;
    }
}
