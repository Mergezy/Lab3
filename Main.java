import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "17-342.txt"; // Замените на путь к вашему файлу
        int minMultiple37 = -1; // Минимальное кратное 37
        int maxMultiple73 = -1; // Максимальное кратное 73
        int countPairs = 0; // Счетчик пар
        int minSum = Integer.MAX_VALUE; // Минимальная сумма пары

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                int num = Integer.parseInt(line);
                
                if (num % 37 == 0) {
                    maxMultiple73 = num;
                } else if (num % 73 == 0) {
                    minMultiple37 = num;
                } else if (minMultiple37 != -1 && maxMultiple73 != -1) {
                    // Проверяем, что только одно число находится между минимальным кратным 37
                    // и максимальным кратным 73.
                    if (num > minMultiple37 && num < maxMultiple73) {
                        countPairs++;
                        minSum = Math.min(minSum, minMultiple37 + num);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Количество найденных пар: " + countPairs);
        System.out.println("Минимальная сумма элементов среди таких пар: " + minSum);
    }
}
