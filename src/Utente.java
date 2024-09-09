
public class Utente {

    String nome;
    String cognome;
    String codiceUtente;
    Carta carta;
    double saldo;

    public Utente(String nome, String cognome, String codiceUtente, Carta carta, double saldo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceUtente = codiceUtente;
        this.carta = carta;
        this.saldo = saldo;
    }

    public Utente() {
    }

    public Carta getCarta() {
        return carta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCodiceUtente(String codiceUtente) {
        this.codiceUtente = codiceUtente;
    }

    public String getCodiceUtente() {
        return codiceUtente;
    }

    @Override
    public String toString() {

        return String.format("Nome: %s \nCognome: %s \nSaldo: %s", this.nome, this.cognome, this.saldo);
    }

}
