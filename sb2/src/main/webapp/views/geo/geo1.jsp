<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<style>
    /* css 파일이 하나로 합쳐지는 경우를 대비하여 전체 div에 id를 부여한다. */
    #geo1 > #map{
        width: 800px;
        height: 400px;
        border: 2px solid red;
    }
</style>
<script>
    let geo1 = {
        map: null,
        lat: 0.0,
        lng: 0.0,
        init: function () {
            // geolocation 사용하여 현재 위치 받아오기
            if(navigator.geolocation){
                navigator.geolocation.getCurrentPosition(function (position){
                    geo1.lat = position.coords.latitude;
                    geo1.lng = position.coords.longitude;

                    // (1) API 사용하여 지도 생성하기
                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                        mapOption = {
                            center: new kakao.maps.LatLng(geo1.lat, geo1.lng), // 지도의 중심좌표
                            level: 3 // 지도의 확대 레벨
                        };
                    geo1.map = new kakao.maps.Map(mapContainer, mapOption);
                    geo1.display();
                })
            }else{
                alert('error');
            }
        },
        display:function(){
            // (2) 생성한 지도에 컨트롤 올리기
            var mapTypeControl = new kakao.maps.MapTypeControl();
            this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            // (3) 생성한 지도에 마커 생성하기
            var markerPosition  = new kakao.maps.LatLng(geo1.lat, geo1.lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(this.map);

            // (4) 마커에 인포윈도우 표시하기
            var iwContent
                = '<div style="padding:5px;">Hello World!<br>' +
                '<img style="width:50px; height:50px" src="<c:url value="/img/face.png"/> ">' +
                '</div>';

            var infowindow = new kakao.maps.InfoWindow({
                content: iwContent
            });

            // 해당 인포윈도우를 표시할 때, 마우스 이벤트 적용
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                infowindow.open(geo1.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
        }
    };

    $(function (){
        geo1.init();
    })
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="geo1">
    <h2>Geo1 Page</h2>
    <div id="map"> <!-- 여기다 지도를 넣겠다 -->

    </div>
</div>