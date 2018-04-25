public class ExpressionTree{
    public String toString(){
	String fin = "";
	fin += add(this);
	return fin;
    }
    public String add(ExpressionTree cur){
	if(cur.isValue()){
	    return "" + cur.getValue();
	}
	return "(" + add(cur.getLeft()) + cur.getOp() + add(cur.getRight()) + ")";
    }
    
    public String toStringPostfix(){
	String fin = "";
	fin += add2(this);
	return fin;
    }
    public String add2(ExpressionTree cur){
	if(cur.isValue()){
	    return "" + cur.getValue();
	}
	return add2(cur.getLeft()) + " " + add2(cur.getRight()) + " " + cur.getOp();
    }
    
    public String toStringPrefix(){
	String fin = "";
	fin += add3(this);
	return fin;
    }
    public String add3(ExpressionTree cur){
	if(cur.isValue()){
	    return "" + cur.getValue();
	}
	return cur.getOp() + " " + add3(cur.getLeft()) + " " + add3(cur.getRight());
    }
    
    public double evaluate(){
	if(this.isValue()){
	    return this.getValue();
	}
	return apply(this.getOp(),this.getLeft().evaluate(),this.getRight().evaluate());
    }
    private double apply(char op,double a,double b){
	if(op == '+'){
	    return a + b;
	}
	if(op == '-'){
	    return a - b;
	}
	if(op == '*'){
	    return a * b;
	}
	if(op == '/'){
	    return a / b;
	}
	if(op == '%'){
	    return a % b;
	}
	return 0.0;
    }
    
    private char op;
    private double value;
    private ExpressionTree left,right;
    
    public ExpressionTree(double value){
	this.value = value;
	op = '~';
    }
    public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
	this.op = op;
	left = l;
	right = r;
    }
  
    public char getOp(){
	return op;
    }
  
    private double getValue(){
	return value;
    }
    private ExpressionTree getLeft(){
	return left;
    }
    private ExpressionTree getRight(){
	return right;
    }
  
    private boolean isOp(){
	return hasChildren();
    }
    private boolean isValue(){
	return !hasChildren();
    }
  
    private boolean hasChildren(){
	return left != null && right != null;
    }
    public static void main(String[] args){
    ExpressionTree a = new ExpressionTree(4.0);
    ExpressionTree b = new ExpressionTree(2.0);

    ExpressionTree c = new ExpressionTree('+',a,b);
    System.out.println(c);
    System.out.println(c.toStringPostfix());
    System.out.println(c.toStringPrefix());
    System.out.println(c.evaluate());//6.0

    ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
    System.out.println(d);
    System.out.println(d.toStringPostfix());
    System.out.println(d.toStringPrefix());
    System.out.println(d.evaluate());//21

    ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//20

    ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//21

    ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//10.5   
  }
}
