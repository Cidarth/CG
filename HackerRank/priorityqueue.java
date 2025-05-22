package HackerRank;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                } else if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return Integer.compare(s1.getID(), s2.getID());
                }
            }
        });

        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] parts = event.split(" ");
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (event.equals("SERVED")) {
                pq.poll(); 
            }
        }

        List<Student> students = new ArrayList<>();
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }

        return students;
    }
}

public class priorityqueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalEvents = Integer.parseInt(sc.nextLine());
        List<String> events = new ArrayList<>();

        for (int i = 0; i < totalEvents; i++) {
            events.add(sc.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student s : students) {
                System.out.println(s.getName());
            }
        }

        sc.close();
    }
}

