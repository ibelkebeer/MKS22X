public class Recursion{
    public int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }
    public int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	if(n<=2){
	    return 1;
	}
	return fibHelp(n,3,1,1);
    }
    public int fibHelp(int n, int next, int sum, int last){
	int tempLast = sum;
	sum += last;
	last = tempLast;
	if(next == n){
	    return sum;
	}
	return fibHelp(n, next+1, sum, last);
    }
    public double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	return sqrtHelp(n, n/2);
    }
    public double sqrtHelp(double n, double g){
	double percentError = ((g*g)-n)/n*100;
	if(percentError < 0.0000001 && percentError > -0.0000001){
	    return g;
	}
	return sqrtHelp(n,(n/g + g) / 2);
    }	
}
