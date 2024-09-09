
import java.util.Random;

public class Carta {

    String codiceCarta;
    String pin;
    Random random;
    static int progressivo = 0;

    public Carta(String codiceCarta, String pin) {
        this.codiceCarta = codiceCarta;
        this.pin = pin;

    }

    //genera un pin casuale di 4 cifre
    public String GeneraPin() {
        int pinInt = random.nextInt(0, 9999);
        if (0 <= pinInt && 9 >= pinInt) {
            return "000" + pinInt;
        } else if (10 <= pinInt && 99 >= pinInt) {
            return "00" + pinInt;
        } else if (100 <= pinInt && 999 >= pinInt) {
            return "0" + pinInt;
        } else {
            return String.valueOf(pinInt);
        }

    }

    public Carta() {
        this.codiceCarta = GeneraCodiceCarta();
        this.pin = GeneraPin();
    }

    //genera un codice carta progressivo di 4 cifre
    private String GeneraCodiceCarta() {
        progressivo++;
        if (0 <= progressivo && 9 >= progressivo) {
            return "000" + progressivo;
        } else if (10 <= progressivo && 99 >= progressivo) {
            return "00" + progressivo;
        } else if (100 <= progressivo && 999 >= progressivo) {
            return "0" + progressivo;
        } else {
            return String.valueOf(progressivo);
        }
    }

    public String getCodiceCarta() {
        return this.codiceCarta;
    }

    public String getPin() {
        return this.pin;
    }

    public void setCodiceCarta(String codiceCarta) {
        this.codiceCarta = codiceCarta;
    }

    public void setPin(String pin) {
        this.pin = pin;

    }
}
