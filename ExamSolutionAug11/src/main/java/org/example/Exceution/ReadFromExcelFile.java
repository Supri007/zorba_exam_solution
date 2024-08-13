package org.example.Exceution;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.Entity.Employee;
import org.example.Entity.EmployeeSkill;
import org.example.Entity.Skill;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadFromExcelFile {
    public static void main(String[] args) throws Exception{
        File file = new File("src/main/resources/Exam_info.xlsx");
        //Convert file to Binary Stream data
        FileInputStream fileInputStream = new FileInputStream(file);

        //Create workbook object
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        int noOfSheet = xssfWorkbook.getNumberOfSheets();
        System.out.println(noOfSheet);

        //Read sheet to get data and create employee object
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        int noOfRows = xssfSheet.getLastRowNum();
        System.out.println("Number Of Rows Present : "+ noOfRows);
        Employee[] employeeArr = new Employee[noOfRows-1];
        Iterator<Row> rowIterator = xssfSheet.iterator();
        int i = 1;
        while (rowIterator.hasNext()) {
            if (i >= noOfRows - 1) {
                break;
            }
            Row row = xssfSheet.getRow(i); //rowIterator.next();
            System.out.println("Row Number :: "+ row.getRowNum());
            int noOfCell = row.getLastCellNum();
            Iterator<Cell> cellIterator = row.iterator();
            Employee employee = new Employee();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int posOfCell = cell.getColumnIndex();
                String cellType = cell.getCellType().name();
                switch(posOfCell){
                    case 0:
                        employee.employeeId = (int) cell.getNumericCellValue();
                        break;
                    case 1:
                        employee.employeeName = cell.getStringCellValue();
                        break;
                    case 2:
                        employee.employeeAddress = cell.getStringCellValue();
                        break;
                    case 3:
                        employee.employeeEmail = cell.getStringCellValue();
                        break;
                    case 4:
                        employee.employeeExperience = (int) cell.getNumericCellValue();
                        break;
                }
            }
            employeeArr[i] = employee;
            i++;
        }
        System.out.println(employeeArr[1].employeeName);
        for (int arr = 0; arr < employeeArr.length; arr++){
            UploadDataToDB.UploadData(employeeArr[arr]);
        }


        //Read sheet to get data and create skill object
        XSSFSheet xssfSheet1 = xssfWorkbook.getSheetAt(1);
        int noOfRowsSkill = xssfSheet.getLastRowNum();
        System.out.println("Number Of Rows Present : "+ noOfRows);
        Skill[] skillArr = new Skill[noOfRows-1];
        Iterator<Row> rowIteratorskill = xssfSheet.iterator();
        int j = 1;
        while (rowIteratorskill.hasNext()) {
            if (j >= noOfRowsSkill - 1) {
                break;
            }
            Row row = xssfSheet1.getRow(j);
            System.out.println("Row Number :: "+ row.getRowNum());
            int noOfCell = row.getLastCellNum();
            Iterator<Cell> cellIterator = row.iterator();
            Skill skill = new Skill();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int posOfCell = cell.getColumnIndex();
                String cellType = cell.getCellType().name();
                switch(posOfCell){
                    case 0:
                        skill.skillId = (int) cell.getNumericCellValue();
                        break;
                    case 1:
                        skill.skillName = cell.getStringCellValue();
                        break;
                }
            }
            skillArr[j] = skill;
            j++;
        }

        System.out.println(employeeArr[1].toString());
        for (int arr = 0; arr < skillArr.length; arr++){
            UploadDataToDB.UploadData(skillArr[arr]);
        }

        //Read sheet to get data and create employeeSkill object
        XSSFSheet xssfSheet2 = xssfWorkbook.getSheetAt(2);
        int noOfRowsEmpSkill = xssfSheet.getLastRowNum();
        System.out.println("Number Of Rows Present : "+ noOfRows);
        EmployeeSkill[] empSkillArr = new EmployeeSkill[noOfRows-1];
        Iterator<Row> rowIteratorEmpSkill = xssfSheet.iterator();
        int k = 1;
        while (rowIteratorEmpSkill.hasNext()) {
            if (k >= noOfRowsEmpSkill - 1) {
                break;
            }
            Row row = xssfSheet2.getRow(k);
            System.out.println("Row Number :: "+ row.getRowNum());
            int noOfCell = row.getLastCellNum();
            Iterator<Cell> cellIterator = row.iterator();
            EmployeeSkill empSkill = new EmployeeSkill();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int posOfCell = cell.getColumnIndex();
                String cellType = cell.getCellType().name();
                switch(posOfCell){
                    case 0:
                        empSkill.employeeId = (int) cell.getNumericCellValue();
                        break;
                    case 1:
                        empSkill.skillId = (int) cell.getNumericCellValue();
                        break;
                }
            }
            empSkillArr[k] = empSkill;
            k++;
        }
    }
}
