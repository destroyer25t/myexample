package com.company;

import java.util.HashMap;

/**
 * Created by tailer_d on 23.07.2016.
 */
public class MySearcher implements ISearcher {


    @Override
    public void refresh(String[] classNames, long[] modificationDates) {

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
