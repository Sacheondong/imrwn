 // 슬라이드 쇼 이미지 회전
 	let slideIndex = 1;
 	let slides = document.getElementsByClassName("mySlides");
 	showSlides(slideIndex);
 	// let timer;

 	// Next/previous controls
 	function plusSlides(n) {
 	  showSlides(slideIndex += n);
 	}

 	// 슬라이드 쇼 자동 회전
 	let timer = setInterval(AutoshowSlides, 4000);

 	function AutoshowSlides() {
 	  plusSlides(1);
 	}
 	// 이미지에 hover시 멈춤
 	for(let i = 0 ; i < slides.length ; i++){
 	  slides[i].addEventListener('mouseover', function(){
 	    clearInterval(timer);    
 	  })
 	}
 	//hover out 시 다시 시작
 	for(let i = 0 ; i < slides.length ; i++){
 	  slides[i].addEventListener('mouseout', function(){
 	    timer = setInterval(AutoshowSlides, 4000);    
 	  })
 	}

 	//슬라이드 쇼 회전 함수
 	function showSlides(n) {
 	  let i;
 	  let dots = document.getElementsByClassName("dot");
 	  if (n > 4) {slideIndex = 1}
 	  if (n < 1) {slideIndex = 4}
 	  for (i = 0; i < slides.length; i++) {
 	    slides[i].style.display = "none";
 	  }
 	  switch (slideIndex) {
 	    case 1 :
 	      for(let i = 0 ; i < 5 ; i++) {
 	        slides[i].style.display = "block"; 
 	        document.getElementById("movieCate").innerText = "상업영화"
 	    }
 	      break;

 	    case 2 : 
 	      for(let i = 5 ; i < 10 ; i++) { 
 	        slides[i].style.display = "block";  
 	    }
 	      break;

 	    case 3 : 
 	      for(let i = 10 ; i < 15 ; i++) { 
 	        slides[i].style.display = "block";
 	        document.getElementById("movieCate").innerText = "독립영화"
 	    }
 	      break;

 	    case 4 : 
 	      for(let i = 15 ; i < 20 ; i++) { 
 	        slides[i].style.display = "block";
 	    }
 	      break;
 	  }
 	}
 	let lastweek = new Date();
		let dayOfMonth = lastweek.getDate();
		  	lastweek.setDate(dayOfMonth - 7);

		
		let year = lastweek.getFullYear();              //yyyy
	    let month = (1 + lastweek.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    let day = lastweek.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    let lastweekStr =  year +'' + month + '' + day; 
	    
	    
 	$(function() {
 		
		$(document).ready(function() {
			let searchWord = $("#keyword").val();
			let startNum = $('#startNum').val();
			
			
			$.ajax({
			    url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=41e994014f2ab1da2608f4c574de71d1&targetDt="+lastweekStr+"&weekGb=0&multiMovieYn=N",  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    success : sucFuncJson,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc         // 요청 실패 시 호출할 메서드 설정
			  });
			});	

	});
	
	let arr = [];
	function sucFuncJson(d){
		let searchWord = "";
		let str = "";
		$.each(d.boxOfficeResult.weeklyBoxOfficeList, function(index, item){
			arr.push(item.movieNm);	
				
		});

		searchMovie0();
		searchMovie1();
		searchMovie2();
		searchMovie3();
	    searchMovie4();
		searchMovie5();
		searchMovie6();
		searchMovie7();
		searchMovie8();
		searchMovie9();

	    
		console.log(arr);
		
	}		
	function errFunc(e) {
	    alert("실패: " + e.status);
	}
	

			
	function searchMovie0(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[0],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson0,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc0         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson0(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image1").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc0(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie1(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[1],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson1,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc1         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson1(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image2").innerHTML = str2;
		}


		//console.log(str);
		} 

	
	function errFunc1(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie2(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[2],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson2,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc2         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson2(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image3").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc2(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie3(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[3],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson3,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc3         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson3(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image4").innerHTML = str2;
		}
		//console.log(str);
		} 

	
	function errFunc3(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie4(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[4],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson4,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc4         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson4(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image5").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc4(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie5(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[5],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson5,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc5         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson5(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image6").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc5(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie6(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[6],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson6,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc6         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson6(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image7").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc6(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie7(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[7],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson7,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc7         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson7(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image8").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc7(e) {
	    alert("실패: " + e.status);
	}
	function searchMovie8(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[8],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson8,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc8         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson8(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image9").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc8(e) {
	    alert("실패: " + e.status);
	}
	function searchMovie9(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[9],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson9,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc9         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson9(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image10").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc9(e) {
	    alert("실패: " + e.status);
	}
	
	$(function() {
		$(document).ready(function() {
			let searchWord = $("#keyword").val();
			let startNum = $('#startNum').val();
			
			
			$.ajax({
			    url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=41e994014f2ab1da2608f4c574de71d1&targetDt="+lastweekStr+"&weekGb=0&multiMovieYn=Y",  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    success : sucFuncJson123,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc123         // 요청 실패 시 호출할 메서드 설정
			  });
			});	

	});
	
	let arr2 = [];
	function sucFuncJson123(d){
		let searchWord = "";
		let str = "";
		$.each(d.boxOfficeResult.weeklyBoxOfficeList, function(index, item){
			arr2.push(item.movieNm);	
				
		});

		searchMovie10();
		searchMovie11();
		searchMovie12();
		searchMovie13();
	    searchMovie14();
		searchMovie15();
		searchMovie16();
		searchMovie17();
		searchMovie18();
		searchMovie19();

	    
		console.log(arr2);
		console.log(arr);
	}		
	function errFunc123(e) {
	    alert("실패: " + e.status);
	}
	

			
	function searchMovie10(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[0],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson10,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc10         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson10(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image11").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc10(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie11(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[1],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson11,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc11         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson11(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image12").innerHTML = str2;
		}


		//console.log(str);
		} 

	
	function errFunc11(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie12(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[2],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson12,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc12         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson12(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image13").innerHTML = str2;
		}


		//console.log(str);
		} 

	
	function errFunc12(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie13(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[3],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson13,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc13         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson13(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image14").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc13(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie14(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[4],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson14,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc14         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson14(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image15").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc14(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie15(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[5],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson15,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc15         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson15(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image16").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc15(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie16(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[6],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson16,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc16         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson16(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image17").innerHTML = str2;
		}

		//console.log(str);
		} 

	
	function errFunc16(e) {
	    alert("실패: " + e.status);
	}
	
	function searchMovie17(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[7],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson17,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc17         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson17(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image18").innerHTML = str2;
		}


		//console.log(str);
		} 

	
	function errFunc17(e) {
	    alert("실패: " + e.status);
	}
	function searchMovie18(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[8],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson18,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc18         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson18(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
		if(url[0] != null && url[0] != "null" && url[0] != ""){
			console.log(url[0]);		
			 //	str2 += "<ul>"
			 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
					str2 += "<img src="+url[0]+">"
			 //	str2 += "</ul>"
				
				document.querySelector("#image19").innerHTML = str2;
		}
			

		//console.log(str);
		} 

	
	function errFunc18(e) {
	    alert("실패: " + e.status);
	}
	function searchMovie19(){ 	
		$.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr2[9],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : sucFuncJson19,  // 요청 성공 시 호출할 메서드 설정
			    error : errFunc19         // 요청 실패 시 호출할 메서드 설정
			  });


	}
	function sucFuncJson19(d){
		let str2 = "";
		console.log(d);
		let url = d.Data[0].Result[0].posters.split('|');	
			if(url[0] != null && url[0] != "null" && url[0] != ""){
				console.log(url[0]);		
				 //	str2 += "<ul>"
				 //		str2 += "<li> 제목 : " + d.Data[0].Result[0].title + "</li>"
						str2 += "<img src="+url[0]+">"
				 //	str2 += "</ul>"
					
					document.querySelector("#image20").innerHTML = str2;
			}
				


		//console.log(str);
		} 

	
	function errFunc19(e) {
	    alert("실패: " + e.status);
	}
 	
 	
 	
 	
 	