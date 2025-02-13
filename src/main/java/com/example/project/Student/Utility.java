package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {


    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        
        ArrayList<String> summaryListOriginal = new ArrayList<>();
        ArrayList<String> newSummaryList = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for(Student student : list){
            String str = "";
            str += student.getLastName() + student.getFirstName() + (100 - student.getGpa());
            summaryListOriginal.add(str);
        }

        for(int i = 0; i < summaryListOriginal.size(); i ++){
            boolean isPlaced = false;
            for(int j = 0; j < newSummaryList.size() ; j ++){
                if((!isPlaced) && newSummaryList.get(j).compareTo(summaryListOriginal.get(i)) > 0){
                    newSummaryList.add(j, summaryListOriginal.get(i));
                    indices.add(j, i);
                    isPlaced = true;
                }
            }
            if(!isPlaced){
                newSummaryList.add(0, summaryListOriginal.get(i));
                indices.add(0,newSummaryList.size()-1);
            }
        }

        ArrayList<Student> newList = new ArrayList<>();

        for(int i = 0; i < indices.size(); i ++){
            newList.add(list.get(indices.get(i)));
        }

        list = newList;

        return list;
    }

}
