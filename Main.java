import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Меню лабораторной работы №2 ---");
            System.out.println("1. Задание 1.1 - Точка координат");
            System.out.println("2. Задание 2.1 - Линия");
            System.out.println("3. Задание 3.1 - Студент");
            System.out.println("4. Задание 4.1 - Создаём Точку");
            System.out.println("5. Задание 4.7 - Создаём Студента");
            System.out.println("6. Задание 5.6 - Студент отличник");
            System.out.println("0. Выход");
            System.out.print("Выберите задание: ");

            choice = readInt(scanner, "");
            if (choice < 0 || choice > 6) {
                System.out.println("Ошибка! Выберите от 0 до 6.");
                continue;
            }
            switch (choice) {
                case 1: task1_1(scanner); break;
                case 2: task2_1(scanner); break;
                case 3: task3_1(scanner); break;
                case 4: task4_1(scanner); break;
                case 5: task4_7(scanner); break;
                case 6: task5_6(scanner); break;
                case 0: System.out.println("\nДо свидания!"); break;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void task1_1(Scanner scanner) {
        System.out.println("\n=== Задание 1.1: Точка координат ===\n");
        Point p1 = readPoint(scanner, "--- Создание Точки 1 ---");
        Point p2 = readPoint(scanner, "\n--- Создание Точки 2 ---");
        Point p3 = readPoint(scanner, "\n--- Создание Точки 3 ---");
        System.out.println("\nСозданные точки:\nТочка 1: " + p1 + "\nТочка 2: " + p2 + "\nТочка 3: " + p3);
    }

    private static void task2_1(Scanner scanner) {
        System.out.println("\n=== Задание 2.1: Линия ===\n");
        Point l1s = readPoint(scanner, "--- Создание Линии 1 ---\nНачало линии 1:");
        Point l1e = readPoint(scanner, "Конец линии 1:");
        Line line1 = new Line(l1s, l1e);
        Point l2s = readPoint(scanner, "\n--- Создание Линии 2 ---\nНачало линии 2:");
        Point l2e = readPoint(scanner, "Конец линии 2:");
        Line line2 = new Line(l2s, l2e);
        Line line3 = new Line(l1s, l2e);

        System.out.println("\nПосле создания:\nЛиния 1: " + line1 + "\nЛиния 2: " + line2 + "\nЛиния 3: " + line3);

        System.out.println("\n--- Пункт 4: Изменение координат Линии 1 и Линии 2 ---");
        Point newL1s = readPoint(scanner, "Введите новые координаты для начала Линии 1:");
        l1s.setX(newL1s.getX()); l1s.setY(newL1s.getY());
        Point newL2e = readPoint(scanner, "\nВведите новые координаты для конца Линии 2:");
        l2e.setX(newL2e.getX()); l2e.setY(newL2e.getY());
        System.out.println("\nПосле изменения координат Линии 1 и Линии 2:\nЛиния 1: " + line1 + "\nЛиния 2: " + line2 + "\nЛиния 3: " + line3);
        System.out.println("\n   >> Пояснение:\n   Линия 3 изменилась, потому что мы изменили координаты\n   объектов Point, на которые она ссылается.");

        System.out.println("\n--- Пункт 5: Замена начала Линии 1 на НОВЫЙ объект Point ---");
        Point brandNewStart = readPoint(scanner, "Введите координаты для НОВОГО начала Линии 1:");
        line1.setStart(brandNewStart);
        System.out.println("\nПосле замены начала Линии 1 на НОВЫЙ объект Point:\nЛиния 1: " + line1 + "\nЛиния 2: " + line2 + "\nЛиния 3: " + line3);
        System.out.println("\n   >> Пояснение:\n   Линия 3 НЕ изменилась, потому что мы создали НОВЫЙ объект Point\n   и присвоили его Линии 1. Линия 3 продолжает ссылаться на старый объект.");
    }

    private static void task3_1(Scanner scanner) {
        System.out.println("\n=== Задание 3.1: Студент ===\n");
        Student vasya = readStudent(scanner, "--- Создание студента Васи ---");
        System.out.println("1. Создан " + vasya);

        String petyaName = readString(scanner, "\n--- Создание студента Пети (копирование оценок Васи) ---\nВведите имя студента: ");
        Student petya = new Student(petyaName);
        petya.setGrades(vasya.getGrades());
        System.out.println("2. Создан " + petya + " (скопированы оценки " + vasya.getName() + ")");

        if (vasya.getGrades().length == 0) {
            System.out.println("\n   >> У " + vasya.getName() + " нет оценок, менять нечего! Демонстрация поверхностной копии невозможна.");
        } else {
            int newGradeForPetya = readInt(scanner, "\nНа какое число заменить первую оценку " + petyaName + "? ");
            petya.getGrades()[0] = newGradeForPetya;
            System.out.println("\n3. После изменения первой оценки " + petyaName + " на " + newGradeForPetya + ":");
            System.out.println("   " + vasya.getName() + ": " + vasya);
            System.out.println("   " + petyaName + ": " + petya);
            System.out.println("\n   >> Пояснение:\n" +
                    "   Оценки " + vasya.getName() + " тоже изменились на " + newGradeForPetya + "!\n" +
                    "   Это произошло потому, что при petya.setGrades(vasya.getGrades())\n" +
                    "   мы скопировали не сам массив, а ССЫЛКУ на него.\n" +
                    "   Теперь " + petyaName + " и " + vasya.getName() + " ссылаются на один и тот же массив в памяти.");
        }

        String andreyName = readString(scanner, "\n--- Создание студента Андрея (глубокая копия) ---\nВведите имя студента: ");
        Student andrey = new Student(andreyName);
        andrey.setGrades(Arrays.copyOf(vasya.getGrades(), vasya.getGrades().length));

        if (vasya.getGrades().length == 0) {
            System.out.println("\n   >> У " + vasya.getName() + " нет оценок, менять нечего! Демонстрация глубокой копии невозможна.");
        } else {
            int newGradeForVasya = readInt(scanner, "\nНа какое число изменить первую оценку " + vasya.getName() + "? ");
            vasya.getGrades()[0] = newGradeForVasya;
            System.out.println("\n4. Создан " + andreyName + " (глубокая копия). Изменили оценку " + vasya.getName() + " на " + newGradeForVasya + ":");
            System.out.println("   " + vasya.getName() + ": " + vasya);
            System.out.println("   " + andreyName + ": " + andrey);
            System.out.println("\n   >> Пояснение:\n" +
                    "   Оценки " + andreyName + " НЕ изменились, потому что мы создали\n" +
                    "   совершенно НОВЫЙ массив (глубокая копия) и скопировали туда значения.\n" +
                    "   Теперь у " + vasya.getName() + " и " + andreyName + " разные массивы в памяти.");
        }
    }

    private static void task4_1(Scanner scanner) {
        System.out.println("\n=== Задание 4.1: Создаём Точку ===\n");
        System.out.println("Создана Точка 1: " + readPoint(scanner, "--- Создание Точки 1 ---"));
        System.out.println("Создана Точка 2: " + readPoint(scanner, "\n--- Создание Точки 2 ---"));
        System.out.println("Создана Точка 3: " + readPoint(scanner, "\n--- Создание Точки 3 ---"));
        System.out.println("\n   >> Пояснение:\n   Теперь создать точку можно только указав обе координаты.\n   Конструктор по умолчанию (без параметров) закомментирован.\n   Попытка написать \"new Point()\" вызовет ошибку компиляции.");
    }

    private static void task4_7(Scanner scanner) {
        System.out.println("\n=== Задание 4.7: Создаём Студента ===\n");
        System.out.println("1. " + readStudent(scanner, "--- Создание студента Васи ---"));
        System.out.println("2. " + readStudent(scanner, "\n--- Создание студента Максима ---"));
        System.out.println("\n   >> Пояснение:\n   Оба способа создания реализованы единственным конструктором:\n   public Student(String name, int... grades)\n   Синтаксис 'int...' (varargs) позволяет передать любое количество\n   оценок, включая ноль. Если оценки не переданы, создаётся пустой массив [].");
    }

    private static void task5_6(Scanner scanner) {
        System.out.println("\n=== Задание 5.6: Студент отличник ===\n");
        Student vasya = readStudent(scanner, "--- Создание студента Васи ---");
        System.out.println("1. " + vasya + "\n   Средний балл: " + vasya.getAverage() + "\n   Отличник: " + (vasya.isExcellent() ? "да" : "нет"));
        Student petya = readStudent(scanner, "\n--- Создание студента Пети ---");
        System.out.println("2. " + petya + "\n   Средний балл: " + petya.getAverage() + "\n   Отличник: " + (petya.isExcellent() ? "да" : "нет"));
    }

    // --- Вспомогательные методы ---
    private static Point readPoint(Scanner scanner, String title) {
        System.out.println(title);
        double x = readDouble(scanner, "Введите координату X: ");
        double y = readDouble(scanner, "Введите координату Y: ");
        return new Point(x, y);
    }

    private static Student readStudent(Scanner scanner, String title) {
        System.out.println(title);
        String name = readString(scanner, "Введите имя студента: ");
        System.out.println("Введите оценки для " + name + ":");
        return new Student(name, readGrades(scanner));
    }

    private static String readString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) return input.trim();
            System.out.println("Ошибка! Ввод не может быть пустым.");
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Ошибка! Ввод не может быть пустым.");
                    continue;
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Ошибка! Ввод не может быть пустым.");
                    continue;
                }
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите числовое значение.");
            }
        }
    }

    private static int[] readGrades(Scanner scanner) {
        int count = readInt(scanner, "Введите количество оценок: ");
        while (count < 0) {
            System.out.println("Ошибка! Количество оценок не может быть отрицательным.");
            count = readInt(scanner, "Введите количество оценок: ");
        }
        if (count == 0) return new int[0];
        int[] grades = new int[count];
        for (int i = 0; i < count; i++) {
            int grade = readInt(scanner, "Введите оценку " + (i + 1) + ": ");
            while (grade < 2 || grade > 5) {
                System.out.println("Ошибка! Оценка должна быть от 2 до 5.");
                grade = readInt(scanner, "Введите оценку " + (i + 1) + ": ");
            }
            grades[i] = grade;
        }
        return grades;
    }
}