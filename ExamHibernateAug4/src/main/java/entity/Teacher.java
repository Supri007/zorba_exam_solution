package entity;

import java.util.Scanner;

public class Teacher {
    public int teacherId;
    public String teacherName;
    public String teacherQualification;
    public String teacherExperience;
    public int studentId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(String teacherQualification) {
        this.teacherQualification = teacherQualification;
    }

    public String getTeacherExperience() {
        return teacherExperience;
    }

    public void setTeacherExperience(String teacherExperience) {
        this.teacherExperience = teacherExperience;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherQualification='" + teacherQualification + '\'' +
                ", teacherExperience='" + teacherExperience + '\'' +
                ", studentId=" + studentId +
                '}';
    }

    public Teacher GetInputFromUser(){
        Scanner sc = new Scanner(System.in);
        Teacher teacher = new Teacher();
        try{
            System.out.println("Please enter Teacher Id: ");
            teacher.teacherId = sc.nextInt();
            sc.nextLine();

            System.out.println("Please enter Teacher name: ");
            teacher.teacherName = sc.nextLine();
            System.out.println("Please enter Teacher Qualification: ");
            teacher.teacherQualification = sc.nextLine();
            System.out.println("Please enter Teacher Experience: ");
            teacher.teacherExperience = sc.nextLine();
            sc.close();
        }
        catch(Exception ex){
            System.out.println("Invalid user Input for Teacher, please try again. Error: " + ex.getMessage());

        }
        return teacher;
    }
}
