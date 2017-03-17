document.getElementById('save').onclick = function () {


    if (document.getElementById('nameHuman').value == '') {

        document.getElementById('error').innerHTML = 'error';
        document.getElementById('error').style.backgroundColor = 'red';

    } else {

        document.getElementById('error').innerHTML = '';

        var human = {
            image:document.getElementById('imageHuman').value,
            name: document.getElementById('nameHuman').value

        }

        document.getElementById('nameHuman').value = '';
        document.getElementById('imageHuman').value='';

        $.ajax({


            url: 'saveHuman?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val() + + $('input[name=csrf_image]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(human),
            success: function (res) {
                var all = '';

                for (var i = 0; i < res.length; i++) {
                    var index = res[i].id;
                    all += '<div class="box">'+res[i].name+res[i].image  +'<a onclick="deleteHuman(' + index + ')"> delete </div><br>';
                }
                document.querySelector('.all').innerHTML = all;

            }

        })
    }

}

window.onload = function () {

    $.ajax({

        url: 'loadHumans?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val() + $('input[name=csrf_image]').val(),

        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].name +res[i].image  +'<a onclick="deleteHuman(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })

}
function deleteHuman(index) {

    $.ajax({

        url: 'deleteHuman?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val() + $('input[name=csrf_image]').val(),
        method: 'POST',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: '' + index,
        success: function (res) {

            var all = '';

            for (var i = 0; i < res.length; i++) {
                var index = res[i].id;
                all += '<div class="box">'+res[i].name +res[i].image +'<a onclick="deleteHuman(' + index + ')"> delete </div><br>';
            }
            document.querySelector('.all').innerHTML = all;
        }
    })


}
$('.show-list').click(function(){
    $('.wrapper').addClass('list-mode');
});

$('.hide-list').click(function(){
    $('.wrapper').removeClass('list-mode');
});






