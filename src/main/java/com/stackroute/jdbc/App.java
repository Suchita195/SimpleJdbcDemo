package com.stackroute.jdbc;

public class App 
{
    public static void main( String[] args )
    {
        //Object for SimpleJdbcDemoClass
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        //To display the details
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("\n");
        //To display the details in reverse order
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println("\n");
        //To display the details in reverse from the second row
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("\n");
        //To display the detail by name and gender
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Nilakshi","female");
        System.out.println("\n");
        //To retrieve the metada about the database
        DatabaseMetadataDemo metadataDemo=new DatabaseMetadataDemo();
        metadataDemo.getDatabaseMetaData();
        System.out.println("\n");
        //To retrieve the metadata about the resultSet
        ResultSetMetadataDemo metadataDemo1=new ResultSetMetadataDemo();
        metadataDemo1.getResultSetMetaData();
        System.out.println("\n");
        //For RowSet
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.getRowSet();
        System.out.println("\n");
        //For batch processing
        JdbcBatchDemo batchDemo=new JdbcBatchDemo();
        batchDemo.getBatchDemo();
        //For transaction processing
        JdbcTransactionDemo transactionDemo=new JdbcTransactionDemo();
        transactionDemo.getTransactionDemo();
    }
}
