import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
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
                oceny = ocenyUczniow.get(imie);
                System.out.println("Dodawanie ocen do istniejącej listy dla " + imie + ".");
            } else {
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
                    if (ocena <= 0 || ocena > 6) { // Zmiana warunku na ocena <= 0
                        System.out.println("Ocena musi być wartością dodatnią i mniejszą lub równą 6.");
                    } else {
                        oceny.add(ocena);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Nieprawidłowy format. Wprowadź liczbę.");
                }
            }

            ocenyUczniow.put(imie, oceny);
        }

        System.out.println("\nOceny i średnie dla każdego ucznia:");
        for (Map.Entry<String, List<Double>> wpis : ocenyUczniow.entrySet()) {
            String imie = wpis.getKey();
            List<Double> oceny = wpis.getValue();
            System.out.println(imie + ": ");

            if (!oceny.isEmpty()) {
                double suma = 0;
                for (Double ocena : oceny) {
                    System.out.print(ocena + " ");
                    suma += ocena;
                }
                System.out.println("\nSuma ocen: " + suma);
                
                double srednia = suma / oceny.size();
                System.out.printf("Średnia ocen = %.2f\n\n", srednia);
            } else {
                System.out.println("Brak ocen. Średnia nie może być obliczona.\n");
            }
        }
    }
}
