package BankSystems;

public class InputProcesser {

	public InputProcesser() {
		// TODO Auto-generated constructor stub
	}
	static boolean isNumber(String str) {
		if (str == null || str.equals(""))
			return false;
	    char tempCh;
	    int dotCount = 0;	
	    boolean result = true;

	    for (int i=0; i<str.length(); i++){
	      tempCh= str.charAt(i);
	      if ((int)tempCh < 48 || (int)tempCh > 57){
	        if(tempCh!='.' || dotCount > 0){
	          result = false;
	          break;
	        }else{
	          dotCount++;
	        }
	      }
	    }
	    return result;
	  }
	static boolean isInt(String str) {
		if (str == null || str.equals("")) 
			return false;
	    char tempCh;

	    for (int i=0; i<str.length(); i++){
	      tempCh= str.charAt(i);
	      if ((int)tempCh < 48 || (int)tempCh > 57){
	         return false;
	      }
	    }
	    return true;
	  }
	static boolean isString(String str) {
		if (str == null || str.equals("")) 
			return false;
		char tmp;
		for (int i=0; i<str.length(); i++){
		      tmp= str.charAt(i);
		      if ( (int)tmp < 65 || ((int)tmp>90&&(int)tmp<97))
		          return false;
		      
		   }
		return true;
		
	}
}
