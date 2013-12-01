import pryzipricer.Price
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_pryziPricer_price_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/price/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: priceInstance, field: 'price', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("price.price.label"),'default':("Price")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("price"),'type':("number"),'value':(priceInstance.price),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: priceInstance, field: 'date', 'error'))
printHtmlPart(4)
invokeTag('message','g',15,['code':("price.date.label"),'default':("Date")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',18,['name':("date"),'precision':("day"),'value':(priceInstance?.date)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: priceInstance, field: 'product', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("price.product.label"),'default':("Product")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['id':("product"),'name':("product.id"),'from':(pryzipricer.Product.list()),'optionKey':("id"),'required':(""),'value':(priceInstance?.product?.id),'class':("many-to-one")],-1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385559176383L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
