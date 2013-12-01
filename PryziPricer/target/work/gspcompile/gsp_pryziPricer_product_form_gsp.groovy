import pryzipricer.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_pryziPricer_product_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: productInstance, field: 'barcode', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("product.barcode.label"),'default':("Barcode")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("barcode"),'type':("number"),'value':(productInstance.barcode),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'description', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("product.description.label"),'default':("Description")],-1)
printHtmlPart(5)
invokeTag('textField','g',18,['name':("description"),'value':(productInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'store', 'error'))
printHtmlPart(6)
invokeTag('message','g',23,['code':("product.store.label"),'default':("Store")],-1)
printHtmlPart(5)
invokeTag('textField','g',26,['name':("store"),'value':(productInstance?.store)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: productInstance, field: 'price', 'error'))
printHtmlPart(7)
invokeTag('message','g',31,['code':("product.price.label"),'default':("Price")],-1)
printHtmlPart(8)
for( p in (productInstance?.price) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(p?.encodeAsHTML())
})
invokeTag('link','g',37,['controller':("price"),'action':("show"),'id':(p.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'price.label', default: 'Price')]))
})
invokeTag('link','g',40,['controller':("price"),'action':("create"),'params':(['product.id': productInstance?.id])],1)
printHtmlPart(12)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385559144706L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
