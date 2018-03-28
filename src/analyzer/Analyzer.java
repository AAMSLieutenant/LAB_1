/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyzer;


import java.lang.reflect.*;
import filler.*;
import java.util.Arrays;
import java.util.Set;
import sorters.*;
import com.smartxls.*;
import java.awt.Color;

import org.reflections.*;
/**
 *
 * @author Stakhov
 */


/**
 * Class is created for analyzing the sorting sequence results
 * 
 */
public class Analyzer {
    
    private Class fillerClass;//Класс для заполнения массива
    private Class sorterClass;//Класс для сортировки
    private Sortable[] SorterObjectsArray;//Массив со всеми объектами-сортировщиками
    private Method[] fillerMethods;//Массив методов-заполнителей
    private int[] generatedArray;//Сгенерированный массив для сортировки
    private String[] simpleSorterClassesNames;//Массив имен классов-сортировщиков (для рефлексии)
    private long[][][] time;//"Кубический" массив для данных XLXS - по двумерной таблице на каждый из 4 листов
    public static final int NUMBER_1=10000;//Массив на 10000
    public static final int NUMBER_2=20000;//Массив на 20000
    public static final int NUMBER_3=30000;//Массив на 30000
    public static final int NUMBER_4=40000;//Массив на 40000
    
    
    public Analyzer(){
       time=new long[4][5][4]; 
       
    }
    
    /**
     * Method <code>analyze</code> is a main method,
     * which represents all information about the sorters
     */
    public void analyze(){
        
        getFillerMethods();
        getSorters();
        calculate(0);
        calculate(1);
        calculate(2);
        calculate(3);
        draw();
        
       
    }
    
    
    
    /**
     * Method calculates the time for all of the sorters
     * on all sequences by the number of the current filler method
     * @param fillerMethodIndex represents the current method for filling an array
     */
    private void calculate(int fillerMethodIndex){
        
        System.out.println("---|FILLER NUMBER "+fillerMethodIndex+"|---");
        System.out.println("---10000---");    
        generateArray(fillerMethods[fillerMethodIndex],NUMBER_1);
        for(int i=0;i<SorterObjectsArray.length;i++){
            time[fillerMethodIndex][i][0]=currentSort(i);
            //System.out.println("name:"+simpleSorterClassesNames[i]+": "+time[fillerMethodIndex][i][0]);
        }
        System.out.println("---20000---");
        generateArray(fillerMethods[fillerMethodIndex],NUMBER_2);
        for(int i=0;i<SorterObjectsArray.length;i++){
            time[fillerMethodIndex][i][1]=currentSort(i);
            //System.out.println("name:"+simpleSorterClassesNames[i]+": "+time[fillerMethodIndex][i][1]);
        }
        System.out.println("---30000---");
        generateArray(fillerMethods[fillerMethodIndex],NUMBER_3);
        for(int i=0;i<SorterObjectsArray.length;i++){
            time[fillerMethodIndex][i][2]=currentSort(i);
            //System.out.println("name:"+simpleSorterClassesNames[i]+": "+time[fillerMethodIndex][i][2]);
        }
        System.out.println("---40000---");
        generateArray(fillerMethods[fillerMethodIndex],NUMBER_4);
        for(int i=0;i<SorterObjectsArray.length;i++){
            time[fillerMethodIndex][i][3]=currentSort(i);
            //System.out.println("name:"+simpleSorterClassesNames[i]+": "+time[fillerMethodIndex][i][3]);
        }
        
    }
    
