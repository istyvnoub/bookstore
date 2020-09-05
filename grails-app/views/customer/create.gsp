%{--Include Main Layout--}%
<meta name="layout" content="main" xmlns:g="http://www.w3.org/1999/xhtml"/>

<div class="card">
  <div class="card-header">
    <g:message code="customer" args="['Create']"/>
  </div>
  <div class="card-body">
    <g:form controller="customer" action="Save">

      %{--Partial Templating--}%
      <g:render template="form"/>
      <div class="form-action-panel">
        <g:submitButton class="btn btn-primary" name="Save" value="Save"/>
        <g:link controller="member" action="index" class="btn btn-primary"><g:message code="cancel"/></g:link>
      </div>
    </g:form>
  </div>
</div>