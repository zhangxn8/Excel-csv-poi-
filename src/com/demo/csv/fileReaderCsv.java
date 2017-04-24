package com.demo.csv;

import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;  
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;  
import java.util.List;  

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/*import com.csvreader.CsvReader;
import com.opencsv.CSVReader;*/

/*import com.csvreader.CsvReader;*/

  
  
public class fileReaderCsv {  
    /** 
     * 读csv格式. 
     * 开源jar包有opencsv， javacsv, csvObjects(可以装换成对象)，csv, csvjdbc等. 此处用javacsv 
     * @param dir 
     * @return 
     */  
   /* public static List<EmgDzdpMapping> readCsvFile(String dir) {  
        List<EmgDzdpMapping> list  = new ArrayList<EmgDzdpMapping>();  
        List<File> files = getFile(dir);  
        CsvReader reader = null;  
        ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据    
        try {  
            for (File file : files) {  
                if (!file.getName().contains("xls"))  
                    continue;  
                  
                reader = new CsvReader(file.getAbsolutePath(),',',Charset.forName("GBK"));  
                FileReader fReader = new FileReader(file);  
                CsvReader csvReader = new CsvReader(fReader);  
                 //一般用这编码读就可以了   
                csvReader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。  
                 while(csvReader.readRecord()){ //逐行读入除表头的数据      
                     csvList.add(csvReader.getValues());  
                 }              
                 csvReader.close();  
                   
                 for(int row=0;row<csvList.size();row++){  
                     for(int colum = 0; colum<csvList.get(row).length; colum++){  
                         System.out.println(csvList.get(row)[colum]);//取得第row行第colum列的数据  
                     }  
                 }  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch(Exception e) {  
            e.printStackTrace();  
        }  finally {  
            if(reader != null) {  
                reader.close();  
            }  
        }  
        return null;  
    }  */
      
    /** 
     * 不使用递归,遍历文件夹.速度没有递归效果快 
     */  
    private static List<File> getFile(String rootDir) {  
        List<File> files = new ArrayList<File>();  
        LinkedList<File> list = new LinkedList<File>();  
        File dir = new File(rootDir);  
        File file[] = dir.listFiles();  
        for (int i = 0; i < file.length; i++) {  
            if (file[i].isDirectory()) {  
                list.add(file[i]);  
            } else {  
                // System.out.println(file[i].getAbsolutePath());  
                files.add(file[i]);  
            }  
        }  
  
        File tmp;  
        while (!list.isEmpty()) {  
            tmp = list.removeFirst();// 循环操作，删除元素。  
            if (tmp.isDirectory()) {  
                file = tmp.listFiles();  
                if (file == null)  
                    continue;  
                for (int i = 0; i < file.length; i++) {  
                    if (file[i].isDirectory()) {  
                        list.add(file[i]);  
                    } else {  
                        // System.out.println(file[i].getAbsolutePath());  
                        files.add(file[i]);  
                    }  
                }  
            } else {  
                // System.out.println(tmp.getAbsolutePath());  
                files.add(tmp);  
            }  
        }  
        return files;  
    }  
      
