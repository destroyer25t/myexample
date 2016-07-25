package com.company;

import org.junit.Assert;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Олег on 25.07.2016.
 */
public class MySearcherTest {
    //нужные для тестирования
    static String[] classnames;
    static long[] classdates;
    MySearcher.innerClass[] massivInnerClass;
    MySearcher mySearcher = new MySearcher();

    //верные результаты
    String testStringMassiv[]={"KAAIONNO","KAOIONNA","KAFAJD"};
    MySearcher.innerClass[] testInnerClass;

    @org.junit.Before
    public void setUp() throws Exception {
        massivInnerClass=new MySearcher.innerClass[16];
        testInnerClass=new MySearcher.innerClass[16];

        classnames[0]="ABCDE";
        classnames[1]="OKILE";
        classnames[2]="KAFAJD";
        classnames[3]="ADURKJ";
        classnames[4]="OANME";
        classnames[5]="KAOIONNA";
        classnames[6]="BAYYTOR";
        classnames[7]="PEQSCQS";
        classnames[8]="TYRYEAS";
        classnames[9]="MEQWQS";
        classnames[10]="VMCXZNN";
        classnames[11]="IIRKWQDC1";
        classnames[12]="TDADSDS2DA";
        classnames[13]="PRCNXNV51";
        classnames[14]="2FKKFS";
        classnames[15]="KAAIONNO";

        classdates[0]=1000000000;
        classdates[1]=78410;
        classdates[2]=120003000;
        classdates[3]=56732133;
        classdates[4]=763214;
        classdates[5]=8428219;
        classdates[6]=990009122;
        classdates[7]=23146221;
        classdates[8]=281482818;
        classdates[9]=9812;
        classdates[10]=1100;
        classdates[11]=158272147;
        classdates[12]=24124124;
        classdates[13]=2184821;
        classdates[14]=2521;
        classdates[15]=8428219;

        int[] rightOrder={10,14,9,11,4,13,15,5,7,12,3,2,11,8,6,0};
        for(Integer integer:rightOrder){
            testInnerClass[integer]=new MySearcher.innerClass(classnames[integer],classdates[integer]);
        }


    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void refresh() throws Exception {
        mySearcher.refresh(classnames,classdates);
        Assert.assertArrayEquals( testInnerClass, massivInnerClass );
    }

    @org.junit.Test
    public void usingInnerClassGuess() throws Exception {
        mySearcher.refresh(classnames,classdates);
        String[] massiv=mySearcher.usingInnerClassGuess("KA");
        assertTrue(Arrays.equals( testStringMassiv, massiv ));
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void uncorrectedRefresh() {
        long[] longs = new long[2];
        mySearcher.refresh(classnames,longs);
    }

}