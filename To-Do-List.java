// Importē nepieciešamās Java klases
import java.util.ArrayList;   // Lai izmantotu dinamisku sarakstu (uzdevumu glabāšanai)
import java.util.Scanner;    // Lai iegūtu lietotāja ievadi no konsoles

// Galvenā klase programmai
public class TodoList {
    // Statisks saraksts, kurā glabāsim visus uzdevumus
    private static ArrayList<String> tasks = new ArrayList<>();
    // Scanner objekts, lai nolasīt lietotāja ievadi
    private static Scanner scanner = new Scanner(System.in);

    // Galvenā metode, kurā sākas programmas izpilde
    public static void main(String[] args) {
        boolean running = true;  // Kontroles mainīgais programmas darbībai

        // Galvenais programmas cikls (darbojas, kamēr lietotājs neizvēlas "iziet")
        while (running) {
            // Izvada galveno izvēlni
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Pievienot uzdevumu");
            System.out.println("2. Apskatīt uzdevumus");
            System.out.println("3. Dzēst uzdevumu");
            System.out.println("4. Iziet");
            System.out.print("Izvēlieties darbību: ");

            // Nolasa lietotāja izvēli
            int choice = scanner.nextInt();
            scanner.nextLine();  // Notīra ievades buferi

            // Darbību izvēle, balstoties uz lietotāja ievadi
            switch (choice) {
                case 1:
                    addTask();    // Izsauc uzdevuma pievienošanas metodi
                    break;
                case 2:
                    viewTasks();  // Izsauc uzdevumu apskates metodi
                    break;
                case 3:
                    deleteTask(); // Izsauc uzdevuma dzēšanas metodi
                    break;
                case 4:
                    running = false;  // Pārtrauc programmas darbību
                    System.out.println("Programma beidz darbu...");
                    break;
                default:
                    System.out.println("Nepareiza izvēle!");  // Ja ievade nav no 1 līdz 4
            }
        }
        scanner.close();  // Aizver Scanner objektu
    }

    // Metode uzdevuma pievienošanai
    private static void addTask() {
        System.out.print("Ievadiet uzdevumu: ");
        String task = scanner.nextLine();  // Nolasa lietotāja ievadīto uzdevumu
        tasks.add(task);                  // Pievieno uzdevumu sarakstam
        System.out.println("Uzdevums pievienots!");
    }

    // Metode uzdevumu apskatei
    private static void viewTasks() {
        if (tasks.isEmpty()) {  // Pārbauda, vai saraksts ir tukšs
            System.out.println("Nav neviena uzdevuma!");
        } else {
            System.out.println("\n--- Jūsu uzdevumi ---");
            // Izvada visus uzdevumus ar to numuriem
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Metode uzdevuma dzēšanai
    private static void deleteTask() {
        viewTasks();  // Vispirms parāda visus uzdevumus
        if (!tasks.isEmpty()) {  // Pārbauda, vai saraksts nav tukšs
            System.out.print("Ievadiet uzdevuma numuru, ko dzēst: ");
            int taskNum = scanner.nextInt();  // Nolasa dzēšamā uzdevuma numuru
            // Pārbauda, vai numurs ir derīgs
            if (taskNum >= 1 && taskNum <= tasks.size()) {
                tasks.remove(taskNum - 1);  // Dzēš uzdevumu (indeksi sākas ar 0)
                System.out.println("Uzdevums dzēsts!");
            } else {
                System.out.println("Nepareizs uzdevuma numurs!");
            }
        }
    }
}
