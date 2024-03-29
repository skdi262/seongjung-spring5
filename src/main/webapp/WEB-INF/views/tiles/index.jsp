<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
// 메인페이지 전용 슬라이드 호출 부분: index에서만 필요한 코드이기 때문에
$(document).ready(function() {
	// 위에서 선언한 함수|변수 사용(아래)
	//여기서 함수호출(실행)
	slideAuto = setTimeout('play_w("right")', 3000);//3초마다 play_w함수 실행
	var slidePlayHide = setTimeout(function(){
		$('.rollplay').css('display','none');
	},3000);//3초 후에 rollplay클래스 플레이버튼 영역을 숨김
	// 3개의 슬라이드 버튼 클랙 액션처리
	$('.rollstop a').click(function(){
		// this는 클릭한 본인 태그를 말합니다.
		$(this).parent().hide();//현재 stop버튼 숨김.
		$('.rollplay').css('display','inline-block');
		if(slideAuto) {
			clearTimeout(slideAuto);//slideAuto변수가 없다면, play_w함수를 실행 중지.
		}
	});
	$('.rollplay a').click(function(){
		$(this).parent().hide();// a태그의 부모 rollplay영역 입니다.
		$('.rollstop').css('display','inline-block');
		play_w('right');//3초마다 슬라이드 이미지 액션일 발생합니다.

	});
	$('.rollingbtn li.seq a').each(function(index){
		$(this).click(function(){
			$('.rollplay').hide();
			$('.rollstop').css('display','inline-block');
			if(slideAuto) {
				clearTimeout(slideAuto);//슬라이드 중지
			}
			play_w(index);//슬라이드 재생 : 단 시작위치는 클릭한 index부터 무한반복
		});
	});
});
</script>
	<!-- 메인콘텐츠영역 -->
	<div id="container">
		<!-- 모바일+PC 공통슬라이드영역 -->
    	<div class="main_rolling_pc">
            <div class="visualRoll">
            	<!-- 슬라이드이미지영역 -->
                <ul class="viewImgList">
                    <li class="imglist0">
                        <div class="roll_content">
                            <a href="javascript:;">
							<p class="roll_txtline">1OOOO OOOOOOOOO OOOOOOOOO OOOOO</p>
							</a>
                        </div>
                    </li>
                    <li class="imglist1">
                        <div class="roll_content">
                            <a href="javascript:;">
							<p class="roll_txtline">2OOOO OOOOOOOOO OOOOOOOOO OOOOO</p>
							</a>
                        </div>
                    </li>
                    <li class="imglist2">
                        <div class="roll_content">
                            <a href="javascript:;">
							<p class="roll_txtline">3OOOO OOOOOOOOO OOOOOOOOO OOOOO</p>
							</a>
                        </div>
                    </li>
                </ul>
                <!-- //슬라이드이미지영역 -->
                <!-- 슬라이드버튼영역 -->
                <div class="rollbtnArea">
                    <ul class="rollingbtn">
						<!-- butt0 a img -->
                        <li class="seq butt0"><a href="#butt"><img src="/resources/home/img/btn_rollbutt_on.png" alt="1번" /></a></li>
                        <li class="seq butt1"><a href="#butt"><img src="/resources/home/img/btn_rollbutt_off.png" alt="2번" /></a></li>
                        <li class="seq butt2"><a href="#butt"><img src="/resources/home/img/btn_rollbutt_off.png" alt="3번" /></a></li>
                        <li class="rollstop"><a href="#" class="stop"><img src="/resources/home/img/btn_roll_stop.png" alt="멈춤" /></a></li>
                        <li class="rollplay"><a href="#" class="play"><img src="/resources/home/img/btn_roll_play.png" alt="재생" /></a></li>
                    </ul>
                </div>
                <!-- //슬라이드버튼영역 -->
            </div>
        </div>
        <!-- //모바일+PC 공통슬라이드영역 -->
	
		<!-- 갤러리최근게시물영역 -->
		<div class="about_area">
			<h2>겔러리 최근 게시물 <b>TOP 3</b></h2>
			<div class="about_box">
				<ul class="place_list box_inner clear">
					<li><a href="#" onclick="$('.popup_base').css('height',$(document).height());$('.contact_pop').show();">
							<img class="img_topplace" src="/resources/home/img/no_image.jpg" alt="OOOO OOOOO" style="opacity:0.7;"/>
							<h3>OOOO OOOOO</h3>
							<p class="txt">OOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOO!</p>
							<span class="view">VIEW</span></a>
					</li>
					<li><a href="#" onclick="$('.popup_base').css('height',$(document).height());$('.space_pop').show();">
							<img class="img_topplace" src="/resources/home/img/no_image.jpg" alt="OOOO OOOOO" style="opacity:0.7;"/>
							<h3>OOOO OOOOO</h3>
							<p class="txt">OOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOO.</p>
							<span class="view">VIEW</span></a>
					</li>
					<li><a href="#" onclick="$('.popup_base').css('height',$(document).height());$('.program_pop').show();">
							<img class="img_topplace" src="/resources/home/img/no_image.jpg" alt="OOOO OOOOO" style="opacity:0.7;"/>
							<h3>OOOO OOOOO</h3>
							<p class="txt">OOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOOOOOO OOOOO</p>
							<span class="view">VIEW</span></a>
					</li>
				</ul>
			</div>
		</div>
		<!-- //갤러리최근게시물영역 -->

		<!-- 카카오톡상담및최근공지사항영역 -->
		<div class="appbbs_area">
			<div class="appbbs_box box_inner clear">
				<h2 class="hdd">상담과 최근게시물</h2>
				<p class="app_line">
					<a href="javascript:;">카카오톡 1:1 상담</a>
					<a href="javascript:;">전화 상담 신청</a>
				</p>
				<div class="bbs_line">
					<h3>NOTICE</h3>
					<ul class="notice_recent">
						<li><a href="javascript:;">OOOO OOOOO (스프링OOOO OOOOO)</a></li>
						<li><a href="javascript:;">OOOO OOOOOOOOO OOOOO</a></li>
						<li><a href="javascript:;">OOOO OOOOO/OOOO OOOOO</a></li>
						<li><a href="javascript:;">OOOO OOOOO OPEN! (스프링정보, OOOO OOOOO)</a></li>
						<li><a href="javascript:;">OOOO OOOOO 서비스 점검 안내</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- //카카오톡상담및최근공지사항영역 -->
	</div>
	<!-- //메인콘텐츠영역 -->
	