package SportsConnection;

import java.sql.*;
import java.util.Scanner;

public class ExerciseDAO {
    public void recordExercise(Scanner scanner) {
        System.out.print("运动类型（跑步/游泳...）: ");
        String type = scanner.nextLine();
        System.out.print("时长（分钟）: ");
        int duration = scanner.nextInt();
        System.out.print("距离（公里）: ");
        double distance = scanner.nextDouble();
        scanner.nextLine(); // 消耗换行符

        System.out.print("日期（YYYY-MM-DD）: ");
        String date = scanner.nextLine();

        String sql = "INSERT INTO exercises (type, duration, distance, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            pstmt.setInt(2, duration);
            pstmt.setDouble(3, distance);
            pstmt.setString(4, date);
            pstmt.executeUpdate();
            System.out.println("✅ 记录成功！" + type + " " + duration + "分钟");
        } catch (SQLException e) {
            System.out.println("⚠️ 记录失败: " + e.getMessage());
        }
    }

    public void viewExercises() {
        String sql = "SELECT * FROM exercises ORDER BY date DESC";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n===== 你的运动记录 =====");
            while (rs.next()) {
                System.out.printf("【%s】%s | %d分钟 | %.1fkm%n",
                        rs.getString("date"),
                        rs.getString("type"),
                        rs.getInt("duration"),
                        rs.getDouble("distance"));
            }
        } catch (SQLException e) {
            System.out.println("❌ 读取失败: " + e.getMessage());
        }
    }
}