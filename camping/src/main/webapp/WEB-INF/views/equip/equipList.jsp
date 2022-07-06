<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<h1>equipList</h1>


<h2>${count}</h2>
<h2>${filpara}</h2>



	<table border="2" width="1800" cellpadding="0" cellspacing="0" align="center"> 
	
		<tr height="50">
	      <td align="center" width="1800" colspan="5"> <a href="/equip/list?cat=0${filpara}"> 전체보기 </a> </td>
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  ><a href="/equip/list?cat=1">텐트</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=2">타프</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=3">매트</a></td>
	      <td align="center"  width="180" ><a href="/equip/list?cat=4">침낭</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=5">의자/테이블</a></td>  
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  ><a href="/equip/list?cat=6">아이스박스/물통/웨건</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=7">조리도구</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=8">취사용품</a></td>
	      <td align="center"  width="180" ><a href="/equip/list?cat=9">연료</a></td> 
	      <td align="center"  width="180" ><a href="/equip/list?cat=10">랜턴/라이트</a></td>  
	    </tr>
	    

	
	
	</table>
	</br></br></br></br>
	
	<c:if test="${category == 1 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		<tr height="50">
	      <td align="center" width="1600" colspan="5"> 검색필터 </td>	
	    </tr>
		
		
				
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '아이두젠')}">
	      <td align="center"  width="180" > 아이두젠 : <input type="checkbox" name="bran"  value="아이두젠" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '아이두젠')}">
	      <td align="center"  width="180" > 아이두젠 : <input type="checkbox" name="bran" value="아이두젠"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '네이처하이크')}">
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran"  value="네이처하이크" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '네이처하이크')}">
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran"  value="네이처하이크" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '비에프엘')}">
	      <td align="center"  width="180" > 비에프엘 : <input type="checkbox" name="bran"  value="비에프엘" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '비에프엘')}">
	      <td align="center"  width="180" > 비에프엘 : <input type="checkbox" name="bran"  value="비에프엘" ></td>
	      </c:if> 

	    </tr>
	    
		<tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '캐빈텐트')}">
	      <td align="center"  width="180" > 캐빈텐트 : <input type="checkbox" name="fil1"  value="캐빈텐트" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '캐빈텐트')}">
	      <td align="center"  width="180" > 캐빈텐트 : <input type="checkbox" name="fil1" value="캐빈텐트"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '돔텐트')}">
	      <td align="center"  width="180" > 돔텐트 : <input type="checkbox" name="fil1"  value="돔텐트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '돔텐트')}">
	      <td align="center"  width="180" > 돔텐트 : <input type="checkbox" name="fil1"  value="돔텐트" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '그늘막텐트')}">
	      <td align="center"  width="180" > 그늘막텐트 : <input type="checkbox" name="fil1"  value="그늘막텐트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '그늘막텐트')}">
	      <td align="center"  width="180" > 그늘막텐트 : <input type="checkbox" name="fil1"  value="그늘막텐트" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '터널형텐트')}">
	      <td align="center"  width="180" > 터널형텐트 : <input type="checkbox" name="fil1"  value="터널형텐트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '터널형텐트')}">
	      <td align="center"  width="180" > 터널형텐트 : <input type="checkbox" name="fil1"  value="터널형텐트" ></td>
	      </c:if> 

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 사용인원 </td> 
	      	      <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=1')}">
	      <td align="center"  width="180" > 1~2인용 : <input type="checkbox" name="fil7"  value="1" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=1')}">
	      <td align="center"  width="180" > 1~2인용 : <input type="checkbox" name="fil7"  value="1" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=3')}">
	      <td align="center"  width="180" > 3~4인용 : <input type="checkbox" name="fil7"  value="3" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=3')}">
	      <td align="center"  width="180" > 3~4인용 : <input type="checkbox" name="fil7"  value="3" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=6')}">
	      <td align="center"  width="180" > 6인이상 : <input type="checkbox" name="fil7"  value="6" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=6')}">
	      <td align="center"  width="180" > 6인이상 : <input type="checkbox" name="fil7"  value="6" ></td>
	      </c:if> 
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 내수압 </td> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=1000')}">
	      <td align="center"  width="180" > 1000mm 이하 : <input type="checkbox" name="fil8"  value="1000" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=1000')}">
	      <td align="center"  width="180" > 1000mm 이하 : <input type="checkbox" name="fil8" value="1000"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=1001')}">
	      <td align="center"  width="180" > 1000mm~2000mm : <input type="checkbox" name="fil8"  value="1001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=1001')}">
	      <td align="center"  width="180" > 1000mm~2000mm : <input type="checkbox" name="fil8" value="1001"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=2001')}">
	      <td align="center"  width="180" > 2000mm~3000mm : <input type="checkbox" name="fil8"  value="2001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=2001')}">
	      <td align="center"  width="180" > 2000mm~3000mm : <input type="checkbox" name="fil8" value="2001"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=3001')}">
	      <td align="center"  width="180" > 3000mm 이상 : <input type="checkbox" name="fil8"  value="3001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=3001')}">
	      <td align="center"  width="180" > 3000mm 이상 : <input type="checkbox" name="fil8" value="3001"  ></td>
	      </c:if> 
	        
	    </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
		
	
	
	

	
		
	</br></br>
	
	</c:if>
	
	
		<c:if test="${category == 2 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '비에프엘')}">
	      <td align="center"  width="180" > 비에프엘 : <input type="checkbox" name="bran"  value="비에프엘" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '비에프엘')}">
	      <td align="center"  width="180" > 비에프엘 : <input type="checkbox" name="bran" value="비에프엘"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '아이두젠')}">
	      <td align="center"  width="180" > 아이두젠 : <input type="checkbox" name="bran"  value="아이두젠" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '아이두젠')}">
	      <td align="center"  width="180" > 아이두젠 : <input type="checkbox" name="bran"  value="아이두젠" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '콜맨')}">
	      <td align="center"  width="180" > 콜맨 : <input type="checkbox" name="bran"  value="콜맨" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '콜맨')}">
	      <td align="center"  width="180" > 콜맨 : <input type="checkbox" name="bran"  value="콜맨" ></td>
	      </c:if> 
	    </tr>
	    
	    <tr height="50">
	      
	      <td align="center"  width="180"  > 종류 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '스킨')}">
	      <td align="center"  width="180" > 스킨 : <input type="checkbox" name="fil1"  value="스킨" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '스킨')}">
	      <td align="center"  width="180" > 스킨 : <input type="checkbox" name="fil1" value="스킨"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '스킨+폴')}">
	      <td align="center"  width="180" > 스킨+폴 : <input type="checkbox" name="fil1"  value="스킨+폴" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '스킨+폴')}">
	      <td align="center"  width="180" > 스킨+폴 : <input type="checkbox" name="fil1"  value="스킨+폴" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '파라솔')}">
	      <td align="center"  width="180" > 파라솔 : <input type="checkbox" name="fil1"  value="파라솔" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '파라솔')}">
	      <td align="center"  width="180" > 파라솔 : <input type="checkbox" name="fil1"  value="파라솔" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '스크린')}">
	      <td align="center"  width="180" > 스크린 : <input type="checkbox" name="fil1"  value="스크린" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '스크린')}">
	      <td align="center"  width="180" > 스크린 : <input type="checkbox" name="fil1"  value="스크린" ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '사이드월')}">
	      <td align="center"  width="180" > 사이드월 : <input type="checkbox" name="fil1"  value="사이드월" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '사이드월')}">
	      <td align="center"  width="180" > 사이드월 : <input type="checkbox" name="fil1"  value="사이드월" ></td>
	      </c:if> 
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 내수압 </td> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=1000')}">
	      <td align="center"  width="180" > 1000mm 이하 : <input type="checkbox" name="fil8"  value="1000" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=1000')}">
	      <td align="center"  width="180" > 1000mm 이하 : <input type="checkbox" name="fil8" value="1000"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=1001')}">
	      <td align="center"  width="180" > 1000mm~2000mm : <input type="checkbox" name="fil8"  value="1001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=1001')}">
	      <td align="center"  width="180" > 1000mm~2000mm : <input type="checkbox" name="fil8" value="1001"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=2001')}">
	      <td align="center"  width="180" > 2000mm~3000mm : <input type="checkbox" name="fil8"  value="2001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=2001')}">
	      <td align="center"  width="180" > 2000mm~3000mm : <input type="checkbox" name="fil8" value="2001"  ></td>
	      </c:if> 
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, 'fil8=3001')}">
	      <td align="center"  width="180" > 3000mm 이상 : <input type="checkbox" name="fil8"  value="3001" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil8=3001')}">
	      <td align="center"  width="180" > 3000mm 이상 : <input type="checkbox" name="fil8" value="3001"  ></td>
	      </c:if> 
	        
	    </tr>
	    
	     <tr height="50"> 
	      <td align="center"  width="180"  > 재질 </td> 
	      
		  <c:if test="${fn:containsIgnoreCase(filpara, '폴리에스테르')}">
	      <td align="center"  width="180" > 폴리에스테르 : <input type="checkbox" name="fil2"  value="폴리에스테르" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '폴리에스테르')}">
	      <td align="center"  width="180" > 폴리에스테르 : <input type="checkbox" name="fil2" value="폴리에스테르"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '나일론')}">
	      <td align="center"  width="180" > 나일론 : <input type="checkbox" name="fil2"  value="나일론" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '나일론')}">
	      <td align="center"  width="180" > 나일론 : <input type="checkbox" name="fil2"  value="나일론" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '블랙코팅')}">
	      <td align="center"  width="180" > 블랙코팅 : <input type="checkbox" name="fil2"  value="블랙코팅" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '블랙코팅')}">
	      <td align="center"  width="180" > 블랙코팅 : <input type="checkbox" name="fil2"  value="블랙코팅" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '면')}">
	      <td align="center"  width="180" > 면 : <input type="checkbox" name="fil2"  value="면" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '면')}">
	      <td align="center"  width="180" > 면 : <input type="checkbox" name="fil2"  value="면" ></td>
	      </c:if>  
	     </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	    
	    
	
	


	
		
	</br></br>
	
	</c:if>
	
	
		<c:if test="${category == 3 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	       <c:if test="${fn:containsIgnoreCase(filpara, '인텍스')}">
	      <td align="center"  width="180" > 인텍스 : <input type="checkbox" name="bran"  value="인텍스" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '인텍스')}">
	      <td align="center"  width="180" > 인텍스 : <input type="checkbox" name="bran" value="인텍스"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '네이처하이크')}">
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran"  value="네이처하이크" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '네이처하이크')}">
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran"  value="네이처하이크" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '씨투써미트')}">
	      <td align="center"  width="180" > 씨투써미트 : <input type="checkbox" name="bran"  value="씨투써미트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '씨투써미트')}">
	      <td align="center"  width="180" > 씨투써미트 : <input type="checkbox" name="bran"  value="씨투써미트" ></td>
	      </c:if> 

		   <c:if test="${fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '코베아')}">
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran"  value="코베아" ></td>
	      </c:if>
	      
	       <c:if test="${fn:containsIgnoreCase(filpara, '파크론')}">
	      <td align="center"  width="180" > 파크론 : <input type="checkbox" name="bran"  value="파크론" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '파크론')}">
	      <td align="center"  width="180" > 파크론 : <input type="checkbox" name="bran"  value="파크론" ></td>
	      </c:if>
	      
	       
	
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '에어매트')}">
	      <td align="center"  width="180" > 에어매트 : <input type="checkbox" name="fil1"  value="에어매트" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '에어매트')}">
	      <td align="center"  width="180" > 에어매트 : <input type="checkbox" name="fil1" value="에어매트"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '엠보싱매트')}">
	      <td align="center"  width="180" > 엠보싱매트 : <input type="checkbox" name="fil1"  value="엠보싱매트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '엠보싱매트')}">
	      <td align="center"  width="180" > 엠보싱매트 : <input type="checkbox" name="fil1"  value="엠보싱매트" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '피크닉매트')}">
	      <td align="center"  width="180" > 피크닉매트 : <input type="checkbox" name="fil1"  value="피크닉매트" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '피크닉매트')}">
	      <td align="center"  width="180" > 피크닉매트 : <input type="checkbox" name="fil1"  value="피크닉매트" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '에어소파')}">
	      <td align="center"  width="180" > 에어소파 : <input type="checkbox" name="fil1"  value="에어소파" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '에어소파')}">
	      <td align="center"  width="180" > 에어소파 : <input type="checkbox" name="fil1"  value="에어소파" ></td>
	      </c:if> 
	      
	        <c:if test="${fn:containsIgnoreCase(filpara, '에어펌프')}">
	      <td align="center"  width="180" > 에어펌프 : <input type="checkbox" name="fil1"  value="에어펌프" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '에어펌프')}">
	      <td align="center"  width="180" > 에어펌프 : <input type="checkbox" name="fil1"  value="에어펌프" ></td>
	      </c:if> 
	      
	        <c:if test="${fn:containsIgnoreCase(filpara, '돗자리')}">
	      <td align="center"  width="180" > 돗자리 : <input type="checkbox" name="fil1"  value="돗자리" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '돗자리')}">
	      <td align="center"  width="180" > 돗자리 : <input type="checkbox" name="fil1"  value="돗자리" ></td>
	      </c:if> 
	    </tr>
	    
	   
		<tr height="50"> 
	     <td align="center"  width="180"  > 사용인원 </td> 
	      	      <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=1')}">
	      <td align="center"  width="180" > 1~2인용 : <input type="checkbox" name="fil7"  value="1" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=1')}">
	      <td align="center"  width="180" > 1~2인용 : <input type="checkbox" name="fil7"  value="1" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=3')}">
	      <td align="center"  width="180" > 3~4인용 : <input type="checkbox" name="fil7"  value="3" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=3')}">
	      <td align="center"  width="180" > 3~4인용 : <input type="checkbox" name="fil7"  value="3" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, 'fil7=6')}">
	      <td align="center"  width="180" > 6인이상 : <input type="checkbox" name="fil7"  value="6" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, 'fil7=6')}">
	      <td align="center"  width="180" > 6인이상 : <input type="checkbox" name="fil7"  value="6" ></td>
	      </c:if> 
	        
	    </tr>
	    
	     <tr height="50"> 
	      <td align="center"  width="180"  > 사용장소 </td> 
	       <c:if test="${fn:containsIgnoreCase(filpara, '아웃도어용')}">
	      <td align="center"  width="180" > 아웃도어용 : <input type="checkbox" name="fil2"  value="아웃도어용" checked="checked" ></td>
	      </c:if> 
	      <c:if test="${!fn:containsIgnoreCase(filpara, '아웃도어용')}">
	      <td align="center"  width="180" > 아웃도어용 : <input type="checkbox" name="fil2" value="아웃도어용"  ></td>
	      </c:if> 
	      
	      <c:if test="${fn:containsIgnoreCase(filpara, '텐트내부용')}">
	      <td align="center"  width="180" > 텐트내부용 : <input type="checkbox" name="fil2"  value="텐트내부용" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '텐트내부용')}">
	      <td align="center"  width="180" > 텐트내부용 : <input type="checkbox" name="fil2"  value="텐트내부용" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '내부+아웃도어용')}">
	      <td align="center"  width="180" > 내부+아웃도어용 : <input type="checkbox" name="fil2"  value="내부+아웃도어용" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '내부+아웃도어용')}">
	      <td align="center"  width="180" > 내부+아웃도어용 : <input type="checkbox" name="fil2"  value="내부+아웃도어용" ></td>
	      </c:if> 

		  
	        
	    </tr>
	    
	     <tr height="50"> 
	      <td align="center"  width="180"  > 보관형태 </td> 
	      <c:if test="${fn:containsIgnoreCase(filpara, '접이식')}">
	      <td align="center"  width="180" > 접이식 : <input type="checkbox" name="fil3"  value="접이식" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '접이식')}">
	      <td align="center"  width="180" > 접이식 : <input type="checkbox" name="fil3"  value="접이식" ></td>
	      </c:if> 

		  <c:if test="${fn:containsIgnoreCase(filpara, '말이식')}">
	      <td align="center"  width="180" > 말이식 : <input type="checkbox" name="fil3"  value="말이식" checked="checked"></td>
	      </c:if>
	      
	      <c:if test="${!fn:containsIgnoreCase(filpara, '말이식')}">
	      <td align="center"  width="180" > 말이식 : <input type="checkbox" name="fil3"  value="말이식" ></td>
	      </c:if> 
		 </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
		
	</br></br>
	</c:if>
	
					<c:if test="${category == 4 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 반고 : <input type="checkbox" name="bran" value="반고"></td> 
	      <td align="center"  width="180" > 씨투써미트 : <input type="checkbox" name="bran" value="씨투써미트"></td>
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran" value="네이처하이크"></td>
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran" value="코베아"></td>
	      <td align="center"  width="180" > 메사 : <input type="checkbox" name="bran" value="메사"></td>  
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 침낭 : <input type="checkbox" name="fil1" value="침낭"></td> 
	      <td align="center"  width="180" > 배개 : <input type="checkbox" name="fil1" value="배개"></td>
	      <td align="center"  width="180" > 라이너 : <input type="checkbox" name="fil1" value="라이너"></td>
	      <td align="center"  width="180" > 담요 : <input type="checkbox" name="fil1" value="담요"></td>

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 형태 </td> 
	      <td align="center"  width="180" > 사각 : <input type="checkbox" name="fil2" value="사각"></td> 
	      <td align="center"  width="180" > 머미(미이라형) : <input type="checkbox" name="fil2" value="머미(미이라형)"></td>
	      <td align="center"  width="180" > 사각(후드형) : <input type="checkbox" name="fil2" value="사각(후드형)"></td>
	      <td align="center"  width="180" > 입는형 : <input type="checkbox" name="fil2" value="입는형"></td>
	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 사용계절 </td> 
	      <td align="center"  width="180" > 여름용 : <input type="checkbox" name="fil3" value="여름용"></td> 
	      <td align="center"  width="180" > 사계절용 : <input type="checkbox" name="fil3" value="사계절용"></td>
	      <td align="center"  width="180" > 봄,가을용 : <input type="checkbox" name="fil3" value="봄,가을용"></td>
	      <td align="center"  width="180" > 겨울용 : <input type="checkbox" name="fil3" value="겨울용"></td>
	    </tr>
	    
	     <tr height="50"> 
	      <td align="center"  width="180"  > 충전재 </td> 
	      <td align="center"  width="180" > 폴리에스테르 :<input type="checkbox" name="fil4" value="아웃도어용"></td> 
	      <td align="center"  width="180" > 홀로파이버 : <input type="checkbox" name="fil4" value="텐트내부용"></td>
	      <td align="center"  width="180" > 거위털 :  <input type="checkbox" name="fil4" value="텐트내부+아웃도어용"></td>
	      <td align="center"  width="180" > 거위털 :  <input type="checkbox" name="fil4" value="텐트내부+아웃도어용"></td>
	      <td align="center"  width="180" > 거위털 :  <input type="checkbox" name="fil4" value="텐트내부+아웃도어용"></td>
	        
	    </tr>
	    
	     <tr height="50"> 
	      <td align="center"  width="180"  > 내한온도 </td> 
	      <td align="center"  width="180" > -69도 ~ -50도 <input type="checkbox" name="fil11" value="-50"></td> 
	      <td align="center"  width="180" > -49도 ~ -30도 <input type="checkbox" name="fil11" value="-30"></td>
	      <td align="center"  width="180" > -29도 ~ -10도 <input type="checkbox" name="fil11" value="-10"></td>
	      <td align="center"  width="180" > -10도 이상 <input type="checkbox" name="fil11" value="0"></td>

 		</tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
		
	</br></br>
	</c:if>
	
	
	
			<c:if test="${category == 5 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 카즈미 : <input type="checkbox" name="bran" value="카즈미"></td> 
	      <td align="center"  width="180" > 콜맨 : <input type="checkbox" name="bran" value="콜맨" ></td>
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran" value="코베아" ></td>
	      <td align="center"  width="180" > 네이처하이크 : <input type="checkbox" name="bran" value="네이처하이크" ></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 의자 : <input type="checkbox" name="fil1" value="의자"></td> 
	      <td align="center"  width="180" > 침대 : <input type="checkbox" name="fil1" value="침대"></td>
	      <td align="center"  width="180" > 테이블 : <input type="checkbox" name="fil1" value="테이블"></td>
	      <td align="center"  width="180" > 가구 : <input type="checkbox" name="fil1" value="가구"></td>

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 재질 </td> 
	      <td align="center"  width="180" > 알루미늄 : <input type="checkbox" name="fil2" value="알루미늄"></td> 
	      <td align="center"  width="180" > 스틸 : <input type="checkbox" name="fil2" value="스틸"></td>
	      <td align="center"  width="180" > 두랄루민 : <input type="checkbox" name="fil2" value="두랄루민"></td>
	      <td align="center"  width="180" > 나무 : <input type="checkbox" name="fil2" value="나무"></td>
	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 내하중 </td> 
	      <td align="center"  width="180" > 100KG 이하 : <input type="checkbox" name="fil12" value="100"></td> 
	      <td align="center"  width="180" > 100KG~120KG : <input type="checkbox" name="fil12" value="120"></td>
	      <td align="center"  width="180" > 120KG 이상 : <input type="checkbox" name="fil12" value="121"></td>
	    </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	</br></br>
	</c:if>
	
	
			
	
					<c:if test="${category == 6 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 콜맨 : <input type="checkbox" name="bran" value="콜맨"></td> 
	      <td align="center"  width="180" > 스탠리 : <input type="checkbox" name="bran" value="스탠리"></td>
	      <td align="center"  width="180" > 코스모스 : <input type="checkbox" name="bran" value="코스모스"></td>
	      <td align="center"  width="180" > 다이와 : <input type="checkbox" name="bran" value="다이와"></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 물통 : <input type="checkbox" name="fil1" value="물통"></td> 
	      <td align="center"  width="180" > 아이스박스 : <input type="checkbox" name="fil1" value="아이스박스"></td>
	      <td align="center"  width="180" > 웨건 : <input type="checkbox" name="fil1" value="웨건"></td>
	      <td align="center"  width="180" > 쿨러백 : <input type="checkbox" name="fil1" value="쿨러백"></td>
	      <td align="center"  width="180" > 기타 : <input type="checkbox" name="fil1" value="기타"></td>

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 용량 </td> 
	      <td align="center"  width="180" > 10L이하 : <input type="checkbox" name="fil9" value="10"></td> 
	      <td align="center"  width="180" > 10L~20L : <input type="checkbox" name="fil9" value="20"></td>
	      <td align="center"  width="180" > 20L~40L : <input type="checkbox" name="fil9" value="40"></td>
	      <td align="center"  width="180" > 40L이상 : <input type="checkbox" name="fil9" value="41~"></td>
	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 재질 </td> 
	      <td align="center"  width="180" > 스테인리스 : <input type="checkbox" name="fil3" value="스테인리스"></td> 
	      <td align="center"  width="180" > 스틸 : <input type="checkbox" name="fil3" value="스틸"></td>
	      <td align="center"  width="180" > 알루미늄 : <input type="checkbox" name="fil3" value="알루미늄"></td>
	      <td align="center"  width="180" > 플라스틱 : <input type="checkbox" name="fil3" value="플라스틱"></td>
	       </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	</br></br>
	</c:if>
	
	
		<c:if test="${category == 7 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 스노우피크 : <input type="checkbox" name="bran" value="스노우피크"></td> 
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran" value="코베아"></td>
	      <td align="center"  width="180" > 캠핑문 : <input type="checkbox" name="bran" value="캠핑문"></td>
	      <td align="center"  width="180" > 노마드 : <input type="checkbox" name="bran" value="노마드"></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 코펠 : <input type="checkbox" name="fil1" value="코펠"></td> 
	      <td align="center"  width="180" > 컵 : <input type="checkbox" name="fil1" value="컵"></td>
	      <td align="center"  width="180" > 팬 : <input type="checkbox" name="fil1" value="팬"></td>
	      <td align="center"  width="180" > 취사용품 : <input type="checkbox" name="fil1" value="취사용품"></td>
	      <td align="center"  width="180" > 식기 : <input type="checkbox" name="fil1" value="식기"></td>
	      <td align="center"  width="180" > 기타 : <input type="checkbox" name="fil1" value="기타"></td>

	    </tr>
	    
		<tr height="50"> 
	      <td align="center"  width="180"  > 사용인원 </td> 
	      <td align="center"  width="180" > 1~2인용 : <input type="checkbox" name="fil7" value="1"></td> 
	      <td align="center"  width="180" > 3~4인용 : <input type="checkbox" name="fil7" value="3"></td>
	      <td align="center"  width="180" > 6인이상 : <input type="checkbox" name="fil7" value="6"></td>
	        
	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 재질 </td> 
	      <td align="center"  width="180" > 스테인리스 : <input type="checkbox" name="fil3" value="스테인리스"></td> 
	      <td align="center"  width="180" > 스틸 : <input type="checkbox" name="fil3" value="스틸"></td>
	      <td align="center"  width="180" > 알루미늄 : <input type="checkbox" name="fil3" value="알루미늄"></td>
	      <td align="center"  width="180" > 플라스틱 : <input type="checkbox" name="fil3" value="플라스틱"></td>
	      
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 세트유무 </td> 
	      <td align="center"  width="180" > 유 : <input type="checkbox" name="fil4" value="유"></td> 
	      <td align="center"  width="180" > 무 : <input type="checkbox" name="fil4" value="무"></td>
	       </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	</br></br>
	</c:if>
	
	
			<c:if test="${category == 8 }">
	
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran" value="코베아"></td> 
	      <td align="center"  width="180" > 지라프 : <input type="checkbox" name="bran" value="지라프"></td>
	      <td align="center"  width="180" > 꾸버스 : <input type="checkbox" name="bran" value="꾸버스"></td>
	      <td align="center"  width="180" > 노마드 : <input type="checkbox" name="bran" value="노마드"></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 화로 : <input type="checkbox" name="fil1" value="화로"></td> 
	      <td align="center"  width="180" > 토치 : <input type="checkbox" name="fil1" value="토치"></td>
	      <td align="center"  width="180" > 가스레인지 : <input type="checkbox" name="fil1" value="가스레인지"></td>
	      <td align="center"  width="180" > 가스그릴 : <input type="checkbox" name="fil1" value="가스그릴"></td>
	      <td align="center"  width="180" > 버너 : <input type="checkbox" name="fil1" value="버너"></td>
	      

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 화구 </td> 
	      <td align="center"  width="180" > 1구 : <input type="checkbox" name="fil2" value="1"></td> 
	      <td align="center"  width="180" > 2구 : <input type="checkbox" name="fil2" value="2"></td>
	      

	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 사용연료 </td> 
	      <td align="center"  width="180" > 장작 : <input type="checkbox" name="fil3" value="장작"></td> 
	      <td align="center"  width="180" > 가스 : <input type="checkbox" name="fil3" value="가스"></td>
	      <td align="center"  width="180" > 숯 : <input type="checkbox" name="fil3" value="숯"></td>
	      
	      
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 추가세트 </td> 
	      <td align="center"  width="180" > 유 : <input type="checkbox" name="fil4" value="유"></td> 
	      <td align="center"  width="180" > 무 : <input type="checkbox" name="fil4" value="무"></td>
	      </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	</br></br>
	</c:if>
	
				<c:if test="${category == 9 }">
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 꾸버스 : <input type="checkbox" name="bran" value="꾸버스"></td> 
	      <td align="center"  width="180" > 코베아 : <input type="checkbox" name="bran" value="코베아"></td>
	      <td align="center"  width="180" > 숯깨비 : <input type="checkbox" name="bran" value="숯깨비"></td>
	      <td align="center"  width="180" > 맥선 : <input type="checkbox" name="bran" value="맥선"></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 가스 : <input type="checkbox" name="fil1" value="가스"></td> 
	      <td align="center"  width="180" > 이소가스 : <input type="checkbox" name="fil1" value="이소가스"></td>
	      <td align="center"  width="180" > 장작 : <input type="checkbox" name="fil1" value="장작"></td>
	      <td align="center"  width="180" > 숯 : <input type="checkbox" name="fil1" value="숯"></td>
	      <td align="center"  width="180" > 등유 : <input type="checkbox" name="fil1" value="등유"></td>
 </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	
	</br></br>
	</c:if>
	
	
					<c:if test="${category == 10 }">
	<table border="2" width="1600" cellpadding="0" cellspacing="0" align="center">
	<form action="/equip/list">
		<input type="hidden" name="cat" value="${category}">
		
		<tr height="50">
	      <td align="center" width="1600" colspan="6"> 검색필터 </td>	
	    </tr>
		
		
		<tr height="50"> 
	      <td align="center"  width="180"  > 브랜드 </td> 
	      <td align="center"  width="180" > 프리즘 : <input type="checkbox" name="bran" value="프리즘"></td> 
	      <td align="center"  width="180" > 우신벨로프 : <input type="checkbox" name="bran" value="우신벨로프"></td>
	      <td align="center"  width="180" > 동화상사 : <input type="checkbox" name="bran" value="동화상사"></td>
	      <td align="center"  width="180" > 데스트 : <input type="checkbox" name="bran" value="데스트"></td>
	        
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 종류 </td> 
	      <td align="center"  width="180" > 손전등 : <input type="checkbox" name="fil1" value="손전등"></td> 
	      <td align="center"  width="180" > 헤드랜턴 : <input type="checkbox" name="fil1" value="헤드랜턴"></td>
	      <td align="center"  width="180" > 실낸등 : <input type="checkbox" name="fil1" value="실낸등"></td>
	      <td align="center"  width="180" > 작업등 : <input type="checkbox" name="fil1" value="작업등"></td>
	      
	      

	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 배터리 </td> 
	      <td align="center"  width="180" > 충전식 : <input type="checkbox" name="fil2" value="1"></td> 
	      <td align="center"  width="180" > 건전지 : <input type="checkbox" name="fil2" value="2"></td>
	    </tr>
	    
	   
	    <tr height="50"> 
	      <td align="center"  width="180"  > 밝기 </td> 
	      <td align="center"  width="180" > 1000루멘이하 : <input type="checkbox" name="fil10" value="1000"></td> 
	      <td align="center"  width="180" > 1000루멘~2000루멘 : <input type="checkbox" name="fil10" value="2000"></td>
	      <td align="center"  width="180" > 2000루멘이상 : <input type="checkbox" name="fil10" value="2001"></td>
	      
	      
	    </tr>
	    
	    <tr height="50"> 
	      <td align="center"  width="180"  > 충전연료 </td> 
	      <td align="center"  width="180" > 전기 : <input type="checkbox" name="fil4" value="전기"></td> 
	      <td align="center"  width="180" > 가스 : <input type="checkbox" name="fil4" value="가스"></td>
	       </tr>
	    
	    <tr height="50">
	      <td align="center" width="1600" colspan="5"> <input type="submit" value="검색"> </td>	
	    </tr>
	    
	    </form>
	    
		</table>
	
	</br></br>
	</c:if>
	
	
	
	<table border="1" width="1800" cellpadding="0" cellspacing="0" align="center"> 
	    <tr height="30" bgcolor="${value_c}"> 
	      <td align="center"  width="200"  >사진</td> 
	      <td align="center"  width="300" >장비명</td> 
	      <td align="center"  width="100" >가격</td>
	      <td align="center"  width="50" >별점</td> 
	      <td align="center"  width="150" >등록일</td>  
	    </tr>
	    
	    <c:forEach var="equip" items="${EquipList}">
	    
	    <tr height="10">
	    
	    <td align="center">
		<a href="${equip.url_name}"><img src="${equip.image}" width="200" height="150" ></a>
	    </td>
	    
	    <td align="center">
	    <a href="${equip.url_name}">${equip.title}</a> / ${equip.num}
	    </td>
	    
	    <td align="center">
	    ${equip.price}원
	    </td>
	    
	    <td align="center">
	    ${equip.score}
	    </td>
	    
	    <td align="center">
	    ${equip.reg}
	    </td>
	    	
	    </tr>
	    
	    </c:forEach>
	    
	    </table>
	    
	    <table border="1" width="1800" cellpadding="0" cellspacing="0" align="center"> 
	    	
	    	<tr height="50">
	    		<td align="center">
	    	 	현재페이지 : ${currentPage}
	    	 	</td>
	    	</tr>
	    	
	    	
	    	 <tr height="50">
	    	 
	    	 	
	    	 
	    	 
	    		<td align="center">
				    <c:if test="${count > 0}">
						<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />	
				<fmt:parseNumber var="result" value="${currentPage/10.01}" integerOnly="true" />
						<c:set var="startPage" value="${result*10+1}" />
						<c:set var="pageBlock" value="${10}" />
						<c:set var="endPage" value="${startPage + pageBlock-1}" />
						<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
					
					<c:if test="${startPage > 10}">
						<a href="/equip/list?pageNum=${startPage - 10}&cat=${category}${filpara}">[이전]</a>
					</c:if>
				
						<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
							<a href="/equip/list?pageNum=${i}&cat=${category}${filpara}">[${i}]</a>
						</c:forEach>
				
					<c:if test="${endPage < pageCount}">
						<a href="/equip/list?pageNum=${startPage + 10}&cat=${category}${filpara}">[다음]</a>
					</c:if>
					</c:if>
				  </td>
			<tr>
		</table>
	
<h2>currentPage : ${currentPage}</h2>
<h2>startPage : ${startPage}</h2>
<h2>endPage : ${endPage}</h2>
<h2>result : ${result}</h2>
	