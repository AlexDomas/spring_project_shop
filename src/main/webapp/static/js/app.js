$(function () {

    $(window).load(function () {
        setTimeout(function () {
            $(".se-pre-con").fadeOut("slow");
        }, 1000);
    });

    switch (menu) {

        case 'About Us':
            $('#about').addClass('active');
            break;
        case 'Reviews':
            $('#reviews').addClass('active');
            break;
        case 'News':
            $('#News').addClass('active');
            break;
        case 'All Products':
            $('#listAllProducts').addClass('active');
            break;
        case 'Contact':
            $('#contact').addClass('active');
            break;
        case 'Manage Products':
            $('#manageProducts').addClass('active');
            break;
        case 'User Cart':
            $('#userCart').addClass('active');
            break;
        default:
            if (menu === "Home")
                break;
            $('#listAllProducts').addClass('active');
            $('#a_' + menu).addClass('active');
            break;
    }

//code for jquery dataTable

// for handling CSRF token
    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');
    if ((token !== undefined && header !== undefined) && (token.length > 0 && header.length > 0)) {
// set the token header for the ajax request
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }

    var $table = $('#productListTable');
    //execute the below code only where we have this table
    if ($table.length) {

        var jsonUrl = '';
        if (window.categoryId === '') {
            jsonUrl = window.contextRoot + '/api/data/all/products';
        } else {
            jsonUrl = window.contextRoot + '/api/data/category/' + window.categoryId + '/products';
        }

        $table.DataTable({
            lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [

                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/img/products/black/' + data + '.jpg" class="dataTableImg"/>'
                    }
                },
                {
                    data: 'name',
                },
                {
                    data: 'brand',
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#36; ' + data;
                    }
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</stock>';
                        }
                        return data;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var urlButtonShowingProduct = '';
                        urlButtonShowingProduct += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary btn-interact"><i class="bi bi-eye"></i></a> &#160;&#160;&#160;';
                        return urlButtonShowingProduct;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';

                        if (window.userRole === 'USER') {
                            if (row.quantity < 1) {
                                str += '<a href="javascript:void(0)" class="btn btn-primary btn-interact disabled"><i class="bi bi-bag-fill"></i></a>';
                            } else {
                                str += '<a href="'
                                        + window.contextRoot
                                        + '/cart/add/'
                                        + data
                                        + '/product" class="btn btn-primary btn-interact"><i class="bi bi-bag-fill"></i></a>';
                            }
                        } else {
                            str += '<a href="'
                                    + window.contextRoot
                                    + '/manage/'
                                    + data
                                    + '/product" class="btn btn-primary btn-interact"><i class="fa fa-pencil"></i></a>';
                        }
                        return str;
                    }
                }

            ]

        });
    }


//dismissing the alert after 3 seconds
    var $alert = $('.alert');
    if ($alert.length) {

        setTimeout(function () {

            $alert.fadeOut('slow');
        }, 5000)

    }

// ----------------------


//data table for admin


    var $adminProductsTable = $('#adminProductsTable');
    //execute the below code only where we have this table
    if ($adminProductsTable.length) {

        var jsonUrl = window.contextRoot + '/api/data/admin/all/products';
        $adminProductsTable.DataTable({
            lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'All']],
            pageLength: 30,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [

                {
                    data: 'id'

                },
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="' + window.contextRoot + '/img/products/black/' + data + '.jpg" class="adminDataTableImg"/>'
                    }
                },
                {
                    data: 'name',
                },
                {
                    data: 'brand',
                },
                {
                    data: 'quantity',
                    mRender: function (data, type, row) {
                        if (data < 1) {
                            return '<span style="color:red">Out of Stock!</stock>'
                        }
                        return data;
                    }
                },
                {
                    data: 'unitPrice',
                    mRender: function (data, type, row) {
                        return '&#36; ' + data
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<label class="switch">';
                        if (data) {
                            str += '<input type="checkbox" checked="checked" value="' + row.id + '"/>';
                        } else {
                            str += '<input type="checkbox" value="' + row.id + '"/>';
                        }
                        str += '<div class="slider"></div></label>';
                        return str;
                    }

                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-primary btn-edit">';
                        str += '<i class="fa fa-pencil" aria-hidden="true"></i>';
                        return str;
                    }

                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';
                        str += '<a href="' + window.contextRoot + '/manage/delete/' + data + '/product" class="btn btn-primary btn-edit">';
                        str += '<i class="fa fa-trash" aria-hidden="true"></i>';
                        return str;
                    }

                }

            ],
            initComplete: function () {

                var api = this.api();
                api.$('.switch input[type="checkbox"]').on('change', function () {

                    var checkbox = $(this);
                    var checked = checkbox.prop('checked');
                    var dMsg = (checked) ? 'You want to activate the product ?' : 'You want to deactivate the product ?';
                    var value = checkbox.prop('value');
                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activation & Deactivation',
                        message: dMsg,
                        callback: function (confirmed) {

                            if (confirmed) {

                                console.log(value);
                                var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
                                $.post(activationUrl, function (data) {

                                    bootbox.alert({
                                        size: 'medium',
                                        title: 'Information',
                                        message: data
                                    });
                                });
                            } else {
                                checkbox.prop('checked', !checked);
                            }

                        }

                    });
                });
            }

        });
    }

