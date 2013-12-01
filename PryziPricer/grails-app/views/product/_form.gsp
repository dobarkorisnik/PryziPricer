<%@ page import="pryzipricer.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'barcode', 'error')} required">
	<label for="barcode">
		<g:message code="product.barcode.label" default="Barcode" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="barcode" type="number" value="${productInstance.barcode}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${productInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'store', 'error')} ">
	<label for="store">
		<g:message code="product.store.label" default="Store" />
		
	</label>
	<g:textField name="store" value="${productInstance?.store}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} ">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${productInstance?.price?}" var="p">
    <li><g:link controller="price" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="price" action="create" params="['product.id': productInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'price.label', default: 'Price')])}</g:link>
</li>
</ul>

</div>

