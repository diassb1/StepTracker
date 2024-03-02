public class MonthData {
    int[] days = new int[5];

    void printDaysAndStepsFromMonth() {
        int i = 1;
        for (int b : days) {
            System.out.println((i++) + " День: " + b);
        }
    }

    int sumStepsFromMonth() {
        int summ = 0;
        for (int b : days) {
            summ += b;
        }
        return summ;
    }

    double sumStepsFromMonthDouble() {
        double summ = 0;
        for (int b : days) {
            summ += b;
        }
        return summ;
    }

    int maxSteps() {
        int maxSteps = days[0];
        for (int b : days) {
            if (maxSteps < b) {
                maxSteps = b;
            }
        }
        return maxSteps;
    }

    double averageSteps() {
        return sumStepsFromMonthDouble() / days.length;
    }

    int bestSeries(int goalByStepsPerDay) {
        int i = 0;
        for (int b : days) {
            if (b >= goalByStepsPerDay) { //5000
                i++;
            } else i = 0;
        }
        return i;
    }
}