import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> ocenyUczniow = new HashMap<>();

        while (true) {
            System.out.print("Wprowadź imię ucznia (lub 'koniec', aby zakończyć): ");
            String imie = scanner.nextLine();

            if ("koniec".equalsIgnoreCase(imie)) {
                break;
            }

            List<Double> oceny;
            if (ocenyUczniow.containsKey(imie)) {
                // Jeśli uczniowie już istnieją, pobierz istniejące oceny
                oceny = ocenyUczniow.get(imie);
                System.out.println("Dodawanie ocen do istniejącej listy dla " + imie + ".");
            } else {
                // Jeśli uczniowie nie istnieją, utwórz nową listę
                oceny = new ArrayList<>();
                System.out.println("Wprowadzanie ocen dla " + imie + ". Wpisz 'koniec', aby przejść do następnego ucznia.");
            }

            while (true) {
                System.out.print("Wprowadź ocenę (lub 'koniec'): ");
                String wpisanaOcena = scanner.nextLine();

                if ("koniec".equalsIgnoreCase(wpisanaOcena)) {
                    break;
                }

                try {
                    double ocena = Double.parseDouble(wpisanaOcena);
                    if (ocena < 1 || ocena > 6) {
                        System.out.println("Ocena musi być wartością między 1 a 6.");
                    } else {
                        oceny.add(ocena);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nieprawidłowy format. Wprowadź liczbę.");
                }
            }

            ocenyUczniow.put(imie, oceny);
        }

        System.out.println("\nŚrednie ocen dla każdego ucznia:");
        for (Map.Entry<String, List<Double>> wpis : ocenyUczniow.entrySet()) {
            String imie = wpis.getKey();
            List<Double> oceny = wpis.getValue();
            double suma = 0;
            for (Double ocena : oceny) {
                suma += ocena;
            }
            double srednia = suma / oceny.size();
            System.out.printf("%s: Średnia ocen = %.2f\n", imie, srednia);
        }
    }
}
