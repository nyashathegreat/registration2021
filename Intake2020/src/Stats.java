
public class Stats {
    //Initializing variables
	private String id;
	private double feesPaid;
    private int feesTotal;
    private double balance;
	
	
	// Initializing methods
	public Stats(String id) {
		this.feesPaid = 0;
		this.feesTotal = 30000;
		this.id = id;
		
	}
	
	public String getId() {
		return id;
	}
	
    public void fees( double amount) {
         feesPaid += amount;
         
    }
    public double getFees(){
        return feesPaid;
    }
    public void balance( double feesPaid){
        balance = feesTotal - feesPaid;
    }
    public double getBalance (){
        return feesTotal - feesPaid;
        
    }
	
	//@Override
	public String toString() {
        return " The new student's identity number is "+ id + " and has paid fees of an amount of "+ feesPaid ;
         
	}
	
	

}
