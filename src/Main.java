import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int a;
        do {
            System.out.println("""
                    1) Ввести количество шагов за определенный день
                    2) Изменить цель по количеству шагов в день
                    3) Напечатать статистику за определенный  месяц
                    4) Выйти из приложения
                    """);
            a = scanner.nextInt();
            switch (a) {
                case 1 -> {
                    System.out.println("Выполняется команда 1");
                    stepTracker.addNewNumberStepsPerDay();
                }
                case 2 -> {
                    System.out.println("Выполняется команда 2");
                    stepTracker.changeStepGoal();
                }
                case 3 -> {
                    System.out.println("Выполняется команда 3");
                    stepTracker.printStatistic();
                }
                case 4 -> {
                    System.out.println("Выход из ситемы");
                    return;
                }
                default -> System.out.println("Такой команды не существует, повторите команду");
            }
        } while (a != 4);
    }
}