package com.company;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.*;

public class Main {
    static String[] classnames;
    static long[] classdates;

    public static void generateClassesNames(int count){
        Random random = new Random();

        for(int i=0;i<count;i++){
            classnames[i]=UUID.randomUUID().toString().replaceAll("-","");
            classdates[i]=System.currentTimeMillis();
        }
    }

    public static void testing(){
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(MySearcherTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    public static void standartExecution(){
        int countOfClasses;
        System.out.print("Input count of classes:");
        Scanner in = new Scanner(System.in);
        countOfClasses=in.nextInt();

        classdates=new long[countOfClasses];
        classnames=new String[countOfClasses];

        long startTime= System.currentTimeMillis();
        generateClassesNames(countOfClasses);
        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время генерации массивов: "+endTime);

        MySearcher mySearcher = new MySearcher();
        mySearcher.refresh(classnames,classdates);
        String[] massiv;
        massiv=mySearcher.usingInnerClassGuess("00a");


        for(String string:massiv){
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        standartExecution();
    }
}
