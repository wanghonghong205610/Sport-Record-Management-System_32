package SportsConnection;

import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("✨ 运动记录小助手启动！输入数字操作：");

        ExerciseDAO dao = new ExerciseDAO();

        while (true) {
            System.out.println("\n1. 记录运动  2. 查看记录  3. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1: dao.recordExercise(scanner); break;
                case 2: dao.viewExercises(); break;
                case 3: System.out.println("下次见！🏃‍♂️"); return;
                default: System.out.println("输入错误，再试一次~");
            }
        }
    }
}