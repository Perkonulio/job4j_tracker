package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John");
        student.setSurname("Brahlovski");
        student.setNumberGroup(15);
        student.setDate("15.09.2010");
        System.out.println(student.getName() + " " + student.getSurname()
                + " " + student.getNumberGroup() + " " + student.getDate());
    }
}
