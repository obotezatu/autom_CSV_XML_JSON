package com.alliedtesting.automation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Create CSV with OpenCSV " );
        CreateCSV.openCSVWriteData("./src/main/resources/students.csv");
    }
}
