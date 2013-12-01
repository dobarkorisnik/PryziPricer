package pryzipricer

class Product {
	String store
	long barcode
	String description
	
	@Override
	String toString()
	{
		"${barcode}"
	}
	
	static hasMany = [price:Price]

    static constraints = {
		barcode(unique:true, nullable: false)
		description()
		store()
		
    }
}
