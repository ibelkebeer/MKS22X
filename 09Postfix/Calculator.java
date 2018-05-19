import java.util.*;
public class Calculator{
    public static double eval(String data){
	Stack<Double> a = new Stack<>();
	String num = "";
	if(data.indexOf(" ") == -1){
	    return Double.parseDouble(data);
	}
	for(int x=0; x<data.length(); x++){
	    char cur = data.charAt(x);
	    if(cur == ' ' && num != ""){
		a.push(Double.parseDouble(num));
		num = "";
	    }else if(cur == '+'){
		a.push(a.pop() + a.pop());
		x++;
	    }else if(cur == '-'){
		double temp = a.pop();
		a.push(a.pop() - temp);
		x++;
	    }else if(cur == '*'){
		a.push(a.pop() * a.pop());
		x++;
	    }else if(cur == '/'){
		double temp = a.pop();
		a.push(a.pop() / temp);
		x++;
	    }else if(cur == '%'){
		double temp = a.pop();
		a.push(a.pop() % temp);
		x++;
	    }else{
		num += cur;
	    }
	}
	if(!num.equals("")){
	    return Double.parseDouble(data);
	}
	return a.pop();
    }
}
