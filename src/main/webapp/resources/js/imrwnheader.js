
window.addEventListener("load", function() {
	// 검색 버튼 클릭시 검색바 활성화
	let infobtn = document.getElementById("info");
	infobtn.addEventListener('click', function() {

		let findbar = document.getElementById("searchbar");

		if (findbar.style.display === "block") {
			findbar.style.display = "none";
		}
		else {
			findbar.style.display = "block";
		}
	});

	// x 누르면 내용 사라짐
	let csbtn = document.getElementById("csicon");

	csbtn.addEventListener('click', function() {
		document.getElementById("find").value = null;
		document.getElementById("find").focus();
	})
	// 스크롤 시에 우측 하단에 최상단으로 가는 버튼 활성화
	window.onscroll = function() { scrollFunction() };

	let mybutton = document.getElementById("myBtn");
	function scrollFunction() {
		if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
			mybutton.style.display = "block";
		} else {
			mybutton.style.display = "none";
		}
	}

	mybutton.addEventListener('click', function() {

		document.body.scrollTop = 0; // For Safari
		document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
	});


})

//검색 기능
$(function() {

	$("#find").on("keyup", function(key) {
		if (key.keyCode == 13) {

			$("#scicon").attr("type", "button");
			$("#scicon").click();
		}
	});
	$("#scicon").click(function() {
		let searchWord = document.getElementById('find').value;
		$.ajax({
			url: "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&listCount=100&query=" + searchWord,  // 요청 URL
			type: "get",                  // HTTP 메서드
			dataType: "json",      // 응답 데이터 형식
			async: false,
			success: function(d) {
				sucFuncJsonMA(d)  // 요청 성공 시 호출할 메서드 설정
			},
			error: function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
		});

	})
	let movieArr = [];
	function sucFuncJsonMA(d) {
		movieArr = [];
		for (let i = 0; i < d.Data[0].Result.length; i++) {
			if (!d.Data[0].Result[i].genre.includes("에로")) {
				d.Data[0].Result[i].directors = JSON.stringify(d.Data[0].Result[i].directors);
				d.Data[0].Result[i].actors = JSON.stringify(d.Data[0].Result[i].actors);
				d.Data[0].Result[i].plots = JSON.stringify(d.Data[0].Result[i].plots);

				movieArr.push(d.Data[0].Result[i]);
			}
		}
		Movie(movieArr);

	}

	function Movie(movieArr) {
		let searchWord = document.getElementById('find').value;

		$.ajax({
			url: '/jh/movie/moviedb',  // 요청 URL
			type: "post",                // HTTP 메서드
			data: { movieArr: JSON.stringify(movieArr)},
	      //  async : false,
			success: function(result){  // 요청 성공 시 호출할 메서드 설정
				location.href="/jh/movie/search?searchWord="+ searchWord;
				
			},
			error: function(request, status, error) { console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error) } // 에러가 발생했을 때, 호출될 함수
		});
	}

})