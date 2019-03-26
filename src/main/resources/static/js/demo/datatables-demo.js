// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({

      columnDefs: [{
          orderable: false,
          className: 'select-checkbox',
          targets: 0
      }],
      select: {
          style: 'os',
          selector: 'td:first-child'
      }
  });
    $('#dataTable2').DataTable({

        columnDefs: [{
            orderable: false,
            className: 'select-checkbox',
            targets: 0
        }],
        select: {
            style: 'os',
            selector: 'td:first-child'
        }
    });
});

//notifications polling function.
/*
function send(){
    $.ajax({
        type: "get",
        url: "/usernotification",
        success:function(data)
        {
            //console.log the response
            console.log(data.notifications);
            //Send another request in 10 seconds.
            $('#notifications').html(data.notifications);
            setTimeout(function(){
                send();
            }, 10000);
        }
    });
        $.ajax({
            type: "get",
            url: "",
            success:function(data)
            {
                //console.log the response
                console.log(data.notifications);
                //Send another request in 10 seconds.
                $('#messages').html(data.notifications);
                setTimeout(function(){
                    send();
                }, 10000);
            }
        });
}*/




    function send() {
        $.ajax({
            type: "get",
            url: "/alerts",
            dataType:'html',
            success: function (data) {
                //console.log the response
                console.log('data back');
                //Send another request in 10 seconds.
                $('#alerts').html(data);
            }
        });
    }

/*function send() {
    $.ajax({
        type: "get",
        url: "/alerts",
        dataType:'html',
        success: function (data) {
            //console.log the response
            console.log('data back');
            //Send another request in 10 seconds.
            $('#alerts').html(data);
            setTimeout(function () {
                send();
            }, 5000);
        }
    });
}*/



$(document).ready(function(){
    send();
});




