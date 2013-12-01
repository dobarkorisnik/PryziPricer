package pryzipricer



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.sql.Sql

import java.awt.List;

import org.grails.datastore.mapping.query.Query
//import java.sql.SQLData

@Transactional(readOnly = true)
class ProductController {

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond Product.list(params), model:[productInstanceCount: Product.count()]
	}

	def show(Product productInstance) {
		def allPricesQuery =  Price.where {
			product.barcode ==  productInstance.barcode
	    }
		
		def currentPrice = allPricesQuery.list(sort:"date", order:"desc").first().price
			
		def lowestPrice = allPricesQuery.list(sort:"price", order:"asc").first().price
		
		def highestPrice = allPricesQuery.list(sort:"price", order:"asc").last().price
		
		def allPrices= allPricesQuery.findAll() 
		
		def total = 0;
		def cnt = allPrices.size()
		for(pr in allPrices){
			total+=pr.price
		}
		def averagePrice=0
		
		if(cnt>0)
		{
			averagePrice=total/cnt
		}
		
		def idealPrice = 0
		if(cnt>2)
		{
			idealPrice = (total-highestPrice-lowestPrice)*1.2/(cnt-2)
		}
	
		[productInstance:productInstance, currentPrice:currentPrice, lowestPrice:lowestPrice, highestPrice:highestPrice, averagePrice:averagePrice, idealPrice:idealPrice, numberOfPrices:cnt]
	}

	def create() {
		respond new Product(params)
	}

	@Transactional
	def save(Product productInstance) {
		if (productInstance == null) {
			notFound()
			return
		}

		if (productInstance.hasErrors()) {
			respond productInstance.errors, view:'create'
			return
		}

		productInstance.save flush:true

		request.withFormat {
			form {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'productInstance.label', default: 'Product'),
					productInstance.id
				])
				redirect productInstance
			}
			'*' { respond productInstance, [status: CREATED] }
		}
	}

	def edit(Product productInstance) {
		respond productInstance
	}

	@Transactional
	def update(Product productInstance) {
		if (productInstance == null) {
			notFound()
			return
		}

		if (productInstance.hasErrors()) {
			respond productInstance.errors, view:'edit'
			return
		}

		productInstance.save flush:true

		request.withFormat {
			form {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Product.label', default: 'Product'),
					productInstance.id
				])
				redirect productInstance
			}
			'*'{ respond productInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(Product productInstance) {

		if (productInstance == null) {
			notFound()
			return
		}

		productInstance.delete flush:true

		request.withFormat {
			form {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Product.label', default: 'Product'),
					productInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'productInstance.label', default: 'Product'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}	
}
