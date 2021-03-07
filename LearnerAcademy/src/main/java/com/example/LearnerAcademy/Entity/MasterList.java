package com.example.LearnerAcademy.Entity;

import java.util.ArrayList;
import java.util.List;

public class MasterList {
    public static List<String> getMasterCLass() {
        List<String> classList1 = new ArrayList<>();
        classList1.add("I");
        classList1.add("II");
        classList1.add("III");
        classList1.add("IV");
        classList1.add("V");
        classList1.add("VI");
        classList1.add("VII");
        classList1.add("VIII");
        classList1.add("IX");
        classList1.add("X");
        classList1.add("XI");
        classList1.add("XII");

        return classList1;
    }

    public static List<String> getMasterTeacher() {
        List<String> teacherList = new ArrayList<>();
        teacherList.add("Arun");
        teacherList.add("Vikas");
        teacherList.add("Yeshwanth");
        teacherList.add("Fatemaa");
        teacherList.add("Anjali");
        teacherList.add("Pavithra");
        teacherList.add("Asfiya");

        return teacherList;
    }

    public static List<String> getMasterSubject() {
        List<String> subjectList = new ArrayList<>();
        subjectList.add("English");
        subjectList.add("Hindi");
        subjectList.add("Math");
        subjectList.add("CS");
        subjectList.add("Science");
        subjectList.add("SST");

        return subjectList;
    }


}
