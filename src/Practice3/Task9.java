package Practice3;

/**
 * Практичне завдання №3, Завдання №9 (Варіант 12)
 */
public class Task9 {

    public static void main(String[] args) {
        // Дозволені значення
        printResults(1);
        printResults(2);
        printResults(5);
        printResults(10);

        // Заборонені (некоректні) значення
        printResults(0);
        printResults(-3);
    }

    /**
     * @param t параметр і верхня межа підсумовування (t >= 1)
     * @return значення функції
     * @throws IllegalArgumentException якщо t < 1
     */
    public static double calculateFunction(int t) {
        if (t < 1) {
            throw new IllegalArgumentException("Параметр t має бути >= 1, передано: " + t);
        }

        double sum = 0.0;
        double sqrtT = Math.sqrt(t);

        for (int i = 1; i <= t; i++) {
            if (i % 2 != 0) { // Непарне i (1, 3, 5, ...)
                sum += Math.sqrt((double) t * i);
            } else { // Парне i (2, 4, 6, ...)
                sum += (double) i / sqrtT;
            }
        }
        return sum;
    }

    static void printResults(int t) {
        System.out.print("t: " + t + " | result: ");
        try {
            System.out.println(calculateFunction(t));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
