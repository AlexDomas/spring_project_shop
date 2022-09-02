<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div id="productCatalog" class="panel panel-default collapse">
   

    &nbsp;
    <div class="panel-name"> Product catalog</div>
    &nbsp;
    <div class="list-group">
        <c:forEach items="${categories}" var="category">
		<a href="${pageContext.request.contextPath}/show/category/${category.id}/products" class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c:forEach>

    </div>
    
    
</div>