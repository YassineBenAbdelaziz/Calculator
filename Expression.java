import java.util.StringTokenizer;
import java.util.ArrayList;


public class Expression {
    

    private StringTokenizer st;

    public Expression(String s){
        st = new StringTokenizer(s,"+*-/()",true);
    }

    public String Resoudre() throws NumberFormatException{
        ArrayList<String> arr = new ArrayList<String>();
        String token,temp ;

        while(st.hasMoreTokens()){
             token = st.nextToken();

            switch (token) {
                case "(":
                    // Evaluate expression in parentheses
                    arr.add(Resoudre());
                    break;
                case ")":
                    // End of expression, return value
                    return Calculer_Array(arr);
                case "-":
                    temp = st.nextToken();
                    if (temp.equals("(")) {
                        arr.add("-1");                  
                        arr.add("*");
                        arr.add(Resoudre());
                    } else {
                        arr.add("-" + temp);        
                    }
                    break;
                default:
                    arr.add(token);             // Constant or + or * or /
                    break;
            }
        }
        return Calculer_Array(arr);
    }

    private  String Calculer_Array(ArrayList<String> arr){
        int i ;
        
        // Division 
        for (i=0;i < arr.size();i++){
            if (arr.get(i).equals("/")){
                arr.set(i-1,Double.toString(Double.parseDouble(arr.get(i-1) )/ Double.parseDouble(arr.get(i+1))));
                arr.remove(i+1);
                arr.remove(i);
                i--;
            }
        }
        // Multiplication
        for (i=0;i < arr.size();i++){            
            if (arr.get(i).equals("*")){
                arr.set(i-1,Double.toString(Double.parseDouble(arr.get(i-1) )* Double.parseDouble(arr.get(i+1))));
                arr.remove(i+1);
                arr.remove(i);
                i--;
            }
            
        }

        // Addition
        for (i=0;i < arr.size();i++){
            if (arr.get(i).equals("+")){
                arr.set(i-1,Double.toString(Double.parseDouble(arr.get(i-1) )+ Double.parseDouble(arr.get(i+1))));
                arr.remove(i+1);
                arr.remove(i);
                i--;
            }
        }

        // Sustraction 
        while (arr.size()>1) {
                arr.set(0,Double.toString(Double.parseDouble(arr.get(0) ) + Double.parseDouble(arr.get(1))));
                arr.remove(1);
        }

        if(arr.get(0).equals(".") || arr.get(0).equals("-.") ) {
            throw new NumberFormatException("invalid floating point number") ;
        }
        else {
            return arr.get(0);
        }
        
    }


}
