package cn.lingjian_1;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lingjian
 * @date 2019/10/24 - 3:02 下午
 */
public class ReadExecl {
    public static void main(String[] args) throws IOException, BiffException {
        File file=new File("/Users/lingjian/Desktop/execl.xls");
        InputStream is=new FileInputStream(file);
        Workbook workbook=Workbook.getWorkbook(is);
        Sheet sheet=workbook.getSheet(0);
        Cell c00=sheet.getCell(0,0);
        String str00=c00.getContents();
        System.out.println(str00);

    }
}
