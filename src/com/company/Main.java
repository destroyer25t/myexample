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

    public static void definitedClassNames(){
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
        massiv=mySearcher.usingInnerClassGuess("00a");


        for(String string:massiv){
            System.out.println(string);
        }
    }
}
