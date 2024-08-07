package Execution;

import entity.Student;
import entity.Subject;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class PerformDBOps {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //Create Session factory
        SessionFactory sesFactory = configuration.buildSessionFactory();
        //Create new Session
        Session ses = sesFactory.openSession();
        //Create transaction
        Transaction trans = null;

        //Getting object and getting Input from user
        Subject subject1 = new Subject().GetInputFromUser();
        Subject subject2 = new Subject().GetInputFromUser();
        Subject subject3 = new Subject().GetInputFromUser();
        Subject subject4 = new Subject().GetInputFromUser();

        Query query = null;
        String alterStudent = "alter Student add foreign key(subjectId) +" +
                "references Subject(subjectId)";
        String alterTeacher = "alter Teacher add foreign key(studentId) +" +
                "references Student(studentId)";
        //Get data from DB
        String teacherData = "from Teacher";
        String studentData = "from Student";
        String subjectData = "from Subject";

        //Insert data to database
        try{
            trans = ses.beginTransaction();
            ses.persist(subject1);
            ses.persist(subject2);
            ses.persist(subject3);
            ses.persist(subject4);
            query = ses.createQuery(alterStudent);
            query = ses.createQuery(alterTeacher);
            String subQuery = "Select subject_id, sub_name from subject";
            query = ses.createQuery(subQuery);
            List<Subject> subjectList = query.list();
            Student student = new Student().GetInputFromUser(subjectList);
            Teacher teacher = new Teacher().GetInputFromUser();
            //Assigning student Id to teacher Id
            teacher.studentId = student.studentId;
            ses.persist(student);
            ses.persist(teacher);
            //get Teacher data
            query = ses.createQuery(teacherData);
            List<Teacher> teacherFromDB = query.list();
            System.out.println("Teacher data: " + teacherFromDB);
            //get Student data
            query = ses.createQuery(studentData);
            List<Student> studentFromDB = query.list();
            System.out.println("Student data: " + studentFromDB);
            //get subject data
            query = ses.createQuery(subjectData);
            List<Subject> subjectFromDB = query.list();
            System.out.println("Subject data: " + subjectFromDB);

            String subUpdateQuery = "update Subject set subjectName = :newName where subjectName =: oldName";
            query = ses.createQuery(subUpdateQuery);
            query.setParameter("newName", "Astronomy");
            query.setParameter("oldName", "Mathematics");

            String delQuery = "delete from Student where subjectID =: subId";
            query = ses.createQuery(delQuery);
            query.setParameter("subId","select subjectId from Subject where subjectName =: subName");
            query.setParameter("subName", "Physics");

        }
        catch(Exception ex){
            System.out.println("Failed to Insert data to DB. Error: " + ex.getMessage());
            trans.rollback();
        }
        finally {
            if (ses != null){
                ses.close();
            }
        }
    }
}
