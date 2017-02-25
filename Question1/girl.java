public class girl {
	
	String name;
	int attract;
	int expense;
	int intellect;
	String status;
	String bf ;
	
	girl(String name,int attract,int expense,int intellect,String status){
		this.name = name;
		this.attract = attract;
		this.expense = expense;
		this.intellect = intellect;
		this.status = status;
		this.bf = "";
		
	}
	boolean match(boy b){
		
		if(this.expense <= b.budget ){
			return true;
		}
		else{
			return false;
			
		}
	}
}
