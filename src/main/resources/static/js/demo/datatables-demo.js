// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
          columnDefs:[{targets:1,className:"truncate"}],
          createdRow: function(row){
              var td = $(row).find(".truncate");
              td.attr("title", td.html());
          }
      }



  );
    $('#dataTable2').DataTable({
            columnDefs:[{targets:1,className:"truncate"}],
            createdRow: function(row){
                var td = $(row).find(".truncate");
                td.attr("title", td.html());
            }
        }


    );

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

send();










