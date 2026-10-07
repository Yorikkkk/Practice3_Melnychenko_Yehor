package Practice3;

/**
 * Практичне завдання №3, Завдання №11 (Варіант 12)
 */
public class Task11 {

    public static void main(String[] args) {
        // Дозволені значення
        printResults(1e-2);
        printResults(1e-4);
        printResults(1e-6);

        // Заборонені (некоректні) значення
        printResults(0.0);
        printResults(-0.01);
        printResults(Double.NaN);
    }

    /**
     * @param eps точність обчислень (eps > 0)
     * @return сума ряду
     * @throws IllegalArgumentException якщо eps <= 0 або eps є NaN
     */
    public static double calculateInfiniteSum(double eps) {
        if (Double.isNaN(eps) || eps <= 0) {
            throw new IllegalArgumentException("Точність eps має бути > 0, передано: " + eps);
        }

        double sum = 0.0;
        int i = 1;

        while (true) {
            double term = 1.0 / ((double) i * i);
            if (Math.abs(term) < eps) {
                break;
            }
            sum += term;
            i++;
        }

        return sum;
    }


    static void printResults(double eps) {
        System.out.print("eps: " + eps + " | result: ");
        try {
            System.out.println(calculateInfiniteSum(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}