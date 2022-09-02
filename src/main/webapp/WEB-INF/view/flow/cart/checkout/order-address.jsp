<%@include file="../../fragment/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>	

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="noindex,follow" />
        <title>Shop - ${title}</title>

        <script>

            window.menu = '${title}';

            window.contextRoot = '${contextRoot}'

        </script>

        <link rel="icon" type="image/x-icon" href="./assets/favicon.ico" />

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css" rel="stylesheet" />
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link href="${css}/order-address.css" media="screen" rel="stylesheet" type="text/css">
        <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
        <link href="https://fonts.googleapis.com/css2?family=Galada&display=swap" rel="stylesheet">



        <link rel="stylesheet" type="text/css" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

    </head>


    <body>

        <div class="container">

            <div class="row">

                <div class="col-md-4">
                    
                    <h3 class="text-center" id="select-shipping">Select Shipping Address</h3>
                    <hr/>

                    <c:forEach items="${addresses}" var="address">					
                        <div class="cols-xs-12">
                            <h3 class="text-center">${address.addressLineOne}</h3>
                            <h3 class="text-center">${address.addressLineTwo}</h3>
                            <h3 class="text-center">${address.city} - ${address.postalCode}</h3>
                            <h3 class="text-center">${address.state} - ${address.country}</h3>
                            &nbsp;
                            <div class="text-center">
                                <p><button class="btn-select"><a id="select-shipping-address" href="${flowExecutionUrl}&_eventId_addressSelection&shippingId=${address.id}">Select</a></button></p>
                            </div>
                            <hr/>
                        </div>
                    </c:forEach>			

                </div>		

                <div id="order-address">

                    <h3 class="text-center">Sign Up - Address</h3>
                    &nbsp;&nbsp;&nbsp;
                    <sf:form
                        method="POST"
                        modelAttribute="shipping"
                        class="form-horizontal"
                        id="billingForm"
                        >

                        <fieldset class="clearfix">

                            <sf:errors path="addressLineOne" cssClass="help-block" element="em"/> 
                            <p><i class="bi bi-geo-alt-fill"></i><sf:input type="text" path="addressLineOne"
                                                                           placeholder="Address Line One" /></p>

                            <sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
                            <p><i class="bi bi-geo-alt-fill"></i><sf:input type="text" path="addressLineTwo"
                                                                           placeholder="Address Line Two"/></p>

                            <sf:errors path="city" cssClass="help-block" element="em"/> 
                            <p><i class="bi bi-building"></i><sf:input type="text" path="city"
                                                                       placeholder="City Name" /></p>

                            <sf:errors path="postalCode" cssClass="help-block" element="em"/> 
                            <p> <i class="bi bi-mailbox"></i> <sf:input type="text" path="postalCode" placeholder="Postal Code" /></p>

                            <sf:errors path="state" cssClass="help-block" element="em"/> 
                            <p><i class="bi bi-reception-4"></i><sf:input type="text" path="state" placeholder="State Name" /></p>

                            <sf:errors path="country" cssClass="help-block" element="em"/> 
                            <p><i class="bi bi-flag"></i><sf:input type="text" path="country" placeholder="Country Name" /></p>

                            <p><span class="glyphicon glyphicon-plus"></span><input type="submit" name="_eventId_saveAddress" value="Add Address"></p>

                        </fieldset>

                    </sf:form>					


                </div>
            </div>

        </div>	


        <%@include file="../../fragment/flows-footer.jsp" %>	

    </body>