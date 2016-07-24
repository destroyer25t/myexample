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
        return new String[0];
    }

    class innerClass{
        String innerClassName;
        long innerClassModificationDate;
    }
}
