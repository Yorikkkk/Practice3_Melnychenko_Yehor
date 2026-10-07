package Practice3;

/**
 * Практичне завдання №3, Завдання №2 (Варіант 12)
 */
public class Task2 {

    public static void main(String[] args) {
        // Дозволені значення
        printResults(-1.0, 4.0, 3);
        printResults(-0.5, 1.0, 10);
        printResults(-2.0, 0.0, 25);

        // Заборонені (некоректні) значення
        printResults(-1.0, 4.0, 2);   // k <= 2
        printResults(-1.0, 4.0, 26);  // k > 25
        printResults(1.0, 4.0, 5);    // t >= 0 (під логарифмом <= 0)
        printResults(-1.0, -2.0, 5);  // s < 0 (під коренем < 0)
    }

    /**
     * @param t параметр t (має бути < 0)
     * @param s параметр s (має бути >= 0)
     * @param k верхня межа підсумовування (2 < k <= 25)
     * @return сума ряду
     * @throws IllegalArgumentException якщо параметри не відповідають ОДЗ
     */
    public static double calculateSum(double t, double s, int k) {
        if (k <= 2 || k > 25) {
            throw new IllegalArgumentException("Параметр k має відповідати умові 2 < k <= 25, передано: " + k);
        }
        if (t >= 0) {
            throw new IllegalArgumentException("Параметр t має бути < 0 для від'ємного аргументу під логарифмом, передано: " + t);
        }
        if (s < 0) {
            throw new IllegalArgumentException("Параметр s має бути >= 0, передано: " + s);
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            double logArg = -t * i;
            double sqrtArg = s * (1.0 / (i * i));
            sum += Math.log(logArg) * Math.cos(Math.sqrt(sqrtArg));
        }
        return sum;
    }

    static void printResults(double t, double s, int k) {
        System.out.print("t: " + t + ", s: " + s + ", k: " + k + " | result: ");
        try {
            System.out.println(calculateSum(t, s, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}