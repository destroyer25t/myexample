package com.company;

import java.util.*;

/**
 * Created by tailer_d on 23.07.2016.
 */
public class MySearcher implements ISearcher {

    innerClass[] massivInnerClass;


    @Override
    public void refresh(String[] classNames, long[] modificationDates) {
        try {
            if ((classNames.length == modificationDates.length) || (classNames.length > 0)) {
                int lenghtOfClassNames = classNames.length;
                long startTime = System.currentTimeMillis();

                massivInnerClass = new innerClass[lenghtOfClassNames];

                for (int i = 0; i < lenghtOfClassNames; i++) {
                    innerClass iC = new innerClass(classNames[i], modificationDates[i]);
                    massivInnerClass[i] = iC;
                }
                NodeDjkstraComparator comparator = new NodeDjkstraComparator();
                Arrays.sort(massivInnerClass, comparator);

                long endTime = System.currentTimeMillis() - startTime;
                System.out.println("Время создания массива объектов:" + endTime);
            } else {
                throw new IllegalArgumentException("Lenghts of arrays is not equal or length less than 1");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String[] guess(String start) {
        if (start == null || start.length() < 1 || start.length() > 32) {
            return new String[]{"Classes not found"};
        }

        LinkedList<String> lnkd=new LinkedList<>();

        String[] foundedVariants;
        long startTime = System.currentTimeMillis();

        int counter = 0;
        for (int i = 0; i < massivInnerClass.length && counter < 12; i++) {
            if (isContained(massivInnerClass[i].nameOfClass, start)) {
                lnkd.add(massivInnerClass[i].nameOfClass);
            }
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Время поиска в массиве объектов StringLong:" + endTime);
        if (lnkd.size() < 1) {
            return new String[]{"Classes not found"};
        }
        else{
            foundedVariants=new String[lnkd.size()];
            foundedVariants=lnkd.toArray(foundedVariants);
        }
        return foundedVariants;
    }

    public String[] usingInnerClassGuess(String start) {
        if (start == null || start.length() < 1 || start.length() > 32) {
            return new String[]{"Classes not found"};
        }

        String[] foundedVariants = new String[12];
        long startTime = System.currentTimeMillis();

        int counter = 0;
        for (int i = 0; i < massivInnerClass.length && counter < 12; i++) {
            if (isContained(massivInnerClass[i].nameOfClass, start)) {
                foundedVariants[counter++] = massivInnerClass[i].nameOfClass;
            }
        }

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Время поиска в массиве объектов StringLong:" + endTime);
        if (foundedVariants.length < 1) {
            return new String[]{"Classes not found"};
        }
        return foundedVariants;
    }

    public boolean isContained(String string, String founded) {
        if (string.length() >= founded.length()) {
            if (string.substring(0, founded.length()).equals(founded)) {
                return true;
            }
        }
        return false;
    }

    public static class innerClass {
        String nameOfClass;
        long date;

        innerClass(String inp1, long inp2) {
            this.nameOfClass = inp1;
            this.date = inp2;
        }

    }

    class NodeDjkstraComparator implements Comparator<innerClass> {
        @Override
        public int compare(innerClass o1, innerClass o2) {
            int result;
            result = Long.compare(o1.date, o2.date);
            if (result == 0) {
                result = o1.nameOfClass.compareTo(o2.nameOfClass);
            }
            return result;
        }
    }
}
