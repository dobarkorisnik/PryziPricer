<%@ page import="pryzipricer.Price" %>



<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="price.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${priceInstance.price}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="price.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${priceInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: priceInstance, field: 'product', 'error')} required">
	<label for="product">
		<g:message code="price.product.label" default="Product" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="product" name="product.id" from="${pryzipricer.Product.list()}" optionKey="id" required="" value="${priceInstance?.product?.id}" class="many-to-one"/>
</div>

