package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student {
    public int studentId;
    public String studentName;
    public int studentRollNo;
    public String subjectId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentRollNo=" + studentRollNo +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }

    public Student GetInputFromUser(List<Subject> subList){
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        Map<Integer, String> subjectIdToName = new HashMap<Integer, String>();
        for(Subject sub : subList){
            subjectIdToName.put(sub.subjectId, sub.subjectName);
        }
        String subNames = String.join(",", subjectIdToName.values());

        try{
            System.out.println("Please enter Student Id: ");
            student.studentId = sc.nextInt();
            sc.nextLine();
            System.out.println("Please enter Student Name: ");
            student.studentName = sc.nextLine();
            System.out.println("Please enter Student roll number: ");
            student.studentRollNo = sc.nextInt();
            sc.nextLine();
            System.out.println(String.format("Please enter Subject Available options are %s: " + subNames));
            String subjectChoosen = sc.nextLine();
            if (subNames.contains(subjectChoosen)){
                for (int key: subjectIdToName.keySet()){
                    if (subjectChoosen == subjectIdToName.get(key)){
                        student.studentId = key;
                    }
                }
            }

            sc.close();
        }
        catch(Exception ex){
            System.out.println("Invalid user Input for Student, please try again. Error: " + ex.getMessage());
        }
        return student;
    }
}
