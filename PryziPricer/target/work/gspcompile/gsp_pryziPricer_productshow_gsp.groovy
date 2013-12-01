import pryzipricer.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_pryziPricer_productshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (productInstance?.barcode)) {
printHtmlPart(14)
invokeTag('message','g',31,['code':("product.barcode.label"),'default':("Barcode")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',33,['bean':(productInstance),'field':("barcode")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (productInstance?.description)) {
printHtmlPart(18)
invokeTag('message','g',40,['code':("product.description.label"),'default':("Description")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',42,['bean':(productInstance),'field':("description")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (productInstance?.store)) {
printHtmlPart(20)
invokeTag('message','g',49,['code':("product.store.label"),'default':("Store")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',51,['bean':(productInstance),'field':("store")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (productInstance?.price)) {
printHtmlPart(22)
invokeTag('message','g',58,['code':("product.price.label"),'default':("Current Price")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(currentPrice)
})
invokeTag('link','g',59,['controller':("price"),'action':("show"),'id':("currentPrice")],3)
printHtmlPart(24)
invokeTag('message','g',63,['code':("product.price.label"),'default':("Lowest Price")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(lowestPrice)
})
invokeTag('link','g',64,['controller':("price"),'action':("show"),'id':("lowestPrice")],3)
printHtmlPart(24)
invokeTag('message','g',68,['code':("product.price.label"),'default':("Highest Price")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(highestPrice)
})
invokeTag('link','g',69,['controller':("price"),'action':("show"),'id':("highestPrice")],3)
printHtmlPart(24)
invokeTag('message','g',73,['code':("product.price.label"),'default':("Average Price")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(averagePrice)
})
invokeTag('link','g',74,['controller':("price"),'action':("show"),'id':("averagePrice")],3)
printHtmlPart(24)
invokeTag('message','g',78,['code':("product.price.label"),'default':("Ideal Price")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(idealPrice)
})
invokeTag('link','g',79,['controller':("price"),'action':("show"),'id':("idealPrice")],3)
printHtmlPart(24)
invokeTag('message','g',83,['code':("product.price.label"),'default':("Number Of Prices")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(numberOfPrices)
})
invokeTag('link','g',84,['controller':("price"),'action':("show"),'id':("idealPrice")],3)
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(2, {->
printHtmlPart(27)
createTagBody(3, {->
invokeTag('message','g',90,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',90,['class':("edit"),'action':("edit"),'resource':(productInstance)],3)
printHtmlPart(28)
invokeTag('actionSubmit','g',91,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(29)
})
invokeTag('form','g',93,['url':([resource:productInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',95,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1385906987647L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
