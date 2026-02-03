/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

public class GradeCount {
    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);

        int[] gradeCount = new int[10]; // index 1–9 used for grades

        int student = 1;
        while (student <= 5) {   
            System.out.print("Enter score for student " + student + ": ");
            int score = input.nextInt();
            
            student++;

            int grade;
            String remark;

            if (score >= 80 && score <= 100) {
                grade = 1; remark = "D1";
            } else if (score >= 75) {
                grade = 2; remark = "D2";
            } else if (score >= 66) {
                grade = 3; remark = "C3";
            } else if (score >= 60) {
                grade = 4; remark = "C4";
            } else if (score >= 50) {
                grade = 5; remark = "C5";
            } else if (score >= 45) {
                grade = 6; remark = "C6";
            } else if (score >= 35) {
                grade = 7; remark = "P7";
            } else if (score >= 30) {
                grade = 8; remark = "P8";
            } else {
                grade = 9; remark = "F";
            }

        
            gradeCount[grade]++;

            
            System.out.println("Student " + student + " → Score: " + score + ", Grade: " + grade + ", Remark: " + remark);

            student++; 
        }

        
        System.out.println("\n--- Summary of Grades ---");
        for (int i = 1; i <= 9; i++) {
            System.out.println("Grade " + i + ": " + gradeCount[i] + " student(s)");
        }

        input.close();
    }
}

