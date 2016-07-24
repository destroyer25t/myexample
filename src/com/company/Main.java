package com.company;

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


    public static void main(String[] args) {
        int countOfClasses=0;
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
        massiv=mySearcher.lazyGuess("00a");

        for(String string:massiv){
            System.out.println(string);
        }

        //System.out.println("Массив содержит "+mySearcher.calculateCount("00000000000000000000000000000000")+ " включений слова 00a");

    }
}
