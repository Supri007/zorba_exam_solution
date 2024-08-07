package entity;

import java.util.Scanner;

public class Subject {
    public int subjectId;
    public String subjectName;

    public int getSubject_id() {
        return subjectId;
    }

    public void setSubject_id(int subject_id) {
        this.subjectId = subject_id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    public Subject GetInputFromUser(){
        Scanner sc = new Scanner(System.in);
        Subject subject = new Subject();

        try{
            System.out.println("Please enter Subject Id: ");
            subject.subjectId = sc.nextInt();
            sc.nextLine();
            System.out.println("Please enter Subject name: ");
            subject.subjectName = sc.nextLine();
            sc.close();
        }
        catch (Exception ex){
            System.out.println("Invalid user Input for Subject, please try again. Error: " + ex.getMessage());
        }
        return subject;
    }
}
