package thisiscodingtest.구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 성적낮은순서학생출력하기_6_3 {

    static class Student implements Comparable<Student> {

        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return this.name;
        }

        public int getScore() {
            return this.score;
        }

        // 정렬 기준은 '점수가 낮은 순서'
        @Override
        public int compareTo(Student other) {
            if (this.score < other.score) {
                return -1;
            }
            return 1;
        }
    }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // N을 입력받기
            int n = sc.nextInt();

            // N명의 학생 정보를 입력 받아 리스트에 저장
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                students.add(new Student(name, score));
            }

            Collections.sort(students);

            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).getName()+ "");
            }


        }
    }
