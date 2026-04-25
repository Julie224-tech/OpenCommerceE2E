package utilities;
import org.testng.annotations.DataProvider;

public class DataClass {

    @DataProvider(name ="excelData")
    public Object[][] getData() throws Exception 
    {
        String path ="C:\\Users\\JULIELAMA\\Downloads\\ddt.xlsx";
        return ExcelUtil.getTestData(path, "Sheet1");
    }
}
   /* @DataProvider(name ="contactdata")
    public Object[][] contactdata() 
    {
        return new Object[][] 
        {
            {"Admin", "admin123"}
            
        }   ;       
    }
}*/
