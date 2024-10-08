//Autor Kamil Pajączkowski

public class Kontakt {
    private int id;
    private String imie;
    private String nazwisko;

    public Kontakt(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Imię: " + imie + ", Nazwisko: " + nazwisko;
    }
}
