 
 	let lastweek = new Date();
		let dayOfMonth = lastweek.getDate();
		  	lastweek.setDate(dayOfMonth - 7);

		
		let year = lastweek.getFullYear();              //yyyy
	    let month = (1 + lastweek.getMonth());          //M
	    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	    let day = lastweek.getDate();                   //d
	    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	    let lastweekStr =  year +'' + month + '' + day; 
	    
	    
 		arr = [];
		$(document).ready(function() {
			let searchWord = $("#keyword").val();
			let startNum = $('#startNum').val();
			
		// 금주의 박스오피스 kobis api 이용하여 가져오기
			$.ajax({
			    url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=41e994014f2ab1da2608f4c574de71d1&targetDt="+lastweekStr+"&weekGb=0&multiMovieYn=N",  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
				async : false,    
			    success : sucFuncJson,  // 요청 성공 시 호출할 메서드 설정
			    error : function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
			});
			$.ajax({
			    url : "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=41e994014f2ab1da2608f4c574de71d1&targetDt="+lastweekStr+"&weekGb=0&multiMovieYn=Y",  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			   	async : false,
			    success : sucFuncJson,  // 요청 성공 시 호출할 메서드 설정
			    error : function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
			});	              
		poster(arr);
		slides = document.getElementsByClassName("mySlides");
		showSlides(slideIndex);
		
		
 		// 슬라이드 쇼 자동 회전
 		timer = setInterval(AutoshowSlides, 4000);
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
		});
	// 박스오피스 배열의 값들을 KMDB api에서 검색한 후 db에 저장
	function poster(arr) {
        for(let i = 0 ; i < arr.length ; i++) {
            $.ajax({
			    url : "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&sort=prodYear,1&title="+ arr[i],  // 요청 URL
			    type : "get",                  // HTTP 메서드
			    dataType : "json",      // 응답 데이터 형식
			    async : false,
			    success : function(d) {  // 요청 성공 시 호출할 메서드 설정
                    	let movieArr = [];
                for (let j = 0; j < d.Data[0].Result.length; j++) {
                    if (!d.Data[0].Result[j].genre.includes("에로")) {
                        d.Data[0].Result[j].directors = JSON.stringify(d.Data[0].Result[j].directors);
                        d.Data[0].Result[j].actors = JSON.stringify(d.Data[0].Result[j].actors);
                        d.Data[0].Result[j].plots = JSON.stringify(d.Data[0].Result[j].plots);

                        movieArr.push(d.Data[0].Result[j]);
                    }
                }
                $.ajax({
                    url: '/jh/movie/moviedb',  // 요청 URL
                    type: "post",                // HTTP 메서드
                    data: { movieArr: JSON.stringify(movieArr) , arr : JSON.stringify(arr)},
                    async : false,
                    success: function(result){  // 요청 성공 시 호출할 메서드 설정
						result = JSON.parse(result);
						let poster = "";
						if(result.posters != null || result.posters != "" ) {
							poster = result.posters.split("|");
						} else {
							poster = "/jh/img/포스터 준비.png";
						}	 
							let show = document.getElementsByClassName("slideshow-container")[0];
							show.insertAdjacentHTML('beforeend', '<div class="mySlides fade"><div class="numbertext">'+ (i+1) + '/ 20</div><a href="/jh/movie/view?mno='+ result.mno +'" id="image1"><img src='+ poster[0] +'></a> </div>');
							
                    },
                    error: function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
                });
                        
                        },  
			    error : function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
			});
        }
	}	
	
	function sucFuncJson(d){

		$.each(d.boxOfficeResult.weeklyBoxOfficeList, function(index, item){
			arr.push(item.movieNm);	
				
		});
	}
	
	// 슬라이드 쇼 이미지 회전
 	let slideIndex = 1;
 	// let timer;

 	// Next/previous controls
 	function plusSlides(n) {
 	  showSlides(slideIndex += n);
 	}

 	
 	function AutoshowSlides() {
 	  plusSlides(1);
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
 	
 	// 랜덤 영화 추천
 	$("#suggest").click(function(){
 		let actors = $("input[name=actor]").val();
 		let genre = new Array();

		//checkbox의 name값이 sendCheck이면서 체크되어 있는 함수를 each함수로 호출한다.
		$("input[name=genre]:checked").each(function() {
		
		   genre.push($(this).val());
		
 		});
		 		
 		let score = $("select[name=rating]").val();
 		$.ajax({
			url: '/jh/suggest?actors='+actors+'&genre='+genre+'&score='+score,  // 요청 URL
			type: "GET",                // HTTP 메서드
	      //  async : false,
			success: function(result){  // 요청 성공 시 호출할 메서드 설정
				result = JSON.parse(result)
				
				let random = Math.floor(Math.random() * result.length);
				
				let randomRes = result[random];
				
				$("#suggestMovie").css("display", "none");
				document.getElementById("suggestMovie").src = randomRes.posters;
				document.getElementById("suggestlink").href = "/jh/movie/view?mno=" + randomRes.mno;
				$("#suggestMovie").fadeIn(500);
				
			},
			error: function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
		});
 	
 	});