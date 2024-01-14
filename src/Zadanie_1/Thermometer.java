package Zadanie_1;

public class Thermometer {
    private int minTemp;
    private int maxTemp;
    private int currentTemp;

    public Thermometer(int minTemp, int maxTemp) {
        if (minTemp > maxTemp) {
            throw new IllegalArgumentException("minTemp must be less than or equal to maxTemp");
        }
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.currentTemp = 0;
    }

    public static Thermometer createInstance(int minTemp, int maxTemp) {
        return new Thermometer(minTemp, maxTemp);
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(int currentTemp) {
        if (currentTemp < minTemp || currentTemp > maxTemp) {
            throw new IllegalArgumentException("Temperature must be within the specified range.");
        }
        this.currentTemp = currentTemp;
    }

    public int addDegrees(int degrees) {
        int newTemp = currentTemp + degrees;
        if (newTemp > maxTemp) {
            throw new IllegalArgumentException("Temperature exceeds the maximum limit.");
        }
        currentTemp = newTemp;
        return currentTemp;
    }

    public int subtractDegrees(int degrees) {
        int newTemp = currentTemp - degrees;
        if (newTemp < minTemp) {
            throw new IllegalArgumentException("Temperature falls below the minimum limit.");
        }
        currentTemp = newTemp;
        return currentTemp;
    }

    public boolean isBelowZero() {
        return currentTemp < 0;
    }
}
