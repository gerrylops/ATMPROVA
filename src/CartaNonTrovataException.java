
class CartaNonTrovataException extends Exception {

    public CartaNonTrovataException() {
        super("Carta non trovata. Inserire un numero di carta valido e un pin esistente");
    }
}
