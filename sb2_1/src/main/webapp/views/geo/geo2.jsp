<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<style>
    /* css 파일이 하나로 합쳐지는 경우를 대비하여 전체 div에 id를 부여한다. */
    #geo2 > #map{
        width: 800px;
        height: 400px;
        border: 2px solid red;
    }
</style>
<script>
    let geo2 = {
        // initialize
        init: function (){
            this.mapdisplay();
            $('#btn_s').click(()=>{
                this.go(37.5447611,127.0564625);
            });
            $('#btn_b').click(()=>{
                this.go(35.2100142,129.0688702);
            });
            $('#btn_j').click(()=>{
                this.go(33.3846216,126.5534925);
            });
        },
        // map 객체 생성
        mapdisplay: function (){
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.5447611,127.0564625), // 지도의 중심좌표
                    level: 8 // 지도의 확대 레벨
                };
            geo2.map = new kakao.maps.Map(mapContainer, mapOption);

            var market_position = new kakao.maps.LatLng(37.5447611,127.0564625);
            var marker = new kakao.maps.Marker({
                position: market_position
            });
            marker.setMap(geo2.map);
        },
        // 위치 이동
        go: function (lat, lng){
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            this.map.panTo(moveLatLon);
        },
        // loc(s, b, j) : 이동하는 지역의 데이터를 가지고 온다.
        getgeodata: function (loc){},
        display: function (datas){}
    };

    $(function (){
        geo2.init();
    })
</script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="geo2">
    <h2>Geo2 Page</h2>
    <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
    <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
    <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>

    <div id="map"></div>
</div>