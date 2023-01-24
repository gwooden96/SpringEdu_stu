<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC02</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  	$(document).ready(function(){
  		loadList();
  	});
	
  	function loadList() {
		// 서버와 통신 : 게시판 리스트 가져오기
			$.ajax({
				url : "boardList.do",
				type : "get",
				dataType : "json",
				success : makeView,
				error : function() { alert("error"); }
			});
	}
  	function makeView(data) { // data[{ },{ },{ },,,]
        var listHtml="<table class='table table-bordered'>";
        listHtml+="<tr>";
        listHtml+="<td>번호</td>";
        listHtml+="<td>제목</td>";
        listHtml+="<td>작성자</td>";
        listHtml+="<td>작성일</td>";
        listHtml+="<td>조회수</td>";
        listHtml+="</tr>";
       $.each(data,function(index,obj){ // obj={"idx":5,"title:","게시판"~~}
           listHtml+="<tr>";
            listHtml+="<td>"+ obj.idx +"</td>";
            listHtml+="<td>"+ obj.title +"</td>";
            listHtml+="<td>"+ obj.writer +"</td>";
            listHtml+="<td>"+ obj.indate +"</td>";
            listHtml+="<td>"+ obj.count+ "</td>";
            listHtml+="</tr>";
       });
       listHtml+="</table>";
         $("#view").html(listHtml);

		
		
	}
  	</script>
</head>
<body>

<div class="container">
  <h2>Spring MVC02</h2>
  <div class="panel panel-default">
    <div class="panel-heading">BOARD</div>
    <div class="panel-body" id="view">Panel Content</div>
    <div class="panel-footer">인프런_스프1탄_지우든</div>
  </div>
</div>

</body>
</html>