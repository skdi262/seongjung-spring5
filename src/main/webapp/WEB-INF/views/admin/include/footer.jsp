<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 이후 footer 영역 -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.1.0
    </div>
  </footer>

  <!-- Control Sidebar 오른쪽 메뉴판 클릭시 나오는 내용 -->
  <aside class="control-sidebar control-sidebar-dark">
   <!-- Demo.js 출력내용이 존재, 근데 새로 만들거임 ㅋ -->
   <div class="text-center mt-3" >
   <h5>로그아웃~!</h5><hr class="mb-2"/>
   <button type="btn" class="btn btn-primary" id="btn_logout">로그아웃</button>
  </aside>
</div>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery 제이쿼리 코어 -->
<script src="/resources/admin/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 제아쿼리 UI코어-->
<script src="/resources/admin/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 부트스트랩 4 코어 4 -->
<script src="/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Tempusdominus Bootstrap 4 ㄷㅅㄱㄹ 스타아ㅏㅏ-->
<!-- <script src="/resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script> -->
<!-- Summernote 웹에디터 코어 -->
<script src="/resources/admin/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars 왼쪽 스크롤 메뉴 코어-->
<script src="/resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App 어드민 LTE 테맛 ㅡ타일 -->
<script src="/resources/admin/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes 오른 쪽 메뉴 코어-->
<!-- <script src="/resources/admin/dist/js/demo.js"></script> -->
</body>
</html>