// ------------------------------
// validation code for category

    var $categoryForm = $('#categoryForm')

    if ($categoryForm.length) {

        $categoryForm.validate({

            rules: {

                name: {

                    required: true,
                    minlength: 2

                },
                description: {

                    required: true

                }

            },
            messages: {

                name: {

                    required: 'Please add the category name!',
                    minlength: 'The category name should not be less than 2 characters!'

                },
                description: {

                    required: 'Please add a description for this category!'

                }

            },
            errorElement: 'em',
            errorPlacement: function (error, element) {
                //add the class of help-block
                error.addClass('help-block');
                //add the error element after the input element
                error.insertAfter(element);
            }

        });
    }

//-------------------

    /*validating the loginform*/

// validating the product form element	
// fetch the form element
    $loginForm = $('#loginForm');
    if ($loginForm.length) {

        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    email: true

                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: 'Please enter your email!',
                    email: 'Please enter a valid email address!'
                },
                password: {
                    required: 'Please enter your password!'
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the 'help-block' class to the error element
                error.addClass("help-block");
                // add the error label after the input element
                error.insertAfter(element);
            }
        }

        );
    }

    //-------------------
    //handling the click event of refresh cart button
    $('button[name="refreshCart"]').click(function () {
        //fetch the cart line id
        var cartLineId = $(this).attr('value');
        var countElement = $('#count_' + cartLineId);

        var originalCount = countElement.attr('value');
        var currentCount = countElement.val();

        //work only when the count has changed
        if (currentCount !== originalCount) {
            if (currentCount < 1 || currentCount > 10) {
                //reverting back to the original count
                //user has given value below 1 and above 10
                countElement.val(originalCount);
                bootbox.alert({
                    size: 'medium',
                    title: 'Error',
                    message: 'Product count should be minimum 1 and maximum 10!'
                });
            } else {

                var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
                //forward it to the controller
                window.location.href = updateUrl;

            }
        }

    });

    //eye icon for password input

    $(function () {

        $('#eye').click(function () {

            if ($(this).hasClass('bi-eye-slash')) {

                $(this).removeClass('bi-eye-slash');

                $(this).addClass('bi-eye-fill');

                $('#password').attr('type', 'text');

            } else {

                $(this).removeClass('bi-eye-fill');

                $(this).addClass('bi-eye-slash');

                $('#password').attr('type', 'password');
            }
        });
    });

    $(function () {

        $('#eye1').click(function () {

            if ($(this).hasClass('bi-eye-slash')) {

                $(this).removeClass('bi-eye-slash');

                $(this).addClass('bi-eye-fill');

                $('#password1').attr('type', 'text');

            } else {

                $(this).removeClass('bi-eye-fill');

                $(this).addClass('bi-eye-slash');

                $('#password1').attr('type', 'password');
            }
        });
    });

    $(function () {

        $('#eye2').click(function () {

            if ($(this).hasClass('bi-eye-slash')) {

                $(this).removeClass('bi-eye-slash');

                $(this).addClass('bi-eye-fill');

                $('#password2').attr('type', 'text');

            } else {

                $(this).removeClass('bi-eye-fill');

                $(this).addClass('bi-eye-slash');

                $('#password2').attr('type', 'password');
            }
        });
    });

    $('.element').each(function () {
        $(this).mouseover(function () {
            $(this).addClass('active');
            $('.stage').children('.element').not('.active').addClass('inactive');
        });
        $(this).mouseleave(function () {
            $(this).removeClass('active');
            $('.stage').children('.element').not('.active').removeClass('inactive');
        });
    });

});

$(function () {
    /* Settings */
    $.global = new Object();

    $.global.item = 1;
    $.global.total = 0;

    $(document).ready(function ()
    {

        var WindowWidth = $(window).width();
        var SlideCount = $('#slides li').length;
        var SlidesWidth = SlideCount * WindowWidth;

        $.global.item = 0;
        $.global.total = SlideCount;

        $('.slide').css('width', WindowWidth + 'px');
        $('#slides').css('width', SlidesWidth + 'px');

        $("#slides li:nth-child(1)").addClass('alive');

        $('#left-side').click(function () {
            Slide('back');
        });
        $('#right-side').click(function () {
            Slide('forward');
        });

    });

    function Slide(direction)
    {

        if (direction == 'back') {
            var $target = $.global.item - 1;
        }
        if (direction == 'forward') {
            var $target = $.global.item + 1;
        }

        if ($target == -1) {
            DoIt($.global.total - 1);
        } else if ($target == $.global.total) {
            DoIt(0);
        } else {
            DoIt($target);
        }


    }

    function DoIt(target)
    {

        var $windowwidth = $(window).width();
        var $margin = $windowwidth * target;
        var $actualtarget = target + 1;

        $("#slides li:nth-child(" + $actualtarget + ")").addClass('alive');

        $('#slides').css('transform', 'translate3d(-' + $margin + 'px,0px,0px)');

        $.global.item = target;

        $('#count').html($.global.item + 1);

    }

});

