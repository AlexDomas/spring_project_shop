<%@include file="../../fragment/flows-header.jsp" %>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <meta name="robots" content="noindex,follow" />
    <title>Shop - Billing</title>

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
            <!--  To display all the goods -->
            <div class="col-md-6">

                <div class="row" id="cartLineInfo">
                    <c:forEach items="${checkoutDto.cartLines}" var="cartLine">
                        <div class="col-xs-12">

                            <div>
                                <h3 class="product-name">${cartLine.product.name}</h3>
                                <hr/>
                                <h5 class="product-info">Quantity -${cartLine.productCount}</h5>
                                <h5 class="product-info">Buying Price - &#8377; ${cartLine.buyingPrice}/-</h5>							
                            </div>						
                            <hr/>
                            <div class="text-right">
                                <h3>Grand Total - &#8377; ${cartLine.total}/-</h3>
                            </div>						
                        </div>
                    </c:forEach>
                </div>

            </div>

            <div id="order-address">

                <h3 class="text-center">
                    Payment Details
                </h3>
                &nbsp;&nbsp;
                <form role="form">

                    <fieldset class="clearfix">

                        <label for="cardNumber">
                            CARD NUMBER</label>

                        <p><i class="bi bi-lock-fill"></i><input type="text" id="cardNumber" placeholder="Valid Card Number"
                                                                 required autofocus /></p>


                        <label for="expityMonth">EXPIRY DATE</label>
                        <br/>

                        <p><i class="bi bi-calendar-date"></i><input type="text" id="expityMonth" placeholder="MM / YY" required /></p>

                        <label for="cvCode">
                            CV CODE</label>
                        <p><i class="bi bi-eye-slash" id="eye"></i><input type="password" id="cvCode" placeholder="CV" required /></p>
                        
                    </fieldset>
                    
                </form>

                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a id="checkoutTotaLink"><span class="badge pull-right" id="checkoutTotal"> &#36; ${checkoutDto.checkoutTotal}/-</span> Final Payment</a></li>
                </ul>
                &nbsp;
                <br/>
                <a href="${flowExecutionUrl}&_eventId_pay" class="btn btn-success btn-lg btn-block" role="button">Pay</a>
                &nbsp;

            </div>
        </div>
    </div>


    <%@include file="../../fragment/flows-footer.jsp" %>
    
    <script src="${js}/app.js"></script>
    
</body>
