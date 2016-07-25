package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by tailer_d on 23.07.2016.
 */
public class MySearcher implements ISearcher {
    String[] innerClassNames;
    long[] innerClassDates;
    HashMap<String, Long> hashMapClasses;

    innerClass[] massivInnerClass;


    @Override
    public void refresh(String[] classNames, long[] modificationDates) {
        int lenghtOfClassNames=classNames.length;
        long startTime=System.currentTimeMillis();

        massivInnerClass=new innerClass[lenghtOfClassNames];

        for(int i=0;i<lenghtOfClassNames;i++){
            innerClass iC=new innerClass(classNames[i],modificationDates[i]);
            massivInnerClass[i]=iC;
        }

        //innerClassNames = classNames;
        //innerClassDates=modificationDates;

        /*hashMapClasses=new HashMap<>(lenghtOfClassNames);
        for(int i=0;i<lenghtOfClassNames;i++){
            hashMapClasses.put(classNames[i],modificationDates[i]);
        }
        */

        //Arrays.sort(classNames);
        //Arrays.sort(innerClassDates);
        Arrays.sort(massivInnerClass);

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время создания HashMap:"+endTime);
    }

    @Override
    public String[] guess(String start) {
        String[] foundedVariants=new String[12];

        return new String[0];
    }

    public String[] usingStringGuess(String start){
        String[] foundedVariants=new String[12];
        long startTime=System.currentTimeMillis();

        int counter=0;
        for(int i=0;i<innerClassDates.length&&counter<12;i++){
            if(isContained(innerClassNames[i],start)) {
                foundedVariants[counter++]=innerClassNames[i];
            }
        }

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время полного прогона с поиском:"+endTime);
        return foundedVariants;
    }

    public String[] usingDatesGuess(String start){
        String[] foundedVariants=new String[12];
        long startTime=System.currentTimeMillis();
        innerClass[] allInfoMassiv=new innerClass[12];

        int counter=0;
        for(int i=0;i<innerClassNames.length&&counter<12;i++){
            if(isContained(innerClassNames[i],start)) {
                foundedVariants[counter++]=innerClassNames[i];
            }
        }

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время поиска в отсортированном по дате массиву:"+endTime);
        return foundedVariants;
    }

    public String[] usingInnerClassGuess(String start){
        String[] foundedVariants=new String[12];
        long startTime=System.currentTimeMillis();

        int counter=0;
        for(int i=0;i<massivInnerClass.length&&counter<12;i++){
            if(isContained(massivInnerClass[i].nameOfClass,start)) {
                foundedVariants[counter++]=massivInnerClass[i].nameOfClass;
            }
        }

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время поиска в массиве объектов StringLong:"+endTime);
        return foundedVariants;
    }

    public boolean isContained(String string, String founded){
        if(string.length()>=founded.length()){
            if(string.substring(0,founded.length()).equals(founded)){
                return true;
            }
        }
        return false;
    }

    public class innerClass{
        String nameOfClass;
        long date;

        innerClass(String inp1, long inp2){
            this.nameOfClass=inp1;
            this.date=inp2;
        }

    }
}
