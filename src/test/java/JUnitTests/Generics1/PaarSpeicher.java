package JUnitTests.Generics1;

import JUnitTests.Boxer;
import JUnitTests.Student;

public class PaarSpeicher{
    public static void main(String[] args){
        WarteschlangeMitArrayG<Paar<Student, String>> servicepoint = new WarteschlangeMitArrayG<>(4);
        KellerspeicherMitArrayG<Paar<Boxer, Boxer>> boxkampf = new KellerspeicherMitArrayG(3);

        Student s1 = new Student("Liam", "Hess", 90904545);
        Paar<Student, String> ss1 = new Paar<>();
        ss1.setBeide(s1, "Wie viel Uhr?");
        Student s2 = new Student("Siriporn", "Senma", 90904523);
        Paar<Student, String> ss2 = new Paar<>();
        ss2.setBeide(s2, "Wie viel Uhr?");
        Student s3 = new Student("Niklas", "Müseler", 90904536);
        Paar<Student, String> ss3 = new Paar<>();
        ss3.setBeide(s3, "Wie viel Uhr?");
        Student s4 = new Student("Tim", "Polland", 90904524);
        Paar<Student, String> ss4 = new Paar<>();
        ss4.setBeide(s4, "Wie viel Uhr?");

        Boxer b1 = new Boxer("Emirhan", "Obuntas", 60);
        Boxer b2 = new Boxer("Paul", "Obuntas", 75);
        Boxer b3 = new Boxer("Frederic", "Mark", 56);
        Boxer b4 = new Boxer("Max", "Maus", 66);
        Boxer b5 = new Boxer("Siegfried", "Obuntas", 80);
        Boxer b6 = new Boxer("Samule", "Ob", 60);

        Paar<Boxer, Boxer> bb1 = new Paar<>();
        bb1.setBeide(b1, b2);
        boxkampf.push(bb1);
        Paar<Boxer, Boxer> bb2 = new Paar<>();
        bb2.setBeide(b3, b4);
        boxkampf.push(bb2);
        Paar<Boxer, Boxer> bb3 = new Paar<>();
        bb3.setBeide(b5, b6);
        boxkampf.push(bb3);

        servicepoint.push(ss1);
        servicepoint.push(ss2);
        servicepoint.push(ss3);
        servicepoint.push(ss4);

        for(int i = 0; i < 4; i++){
            System.out.println(servicepoint.pop().toString());
        }

        for(int i = 0; i < 3; i++){
            System.out.println(boxkampf.pop().toString());
        }
    }
}
