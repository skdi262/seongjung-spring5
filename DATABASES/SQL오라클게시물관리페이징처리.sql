--SQL 쿼리로 페이징을 구현해 변수로 삼을 것을 정의
--PageVO의 멤버 변수로 사용 - >게시물때무에 board_type 멤버변수로 추가
SELECT TableB.* FROM (

    SELECT ROWNUM AS RNUM, TableA.* FROM (
    SELECT * FROM tbl_board
where board_type = 'notice' --게시물 관리때문에 추가한 코드
and (title like '%%'
or content like '%%')
order by reg_date DESC
) TableA WHERE ROWNUM <= (2*5) + 5 -- 0부터 선택한 페이지 
) TableB WHERE TableB.RNUM > 2*5 -- 현재페이지당 보여줄 개수
-- 페이징 쿼리에서 필요한 변수는 2개 
-- 현재페이지변수 : page*queryPerPageNum == queryStartNo
-- 1페이지당 보여줄 개수의 변수 : b = 10 : queryPerPageNum
-- PageVO에서 필요한 추가 변수 : page
-- UI하단의 페이지 선택개수의 변수 c : perPageNum
-- perPageNum 변수 받아서 StartPage, endPage를 구해서
-- 하단의 페이지선택 번호 출력 