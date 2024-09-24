
//Autor Kamil Pajączkowski
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplikacjaCRUD {
    private static List<Kontakt> kontakty = new ArrayList<>();
    private static int idCounter = 1; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj kontakt");
            System.out.println("2. Wyświetl kontakty");
            System.out.println("3. Edytuj kontakt");
            System.out.println("4. Usuń kontakt");
            System.out.println("0. Wyjdź");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();
            scanner.nextLine(); 

            switch (wybor) {
                case 1:
                    dodajKontakt(scanner);
                    break;
                case 2:
                    wyswietlKontakty();
                    break;
                case 3:
                    edytujKontakt(scanner);
                    break;
                case 4:
                    usunKontakt(scanner);
                    break;
                case 0:
                    System.out.println("Zamykam aplikację.");
                    break;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie.");
            }
        } while (wybor != 0);

        scanner.close();
    }

    private static void dodajKontakt(Scanner scanner) {
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();
        kontakty.add(new Kontakt(idCounter++, imie, nazwisko));
        System.out.println("Kontakt dodany!");
    }

    private static void wyswietlKontakty() {
        if (kontakty.isEmpty()) {
            System.out.println("Brak kontaktów.");
            return;
        }
        System.out.println("Lista kontaktów:");
        for (Kontakt kontakt : kontakty) {
            System.out.println(kontakt);
        }
    }

    private static void edytujKontakt(Scanner scanner) {
        System.out.print("Podaj ID kontaktu do edycji: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Opróżnia bufor

        for (Kontakt kontakt : kontakty) {
            if (kontakt.getId() == id) {
                System.out.print("Podaj nowe imię (aktualne: " + kontakt.getImie() + "): ");
                String noweImie = scanner.nextLine();
                System.out.print("Podaj nowe nazwisko (aktualne: " + kontakt.getNazwisko() + "): ");
                String noweNazwisko = scanner.nextLine();

                kontakty.set(kontakty.indexOf(kontakt), new Kontakt(id, noweImie, noweNazwisko));
                System.out.println("Kontakt zaktualizowany!");
                return;
            }
        }
        System.out.println("Nie znaleziono kontaktu o podanym ID.");
    }

    private static void usunKontakt(Scanner scanner) {
        System.out.print("Podaj ID kontaktu do usunięcia: ");
        int id = scanner.nextInt();

        for (Kontakt kontakt : kontakty) {
            if (kontakt.getId() == id) {
                kontakty.remove(kontakt);
                System.out.println("Kontakt usunięty!");
                return;
            }
        }
        System.out.println("Nie znaleziono kontaktu o podanym ID.");
    }
}
