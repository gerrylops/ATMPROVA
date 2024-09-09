
public class SaldoNonSufficienteException extends Exception {

    public SaldoNonSufficienteException(double saldo) {
        super(String.format("Il tuo saldo di %s euro non è sufficiente per effettuare questo prelievo.", saldo));
    }
}
