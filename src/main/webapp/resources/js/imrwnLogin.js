let loginBtn = document.getElementById("loginbtn");
let userId = document.getElementById('userId');
let userPw = document.getElementById('userPw');

let textbox = document.getElementsByClassName('textInput');

//텍스트 박스에서 엔터를 누르면 로그인 버튼 활성화
for(let i = 0 ; i < textbox.length ; i++){
    textbox[i].addEventListener('keydown', function(e){
            if(e.code === 'Enter'){
                loginBtn.click();
            }
        })
    }

//아이디 비밀번호 입력값이 없을 시 입력해달라고 알림창 띄우기
function idpwCk(){

    if(userId.value == "") {
        alert('아이디를 입력해 주세요.')

        document.getElementById('userId').focus();

    }
    else if(userPw.value == "") {
        alert('비밀번호를 입력해 주세요.')

        document.getElementById('userPw').focus();

    }
    else {
        document.getElementById("loginbtn").type = "submit";
    }
}

//캡스락 키가 활성화 되어 있을 경우 알림
function ckCapslock(event)  {
    if (event.getModifierState("CapsLock")) {
      document.getElementById("message").innerText 
        = "Caps Lock이 켜져 있습니다."
    }else {
      document.getElementById("message").innerText 
        = ""
    }
  }
function WinClose(){
	top.window.open('./main','_self').close();
	top.window.opener=self;
	top.self.close();
}