    /**
     * Method created an <code>.XLSX</code> file,
     * which represents duration of the sorters by each filler type
     */
    private void draw(){
        
        try{
            WorkBook m_book = new WorkBook();
            m_book.insertSheets(0, 3);
            m_book.setSheetName(0, "FILLER_1");
            m_book.setSheetName(1, "FILLER_2");
            m_book.setSheetName(2, "FILLER_3");
            m_book.setSheetName(3, "FILLER_4");

            for(int k=0;k<4;k++){

                m_book.setSheet(k);

                m_book.setColWidth(0, 25*256);

                m_book.setText(0, 0, "Сортировки");
                m_book.setNumber(0, 1, 10000);
                m_book.setNumber(0, 2, 20000);
                m_book.setNumber(0, 3, 30000);
                m_book.setNumber(0, 4, 40000);

                m_book.setText(1, 0, simpleSorterClassesNames[0]);
                m_book.setText(2, 0, simpleSorterClassesNames[1]);
                m_book.setText(3, 0, simpleSorterClassesNames[2]);
                m_book.setText(4, 0, simpleSorterClassesNames[3]);
                m_book.setText(5, 0, simpleSorterClassesNames[4]);

                for(int i=0;i<4;i++){
                    for(int j=0;j<5;j++){
                        m_book.setNumber(j+1,i+1, time[k][j][i]);
                    }
                }

                int left = 1;
                int top = 7;
                int right = 12;
                int bottom = 31;

                ChartShape chart = m_book.addChart(left, top, right, bottom);
                chart.setChartType(ChartShape.Line);
                chart.setLinkRange(m_book.getSheetName(k)+"!$A$2:$E$6", true);
                chart.setSeriesName(0, simpleSorterClassesNames[0]);
                chart.setSeriesName(1, simpleSorterClassesNames[1]);
                chart.setSeriesName(2, simpleSorterClassesNames[2]);
                chart.setSeriesName(3, simpleSorterClassesNames[3]);
                chart.setSeriesName(4, simpleSorterClassesNames[4]);
                ChartFormat chartFormat = chart.getPlotFormat();
                chartFormat.setSolid();
                chartFormat.setForeColor(Color.WHITE.getRGB());
                chart.setPlotFormat(chartFormat);
                String sortName=new String();
                if(k==0){sortName="(упорядоченный с конца массив)";}
                if(k==1){sortName="(упорядоченный с рандомным конечным элементом массив)";}
                if(k==2){sortName="(упорядоченный с начала массив)";}
                if(k==3){sortName="(рандомный массив)";}

                chart.setTitle("миллисекунды:"+sortName);
            }

            m_book.writeXLSX(".\\Stakhov.xlsx");
           
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    /**
     * Method retrieves all filler methods and puts them into <code>fillerMethods</code> array
     */
    private void getFillerMethods(){
        
        try{
                
            fillerClass=Class.forName("filler.Filler");
            fillerMethods=fillerClass.getMethods();
            System.out.println(Arrays.toString(fillerMethods));
        }
        catch(ClassNotFoundException cnfe){
            System.out.println(cnfe.toString());
        }
            
      
    }
    
    /**
     * Method generates an <code>int</code> array y thecurrent method
     * and current size
     * @param m current filler method
     * @param currentSize the length of the array 
     */
    private void generateArray(Method m, int currentSize){ 
        try{
       
            Object o=m.invoke(null, currentSize);
            generatedArray=(int[])o;
                //System.out.println(Arrays.toString(generatedArray));
        }
        catch(IllegalAccessException iae){
                System.out.println(iae.toString());
        }    
        catch(InvocationTargetException ite){
            System.out.println(ite.toString());
        }
       
        
    }
    
    /**
     * Method sorts an array by the sorting type
     * which is chosen by an <code>int</code> argument
     * @param pos the index of object in array, which represents the sorting algorithm
     * @return duretion of the sorting  in <code>long<code>
     */
    private long currentSort(int pos){
        
        long nanoTime=0;
        try{
            
            int[] tempArray=Arrays.copyOf(generatedArray, generatedArray.length);

            Method m=Class.forName("sorters."+simpleSorterClassesNames[pos]).getMethod("sort", int[].class);
            System.out.println(simpleSorterClassesNames[pos]);

            long start=System.nanoTime();
            Object o=m.invoke(SorterObjectsArray[pos], tempArray);
            nanoTime=(System.nanoTime()-start)/1000;
            System.out.println(Arrays.toString(generatedArray));
            
        }
        catch(IllegalAccessException iae){
            System.out.println(iae.toString());
        }
        catch(NoSuchMethodException nsme){
            System.out.println(nsme.toString());
        }
        catch(IllegalArgumentException iae){
            System.out.println(iae.toString());
        }
        catch(InvocationTargetException ite){
            System.out.println(ite.toString());
        }
        catch(ClassNotFoundException cnfe){
            System.out.println(cnfe.toString());
        }
        return nanoTime;
    }
    
    /**
     * Method creates an array of the <code>Sortable</code> class heirs,
     * each of them represents a sorting algorithm
     */
    private void getSorters(){
       
       
        //Sortable s;
        try{
            Reflections reflections = new Reflections("sorters");
            Set<Class<? extends Sortable>> classes = reflections.getSubTypesOf(Sortable.class);
            //System.out.println(classes.);
            int i=0;
            String str=new String();
            SorterObjectsArray=new Sortable[classes.size()];
            simpleSorterClassesNames=new String[classes.size()];
            for (Class<? extends Sortable> cl : classes) {

                sorterClass=Class.forName(cl.getCanonicalName());
                SorterObjectsArray[i]=(Sortable)sorterClass.newInstance();

                simpleSorterClassesNames[i]=cl.getSimpleName();
                //Массив на 20000System.out.println(cl.getCanonicalName());
                i++;
                //System.out.println(sorterClass.getSimpleName());
                //str=cl.toString();
            }
        }
        catch(ClassNotFoundException cnfe){
            System.out.println(cnfe.toString());
        }
        catch(InstantiationException ie){
            System.out.println(ie.toString());
        }
        catch(IllegalAccessException iae){
            System.out.println(iae.toString());
        }
        
    }
    
}
