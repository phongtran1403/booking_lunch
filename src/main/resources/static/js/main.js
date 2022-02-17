
var quantitiy = 0;
$('.quantity-right-plus').click(function (e) {

    // Stop acting like a button
    e.preventDefault();
    // Get the field name
    var quantity = parseInt($('#quantity').val());

    // If is not undefined

    $('#quantity').val(quantity + 1);


    // Increment

});

$('.quantity-left-minus').click(function (e) {
    // Stop acting like a button
    e.preventDefault();
    // Get the field name
    var quantity = parseInt($('#quantity').val());

    // If is not undefined

    // Increment
    if (quantity > 0) {
        $('#quantity').val(quantity - 1);
    }
});

// (function($) {
//     "use strict";
//     $(".js-select2").select2({
//         closeOnSelect : false,
//         placeholder : "Click to select an option",
//         allowHtml: true,
//         allowClear: true,
//         tags: true
//     });
//
//     $('.icons_select2').select2({
//         width: "100%",
//         templateSelection: iformat,
//         templateResult: iformat,
//         allowHtml: true,
//         placeholder: "Click to select an option",
//         dropdownParent: $( '.select-icon' ),//обавили класс
//         allowClear: true,
//         multiple: false
//     });
//
//     function iformat(icon, badge,) {
//         var originalOption = icon.element;
//         var originalOptionBadge = $(originalOption).data('badge');
//
//         return $('<span><i class="fa ' + $(originalOption).data('icon') + '"></i> ' + icon.text + '<span class="badge">' + originalOptionBadge + '</span></span>');
//     }
// })(jQuery);