    /** 
     * jxl读excel格式. 
     * poi, jxl, jxls等。 
     * jxl是一个韩国人写的java操作excel的工具, 在开源世界中，有两套比较有影响的API可供使用，一个是POI，一个是jExcelAPI。其中功能相对POI比较弱一点。但jExcelAPI对中文支持非常好，API是纯Java的， 并不依赖Windows系统，即使运行在Linux下，它同样能够正确的处理Excel文件。 另外需要说明的是，这套API对图形和图表的支持很有限，而且仅仅识别PNG格式 
     * @param dir 
     * @return 
     * @throws IOException 
     */  
    public static List<ImportStock> readExcelFile(String dir) throws IOException {  
    	List<ImportStock> list = new ArrayList<ImportStock>();
        Workbook book = null;  
      //  List<File> files = getFile(dir);  
       /* try {  
            for (File file : files) {  
                if (!file.getName().contains("xls"))  
                    continue;  
                book = Workbook.getWorkbook(file);  
                // 获得第一个工作表对象,暂时只处理一个sheet.  
                Sheet sheet = book.getSheet(0);  
                int columnum = sheet.g; // 得到列数  
                int rownum = sheet.getRows(); // 得到行数  
                System.out.println(columnum);  
                System.out.println(rownum);  
                for (int i = 0; i < rownum; i++) // 循环进行读写  
                {  
                    for (int j = 0; j < columnum; j++) {  
                        Cell cell1 = sheet.getCell(j, i);  
                        String result = cell1.getContents();  
                        System.out.print(result);  
                        System.out.print(" \t ");  
                    }  
                    System.out.println();  
                }  
            }  
        }
        catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (book != null) {  
                book.close();  
            }  
        }  
  
        return null;  
    }*/
    	List<File> files = getFile(dir);  
         for (File file : files) {  
              if (!file.getName().contains("xls"))  
                     continue;  
                 
    
        //InputStream file1=null;
		InputStream file2=new FileInputStream(file);
		//file1 =new InputStream(file2);
	    //file1=file.getInputStream();
        //XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		System.out.print("--172--");
		XSSFWorkbook workbook=new XSSFWorkbook(file2);	
	   
	    for(int i=0;i<workbook.getNumberOfSheets();i++){
	       XSSFSheet sheet=workbook.getSheetAt(i);
	       String exchangeNo=null;
	       String name=sheet.getSheetName();
	       if(name.equals("上海")){
	    	   exchangeNo="1";
	       }else{
	    	   exchangeNo="2";
	       }
	       int rowNum=sheet.getLastRowNum();
	     //判断文件的格式表头是否正确
	       XSSFRow rowLine=sheet.getRow(0);
	       
	       rowLine.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
	       String s="A股上市日期";
	       System.out.println(rowLine.getCell(2).getStringCellValue());
	    	   if((String.valueOf(rowLine.getCell(2).getStringCellValue())).equals(s)){
	    		   System.out.println("8885文件格式错误");
	    	   };
	    	   rowLine.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
	    	   if(rowLine.getCell(0).getStringCellValue().equals("A股代码")){
	    		   System.out.println("8885文件格式错误");
	    	   };
	    	   rowLine.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
	    	   if(rowLine.getCell(3).getStringCellValue().equals("A股总股本(股)")){
	    		   System.out.println("8885文件格式错误");
	    	   };
	    	   rowLine.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
	    	   if(rowLine.getCell(4).getStringCellValue().equals("A股流通股本(股)")){
	    		   System.out.println("8885文件格式错误");
	    	   };
	       for(int j=1;j<rowNum;j++){ 
	    	   ImportStock stock=new ImportStock();
	    	   XSSFRow row=sheet.getRow(j);
	    	   
	    	   Calendar cal = Calendar.getInstance();
	           Date date = cal.getTime();
	           String t1 = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date);
	           
	           System.out.println(t1);
	          
	    	   System.out.println("开始1："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
	    	   long d1=System.nanoTime();
	    	   row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
	    	   stock.setBegin_trade_date(Integer.parseInt(row.getCell(2).getStringCellValue()));
	    	   System.out.println("开始1耗时:"+(System.nanoTime()-d1));
	    	
	    	   
	    	   System.out.println("开始2："+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
	    	   long d2=System.nanoTime();
	    	   if(Cell.CELL_TYPE_STRING==rowLine.getCell(2).getCellType()){
	    		   stock.setStock_code(row.getCell(2).getStringCellValue());
		       }else if(Cell.CELL_TYPE_STRING==rowLine.getCell(2).getCellType()){
		    	   stock.setStock_code(row.getCell(2).getStringCellValue());
		       }else{
		    	   System.out.print("--输出错误229--");
		       }
	    	   System.out.println("开始2耗时:"+(System.nanoTime()-d2));
	    	   System.out.println("结束2:"+new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS").format(date));
	    	   
	    	   row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
	    	   stock.setStock_code(row.getCell(0).getStringCellValue());
	    	   row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
	    	   stock.setTotal_stock_issue(new BigDecimal(row.getCell(3).getStringCellValue()));
	    	   row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
	    	   stock.setCirculation_stock_capital(new BigDecimal(row.getCell(4).getStringCellValue()));
	    	   stock.setExchange_no(exchangeNo);
	    	   System.out.println(j);
	    	   list.add(stock);
				
	          }
	       }
	   
         }
        
         return list;
    }  
  
  
    public static void main(String[] args) throws IOException {  
    	//readCsvFile("E:\\excel\\"); 
    	
    	
    	System.out.println("--209--");
         readExcelFile("E:\\excel\\");  
      // System.out.println(getFile("F:\\11_maintenance\\问题\\20120104_02\\dfyl111230").size());;  
    	
       
    }  
}  
class ImportStock{
	
	private String stock_code;
	private String  exchange_no;
	private BigDecimal total_stock_issue;
	private Integer begin_trade_date;
	private BigDecimal circulation_stock_capital;
	
	public String getStock_code() {
		return stock_code;
	}
	public void setStock_code(String stock_code) {
		this.stock_code = stock_code;
	}
	
	public String getExchange_no() {
		return exchange_no;
	}
	public void setExchange_no(String exchange_no) {
		this.exchange_no = exchange_no;
	}
	public BigDecimal getTotal_stock_issue() {
		return total_stock_issue;
	}
	public void setTotal_stock_issue(BigDecimal total_stock_issue) {
		this.total_stock_issue = total_stock_issue;
	}
	public Integer getBegin_trade_date() {
		return begin_trade_date;
	}
	public void setBegin_trade_date(Integer begin_trade_date) {
		this.begin_trade_date = begin_trade_date;
	}
	public BigDecimal getCirculation_stock_capital() {
		return circulation_stock_capital;
	}
	public void setCirculation_stock_capital(BigDecimal circulation_stock_capital) {
		this.circulation_stock_capital = circulation_stock_capital;
	}
	
	
	
	
	
}
class EmgDzdpMapping {  
    
    public String richpoisrc;  
    public String   richpoiid;  
    public String emgpoiid;  
    public String emgversion;  
    public String update;  
    /**A:代表add新增*/  
    public String deltatyp;  
      
      
    public EmgDzdpMapping(String richpoisrc, String richpoiid, String emgpoiid,  
            String emgversion, String update, String deltatyp) {  
        super();  
        this.richpoisrc = richpoisrc;  
        this.richpoiid = richpoiid;  
        this.emgpoiid = emgpoiid;  
        this.emgversion = emgversion;  
        this.update = update;  
        this.deltatyp = deltatyp;  
    }  
      
    public String getRichpoisrc() {  
        return richpoisrc;  
    }  
    public void setRichpoisrc(String richpoisrc) {  
        this.richpoisrc = richpoisrc;  
    }  
    public String getRichpoiid() {  
        return richpoiid;  
    }  
    public void setRichpoiid(String richpoiid) {  
        this.richpoiid = richpoiid;  
    }  
    public String getEmgpoiid() {  
        return emgpoiid;  
    }  
    public void setEmgpoiid(String emgpoiid) {  
        this.emgpoiid = emgpoiid;  
    }  
    public String getEmgversion() {  
        return emgversion;  
    }  
    public void setEmgversion(String emgversion) {  
        this.emgversion = emgversion;  
    }  
    public String getUpdate() {  
        return update;  
    }  
    public void setUpdate(String update) {  
        this.update = update;  
    }  
    public String getDeltatyp() {  
        return deltatyp;  
    }  
    public void setDeltatyp(String deltatyp) {  
        this.deltatyp = deltatyp;  
    }  
      
      
}  