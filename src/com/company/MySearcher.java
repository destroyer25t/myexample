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
    HashMap<String, Long> hashMapClasses;


    @Override
    public void refresh(String[] classNames, long[] modificationDates) {
        int lenghtOfClassNames=classNames.length;
        long startTime=System.currentTimeMillis();

        hashMapClasses=new HashMap<>(lenghtOfClassNames);
        innerClassNames = classNames;

        for(int i=0;i<lenghtOfClassNames;i++){
            hashMapClasses.put(classNames[i],modificationDates[i]);
        }

        Arrays.sort(classNames);

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время создания HashMap:"+endTime);
    }

    @Override
    public String[] guess(String start) {
        String[] foundedVariants=new String[12];

        return new String[0];
    }

    public String[] lazyGuess(String start){
        String[] foundedVariants=new String[12];
        long startTime=System.currentTimeMillis();

        int counter=0;
        for(int i=0;i<innerClassNames.length&&counter<12;i++){
            if(isContained(innerClassNames[i],start)) {
                foundedVariants[counter++]=innerClassNames[i];
            }
        }

        long endTime=System.currentTimeMillis()-startTime;
        System.out.println("Время полного прогона с поиском:"+endTime);
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

    }
}
