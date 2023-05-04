public class Main {

    public static void main(String[] args) {
        System.out.println(" Lab4 Java ");
	import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до вхідного файлу: ");
        String inputFilePath = scanner.nextLine();
        File inputFile = new File(inputFilePath);

        while (!inputFile.exists()) {
            System.out.println("Файл не існує, введіть коректний шлях до вхідного файлу:");
            inputFilePath = scanner.nextLine();
            inputFile = new File(inputFilePath);
        }

        int sum = 0;
        boolean hasNumbers = false;  // додати змінну для перевірки, чи є хоча б одне число в файлі
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("\\d+")) {
                    int number = Integer.parseInt(line);
                    sum += number;
                    stringBuilder.append(number).append(System.lineSeparator());
                    hasNumbers = true;  // встановити прапорець, що є числа в файлі
                } else {
                    String[] words = line.split(" ");
                    for (int i = words.length - 1; i >= 0; i--) {
                        stringBuilder.append(words[i]).append(" ");
                    }
                    stringBuilder.append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (hasNumbers) {  // додати перевірку, чи є хоча б одне число в файлі
            System.out.println("Сума: " + sum);
        } else {
            System.out.println("Файл не містить жодного числа.");
        }
        System.out.println("Усі доданки: " + stringBuilder.toString());


        System.out.print("Введіть назву вихідного файлу: ");
        String outputFilePath = scanner.nextLine();
        File outputFile = new File(outputFilePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



    }
}
