import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int goalByStepsPerDay = 10_000;
    int numberOfDays;
    int numberOfSteps;
    int numberOfMonth;

    {
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов: ");
        goalByStepsPerDay = scanner.nextInt();
        if (goalByStepsPerDay < 1) {
            System.out.println("Значение не может быть ниже нуля");
            goalByStepsPerDay = 10_000;
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите месяц: ");
        numberOfMonth = numberOfMonth(scanner.nextInt());

        System.out.println("Введите день: ");
        numberOfDays = numberOfDays(scanner.nextInt());

        System.out.println("Введите шаги: ");
        numberOfSteps = numberOfSteps(scanner.nextInt());

        monthToData[numberOfMonth].days[numberOfDays] = numberOfSteps;
    }

    void printStatistic() {
        System.out.println("Введите число месяца: ");
        numberOfMonth = numberOfMonth(scanner.nextInt());
        monthToData[numberOfMonth].printDaysAndStepsFromMonth();

        System.out.printf("""
                Общее количество шагов за месяц: %s 
                Максимальное пройденное количество шагов за месяц: %s
                Среднее количество пройденных шагов за месяц: %s
                Пройденная дистанция за месяц в км: %f
                Количество сожжённых килокалорий за месяц: %f
                Лучшая серия за месяц: %s               
                """.formatted(monthToData[numberOfMonth].sumStepsFromMonth(),
                monthToData[numberOfMonth].maxSteps(),
                monthToData[numberOfMonth].averageSteps(),
                converter.convertToKm(monthToData[numberOfMonth].sumStepsFromMonthDouble()),
                converter.convertStepsToKilocalories(monthToData[numberOfMonth].sumStepsFromMonthDouble()),
                monthToData[numberOfMonth].bestSeries(goalByStepsPerDay)
        ));
    }

    int numberOfMonth(int a) {
        if (a < 1 || a > 12) {
            System.out.println("Неправильно ввели месяц");
            Runtime.getRuntime().exit(0);           //Как прервать метод если неправильно ввели число
        }
        return a - 1;
    }

    int numberOfDays(int a) {
        if (a < 1 || a > 30) {
            System.out.println("Неправильно ввели день");
            Runtime.getRuntime().exit(0);            //Как прервать метод если неправильно ввели число
        }
        return a - 1;
    }

    int numberOfSteps(int a) {
        if (a < 1) {
            System.out.println("Неправильно ввели шаг");
            Runtime.getRuntime().exit(0);           //Как прервать метод если неправильно ввели число
        }
        return a;
    }
}