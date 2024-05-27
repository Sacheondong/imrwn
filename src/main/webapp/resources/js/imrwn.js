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
    }
      break;

    case 4 : 
      for(let i = 15 ; i < 20 ; i++) { 
        slides[i].style.display = "block";
    }
      break;
  }
}

let mybutton = document.getElementById("myBtn");

// 스크롤 시에 우측 하단에 최상단으로 가는 버튼 활성화
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
}

// 검색 버튼 클릭시 검색바 활성화
let infobtn = document.getElementById("info");

infobtn.addEventListener('click', function() {

  let findbar = document.getElementById("searchbar");

  if(findbar.style.display === "block") {
    findbar.style.display = "none";
  }
  else {
    findbar.style.display = "block";
  };
});

// x 누르면 내용 사라짐
let csbtn = document.getElementById("csicon");
let textbox = document.getElementsById('find');

csbtn.addEventListener('click', function() {
  textbox.value = null;
  textbox.focus();
})
//엔터 키

let scbtn = document.getElementById("scicon");

    textbox.addEventListener('keydown', function(e){
            if(e.code === 'Enter'){
 
                scbtn.click();
                
            }
        })
        
//검색 기능
function searchF(){
	let searchWord = document.getElementById('find').value;
	
	$.ajax({
	    url : "https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey=LS60734T3C4O4Z7Z4SV7&listCount=500&query=" + searchWord,  // 요청 URL
	    type : "get",                  // HTTP 메서드
	    dataType : "json",      // 응답 데이터 형식
	    async : false,
	    success : sucFuncJson17,  // 요청 성공 시 호출할 메서드 설정
	    error : errFunc17         // 요청 실패 시 호출할 메서드 설정
	  });
	
	
	
	function sucFuncJson17(d){
		
		let titleArr = [];
		let actorArr = [];
		let directorArr = [];
		for(let i=0; i<d.Data[0].Result.length ; i++){
			if(!d.Data[0].Result[i].genre.includes("에로") ){
				if (d.Data[0].Result[i].title.includes("!HS")){
					titleArr.push(d.Data[0].Result[i]) ;
				}
				for (let j=0; j<d.Data[0].Result[i].directors.director.length ; j++){
					if (d.Data[0].Result[i].directors.director[j].directorNm.includes("!HS")||d.Data[0].Result[i].directors.director[j].directorEnNm.includes("!HS")){
						directorArr.push(d.Data[0].Result[i]) ;	
					}
				}
				for (let j=0; j<d.Data[0].Result[i].actors.actor.length ; j++){
					if (d.Data[0].Result[i].actors.actor[j].actorNm.includes("!HS")||d.Data[0].Result[i].actors.actor[j].actorEnNm.includes("!HS")){
						actorArr.push(d.Data[0].Result[i]) ;	
					}
				}
			}
		}
	
	}
	
	
	function errFunc17(e) {
	    alert("실패: " + e.status);
	}
}