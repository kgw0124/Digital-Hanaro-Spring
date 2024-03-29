<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    let jQuery3 = {
        init:function (){
            $('#btn_get').click(function (){
                $.ajax({
                    url:'<c:url value="/getdata"/>',
                    success:function (data){
                        alert(data);
                    }
                })
            });
        }
    }
    $(function () {
        jQuery3.init();
    });
</script>

<div class="container">
    <h2>jQuery3 Page</h2>
    <button type="button" id="btn_get" class="btn btn-primary">LOGIN</button>
</div>