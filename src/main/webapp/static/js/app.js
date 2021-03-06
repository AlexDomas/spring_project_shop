$(function () {

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
        default:
            if (menu == "Home")
                break;
            $('#listAllProducts').addClass('active');
            $('#a_' + menu).addClass('active');
            break;


    }

    //code for jquery dataTable




    var $table = $('#productListTable');

    //execute the below code only where we have this table
    if ($table.length) {

        var jsonUrl = '';
        if (window.categoryId == '') {
            jsonUrl = window.contextRoot + '/json/data/all/products';
        } else {
            jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
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
                        return '&#36; ' + data
                    }
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
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';
                        str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary btn-interact"><i class="bi bi-eye"></i></a> &#160;&#160;&#160;';
                        if (row.quantity < 1) {
                            str += '<a href="javascript:void(0)" class="btn btn-primary btn-interact disabled"><i class="bi bi-bag-fill"></i></a>';
                        } else {
                            str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-primary btn-interact"><i class="bi bi-bag-fill"></i></a>';
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

        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';


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
                    dSortable: false,
                    mRender: function (data, type, row) {

                        var str = '';

                        str += '<a href="'+window.contextRoot+'/manage/' + data + '/product" class="btn btn-primary btn-edit">';
                        str += '<i class="fa fa-pencil" aria-hidden="true"></i>';

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
    
    if($categoryForm.length){
        
        $categoryForm.validate({
            
            rules : {
                
                name : {
                    
                    required: true,
                    minlength: 2
                    
                },
                
                description:{
                    
                    required: true
                    
                }
                
            },
            
            messages : {
                
                name : {
                    
                    required: 'Please add the category name!',
                    minlength: 'The category name should not be less than 2 characters!'
                    
                },
                
                description: {
                    
                    required: 'Please add a description for this category!'
                    
                }
                
            },
            
            errorElement: 'em',
            errorPlacement: function(error, element){
                //add the class of help-block
                error.addClass('help-block');
                //add the error element after the input element
                error.insertAfter(element);
                
            }
            
        });
        
    }
    
    //-------------------
    
    


});