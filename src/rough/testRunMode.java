package rough;

import dd_core.TestCore;
import dd_util.Xls_Reader;

public class testRunMode extends TestCore {
	
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata.xls");
	
	public static boolean isExecutable(){
	
		
		for(int rowNum=2;rowNum<=excel.getRowCount("test_suite");rowNum++){
			
			if(excel.getCellData("test_suite", "tcid", rowNum).equals("LoginTest")){
				
				if(excel.getCellData("test_suite", "runmode", rowNum).equalsIgnoreCase("Y")){
					
					return true;
				}
				
				else{
					
					return false;
				}
			}
			
			
			
		}
		
		return false;
		
		
		
		
		
	}
	
	public static void main(String args[]){
		
		System.out.println(isExecutable());
	}

}
