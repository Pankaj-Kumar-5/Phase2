package com.example.LearnerAcademy.Entity;


import com.example.LearnerAcademy.Entity.utility.HibernateUtility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void addAdmin(Admin admin) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Admin ad1 = new Admin(admin.getName(), admin.getEmail(), admin.getPhone(), admin.getPassword(), admin.getCity());

        session.save(ad1);
        tx.commit();
        session.disconnect();
        System.out.println("Admin added successfully");
    }

    public static void addStudent(Student student) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Student s1 = new Student(student.getName(), student.getClassName(), student.getSubjectName(), student.getTeacherName());

        session.save(s1);
        tx.commit();
        session.disconnect();
        System.out.println("Student added successfully");
    }

    public static boolean validateAdmin(String name, String password) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Admin");

        List<Admin> admins = query.list();

        for (Admin admin : admins) {
            if (admin.getName().equals(name) && admin.getPassword().equals(password)) {
                return true;
            }
        }

        return false;

    }

    public static boolean isAdminPresent(String name) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Admin");

        List<Admin> admins = query.list();

        for (Admin admin : admins) {
            if (admin.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isAdminEmail(String email) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Admin");

        List<Admin> admins = query.list();

        for (Admin admin : admins) {
            if (admin.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public static int getAdminId(String name) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Admin");

        List<Admin> admins = query.list();

        for (Admin admin : admins) {
            if (admin.getName().equals(name)) {
                return admin.getId();
            }
        }

        return -1;
    }

    public static boolean updateAdmin(Admin admin) {
        int id = getAdminId(admin.getName());
        if (id != -1) {
            Session session = HibernateUtility.getSession();

            Transaction tx = session.beginTransaction();

            Admin e = (Admin) session.get(Admin.class, id);
            e.setCity(admin.getCity());
            e.setPassword(admin.getPassword());
            e.setEmail(admin.getEmail());
            e.setPhone(admin.getPhone());
            session.update(e);
            tx.commit();
            return true;
        }

        return false;
    }

    public static List<String> getStudentsFromClass(String className) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Student");

        List<Student> students = query.list();
        List<String> allStudent = new ArrayList<>();

        for (Student student : students) {
            if (student.getClassName().equals(className)) {
                allStudent.add(student.getName());
            }
        }

        return allStudent;
    }


    public static List<Student> getAllClass() {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Student");

        List<Student> students = query.list();
        return students;
    }


    public static Student getStudentById(String id) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        for (Student student : students) {
            if ((student.getsId() + "").equals(id)) {
                return student;
            }
        }
        return null;
    }

    public static void updateStudent(Student oldS) {
        Session session = HibernateUtility.getSession();
        Transaction tx = session.beginTransaction();

        Student e = (Student) session.get(Student.class, oldS.getsId());
        e.setName(oldS.getName());
        e.setClassName(oldS.getClassName());
        e.setSubjectName(oldS.getSubjectName());
        e.setTeacherName(oldS.getTeacherName());

        session.update(e);
        tx.commit();
        System.out.println("Student update was successful");
    }

    public static void deleteStudent(String id) {
        Session session = HibernateUtility.getSession();

        Transaction tx = session.beginTransaction();
        Student e = new Student();

        e.setsId(Integer.parseInt(id));
        session.delete(e);
        tx.commit();
        System.out.println("Delete was successful");
    }
}
