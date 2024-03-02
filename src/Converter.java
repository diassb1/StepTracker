public class Converter {

    double convertToKm(double steps) {
        return (steps * 75) / 100_000;
    }

    double convertStepsToKilocalories(double steps) {
        return (steps * 50) / 1000;
    }
}
