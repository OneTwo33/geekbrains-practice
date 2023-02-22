package ru.onetwo33.practice.homework5;

public class Main {

    public static void main(String[] args) {

        BaseDAO<Student> studentDAO = new BaseDAO<>();
        Student student = new Student("Alex", 4);
        studentDAO.persist(student);
        Student student1 = studentDAO.findById(1L, Student.class);
        student.setMark(5);
        studentDAO.merge(student);
        studentDAO.remove(student);
        student1 = studentDAO.findById(1L, Student.class);
    }
}
