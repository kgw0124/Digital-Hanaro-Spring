<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #all {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid red;
    }

    #me {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid blue;
    }

    #to {
        width: 400px;
        height: 200px;
        overflow: auto;
        border: 2px solid green;
    }
</style>


<script>
    let websocket = {
        id:'',
        stompClient:null,
        init:function(){
            this.id = $('#adm_id').text();
            $('#connect').click(()=>{
                this.connect();
            });
            $('#disconnect').click(()=>{
                this.disconnect();
            });

            $('#sendto').click(()=>{
                var msg = JSON.stringify({
                    'sendid' : this.id,
                    'receiveid' : $('#target').val(),
                    'content1' : $('#totext').val()
                });
                this.stompClient.send('/sendchat', {}, msg);
            });
        },
        connect:function(){
            let sid = this.id;
            let socket = new SockJS('${serverurl}/chat');
            this.stompClient = Stomp.over(socket);
            // 소켓 객체 생성

            this.stompClient.connect({}, function(frame) {
                // 클라이언트와 서버 연결
                websocket.setConnected(true);
                // 화면에 서버 연결됐다 보여주는 함수
                this.subscribe('/send3/to/'+sid, function(msg) {
                    $('#target').attr('value', JSON.parse(msg.body).sendid);
                    $("#to").prepend(
                        "<h4>" + JSON.parse(msg.body).sendid +":"+
                        JSON.parse(msg.body).content1
                        + "</h4>");
                });


            });
        },
        setConnected:function(connected){
            // connect가 일어났을 때 정상이면 true -> 연결완료 화면 보여줌
            // connect가 비정상이면 false -> 연결실패 화면 보여줌
            if (connected) {
                $("#status").text("Connected");
            } else {
                $("#status").text("Disconnected");
            }
        },
        disconnect: function () {
            if (this.stompClient !== null) {
                this.stompClient.disconnect();
            }
            websocket.setConnected(false);
            console.log("Disconnected");
        },

    };
    $(function(){
        websocket.init();
    });
</script>



<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Chat</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Chat</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <div class="col-sm-5">
                    <h1 id="adm_id">${sessionScope.admin.id}</h1>
                    <H1 id="status">Status</H1>
                    <button id="connect">Connect</button>
                    <button id="disconnect">Disconnect</button>

                    <h3>To</h3>
                    <input type="text" id="target">
                    <input type="text" id="totext"><button id="sendto">Send</button>
                    <div id="to"></div>
                </div>
            </div>
        </div>
    </div>

</div>