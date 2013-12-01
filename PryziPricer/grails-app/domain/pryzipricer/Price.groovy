package pryzipricer

class Price {

	int price
	Date date
		
	String toString()
	{
		"${price}"
	}
	
	static belongsTo = [product:Product]
	
	static constraints = {
		price()
		date()
    }
}
