<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | 대시보드</title>
  <!-- Google Font: Source Sans Pro 구글웹폰트 -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome 폰트어썸 -->
  <link rel="stylesheet" href="/resources/admin/plugins/fontawesome-free/css/all.min.css">
  <!-- Tempusdominus Bootstrap 4 부트스트랩4 -->
  <link rel="stylesheet" href="/resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- Theme style AdminLTE 테마스타일 -->
  <link rel="stylesheet" href="/resources/admin/dist/css/adminlte.min.css">
  <!-- overlayScrollbars 왼쪽스크롤메뉴 -->
  <link rel="stylesheet" href="/resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- summernote 웹에디터 -->
  <link rel="stylesheet" href="/resources/admin/plugins/summernote/summernote-bs4.min.css">
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader A로고 로딩중...표시 -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar 햄버거메뉴 라인 부분 -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links 왼쪽 햄버거 메뉴와 Home링크메뉴 -->
    <ul class="navbar-nav">
      <li class="nav-item"> 
        <a class="nav-link" data-widget="pushmenu" href="/admin" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="/admin" class="nav-link">Home</a>
      </li>
    </ul>
    <!-- Right navbar links 오른쪽 아이콘 메뉴 -->
    <ul class="navbar-nav ml-auto">
     
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container 왼쪽 사이드메뉴내용 -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/admin" class="brand-link">
      <img src="/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">스프링5프로젝트</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) 로그인한 정보 -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="/resources/admin/dist/img/avatar3.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">로그인한 ID</a>
        </div>
      </div>

      <!-- SidebarSearch Form 검색폼 -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu 메뉴시작 -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column nav-treeview" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          
          <li class="nav-item">
            <a href="/" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                사용자홈
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/member/member_list?search_keyword=" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>관리자관리</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/admin/bbs_type/bbs_type_list" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>게시판생성관리</p>
            </a>
          </li>
          <li class="nav-item menu-open">
            <a href="#" class="nav-link">
              <i class="far fa-circle nav-icon"></i>
              <p>게시물관리
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <!-- 위 게시판 생성관리에서 만든 게시판 개수에 따라서 자동 증가(아래) -->
              <c:forEach var="boardTypeVO" items="${listBoardTypeVO}">
              <li class="nav-item">
                <a href="/admin/board/board_list?board_type=${boardTypeVO.board_type}&search_keyword=" class="nav-link ${boardTypeVO.board_type==session_board_type?'active':''}">
                  <i class="far fa-dot-circle nav-icon"></i>
                  <p>${boardTypeVO.board_name}</p>
                </a>
              </li>
              </c:forEach>
            </ul>
          </li>
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
<!-- 여기까지 header.jsp영역 -->