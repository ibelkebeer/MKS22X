import java.util.*;
public class Calculator{
    public static double eval(String data){
	LinkedList<Double> a = new LinkedList<>();
	String num = "";
	for(int x=0; x<data.length(); x++){
	    char cur = data.charAt(x);
	    if(cur == ' '){
		a.add(Double.parseDouble(num));
		num = "";
	    }else if(cur == '+'){
		a.add(a.removeLast() + a.removeLast());
		x++;
	    }else if(cur == '-'){
		double temp = a.removeLast();
		a.add(a.removeLast() - temp);
		x++;
	    }else if(cur == '*'){
		a.add(a.removeLast() * a.removeLast());
		x++;
	    }else if(cur == '/'){
		double temp = a.removeLast();
		a.add(a.removeLast() / temp);
		x++;
	    }else if(cur == '%'){
		double temp = a.removeLast();
		a.add(a.removeLast() % temp);
		x++;
	    }else{
		num += cur;
	    }
	}
	if(!num.equals("")){
	    return Double.parseDouble(data);
	}
	return a.get(0);
    }
}
