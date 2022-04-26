<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<spring:url var="img" value="/img"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">

    <c:if test="${not empty message}">

        <div class="col-xs-12">

            <div class="alert alert-success alert-dismissible">

                <button type="button" class="close" data-dismiss="alert">&times;</button>
                ${message}
            </div>

        </div>

    </c:if>

    <div style="background:url(${img}/honor.jpg)" class="addProductSection" >
        <div class="info">
            <h2>Additional information</h2>
            <i class="icon ion-ios-ionic-outline" aria-hidden="true"></i>
            <%if (request.getAttribute("errorId") != null) {%>
            <p style="color: rgba(10, 180, 180, 1);"> <%out.println(request.getAttribute("errorId"));%> </p>
            <%}%>
            <%if (request.getAttribute("errorIdRepeat") != null) {%>
            <p style="color: rgba(10, 180, 180, 1);"> <%out.println(request.getAttribute("errorIdRepeat"));%> </p>
            <%}%>      

        </div>

        <sf:form class="addProductForm" modelAttribute="product" action="${pageContext.request.contextPath}/manage/products" method="POST" enctype="multipart/form-data">
            <h2>Product Management</h2>
            <ul class="noBullet">
                <li>

                    <sf:input type="text" path="name" class="inputFields"  placeholder="Product Name" />
                    <br><sf:errors path="name" cssClass="help-block" element="em"/> 
                </li>
                <li>

                    <sf:input type="text" class="inputFields" path="brand" placeholder="Brand Name"/>
                    <br><sf:errors path="brand" cssClass="help-block" element="em"/> 
                </li>
                <li>

                    <sf:textarea style="resize: none" path="description" rows="4" class="inputFields" placeholder="Description"/>
                    <br><sf:errors path="description" cssClass="help-block" element="em"/> 
                </li>

                <li>

                    <sf:input type="number" class="inputFields" path="unitPrice" placeholder="Unit Price" min="1" max="10000000"/>
                    <br><sf:errors path="unitPrice" cssClass="help-block" element="em"/> 
                </li>

                <li>

                    <sf:input type="number" class="inputFields" path="quantity" placeholder="Quantity Available" min="0" max="100" />
                    <br><sf:errors path="quantity" cssClass="help-block" element="em"/> 
                </li>

                <li>

                    <sf:input type="file" class="inputFields" path="file"/>
                    <br><sf:errors path="file" cssClass="help-block" element="em"/> 
                </li>

                <li>
                    <sf:select class = "inputFields" path="categoryId" id="categoryId" items="${categories}" itemLabel="name" itemValue="id"/>
                    <c:if test="${product.id == 0}">

                        </br>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myCategoryModal">
                            Add Category
                        </button>


                    </c:if>
                </li>

                <li id="center-btn">
                    <input type="submit" id="join-btn" name="submit" value="Submit">

                    <sf:hidden path="id"/>
                    <sf:hidden path="code"/>
                    <sf:hidden path="supplierId"/>
                    <sf:hidden path="active"/>
                    <sf:hidden path="purchases"/>
                    <sf:hidden path="views"/>
                </li>
            </ul>
        </sf:form>


    </div>

    <div class="row">

        <div class="col-xs-12">

            <h3>Available Products</h3>

        </div>

        <div class="row">
            <div class="col-xs-12">

                <table id="adminProductsTable" class="table table-borderd">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Active</th>
                            <th>Edit</th>
                        </tr>
                    </thead>



                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Brand</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Active</th>
                            <th>Edit</th> 
                        </tr>
                    </tfoot>
                </table>

            </div>

        </div>

    </div>


    <div class="modal fade" id="myCategoryModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel">Add New Category</h5>
                    <button type="button" class="close" data-bs-dismiss="modal">
                        <span>&times;</span>
                    </button>

                </div>
                <div class="modal-body">
                    <sf:form id="categoryForm" modelAttribute="category" action="${pageContext.request.contextPath}/manage/category" method="POST" class="form-horizontal">

                        <div class="form-group">

                            <label for="category_name" class="control-label col-md-4">Category Name</label>
                            <div class="col-md-8">

                                <sf:input type="text" path="name" id="category_name" class="form-control"/>

                            </div>

                        </div>

                        <div class="form-group">

                            <label for="category_description" class="control-label col-md-4">Category Description</label>
                            <div class="col-md-8">

                                <sf:textarea cols="" rows="5" path="description" id="category_description" class="form-control"/>

                            </div>

                        </div>

                        <div class="form-group">


                            <div class="col-md-offset-4 col-md-8">

                                <input type="submit" value="Add Category" class="btn btn-primary"/>

                            </div>

                        </div>

                    </sf:form>
                </div>

            </div>
        </div>
    </div>


</div>






