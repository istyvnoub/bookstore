<div class="form-group">
  <label><g:message code="first.name"/> *</label>
  <g:textField name="firstName" class="form-control" value="${customer?.firstName}" placeholder="Please Enter First Name"/>
  <UIHelper:renderErrorMessage fieldName="firstName" model="${customer}" errorMessage="please.enter.first.name"/>
</div>

<div class="form-group">
  <label><g:message code="last.name"/></label>
  <g:textField name="lastName" class="form-control" value="${customer?.lastName}" placeholder="Please Last Name"/>
</div>

<div class="form-group">
  <label><g:message code="email.address"/> *</label>
  <g:field type="email" name="email" class="form-control" value="${customer?.email}" placeholder="Please Enter Email"/>
  <UIHelper:renderErrorMessage fieldName="email" model="${customer}" errorMessage="Your Email Address is not Valid / Already Exist in System"/>
</div>

<g:if test="${!edit}">
  <div class="form-group">
    <label><g:message code="password"/> *</label>
    <g:passwordField name="password" class="form-control" value="${customer?.password}" placeholder="Please Enter Password"/>
    <UIHelper:renderErrorMessage fieldName="password" model="${customer}" errorMessage="Please Enter a Password."/>
  </div>
</g:if>
