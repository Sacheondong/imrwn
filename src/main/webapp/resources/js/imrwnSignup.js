//ID 비밀번호 Email 양식 체크

	function signupCk(){
    let user_name = document.getElementById("user_name").value;
    let user_pw = document.getElementById("user_pw").value;
    let user_pwck = document.getElementById("user_pwck").value;
    let user_email = document.getElementById("user_email").value;
	
    if (!idCheck(user_name)){
        document.getElementById("idBox").innerText = "아이디는 8-20자, 영문과 숫자입니다."
        

    }
    else if (!pwCheck(user_pw)){
        
        document.getElementById("pwBox").innerText = "비밀번호는 8자 이상 영문 대소문자, 숫자, 특수문자를 하나씩 포함해야합니다"

    }
    else if(!((user_pw) == (user_pwck))) {
		
	}
    else if (!emailCheck(user_email)) {

        document.getElementById("emailBox").innerText = "이메일 주소를 확인해 주세요."

    }else if(!document.getElementById("user_name").readOnly) {
    	alert("아이디 중복확인을 해주세요.");
    }
    else {
        document.querySelector("#signupForm").submit();
    }
}
//양식에 맞게 입력하였을 경우 알림 해제
    function idCk() {
        let user_name = document.getElementById("user_name").value;
        
        if(idCheck(user_name)) {
            document.getElementById("idBox").innerText = ""
        }
    }   
    function pwCk() {
        let user_name = document.getElementById("user_pw").value;
        
        if(pwCheck(user_name)) {
            document.getElementById("pwBox").innerText = ""
        }
    }   
    function emailCk() {
        let user_name = document.getElementById("user_email").value;
        
        if(emailCheck(user_name)) {
            document.getElementById("emailBox").innerText = ""
        }
    }

//아이디 비밀번호 이메일 양식
    function idCheck(user_name){
        var idReg = /^[A-za-z0-9]{8,20}/g;
        //아이디는 8-20자 영문과 숫자
        return idReg.test(user_name);
    }
    function pwCheck(user_pw){
        var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
   
        //비밀번호는 영문 대소문자 숫자 특수문자 하나씩 포함
        return pwReg.test(user_pw);
    }
    function emailCheck(user_email){
        let emailReg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;

        return emailReg.test(user_email);
    }   

//비밀번호와 비밀번호 확인이 일치하는지 테스트
function pwCk2(){
    let password = document.getElementById("user_pw").value;
    let passwordCk = document.getElementById("user_pwck").value;

    if ( password == passwordCk) {
        document.getElementById("doubleCk").innerText = "비밀번호가 일치합니다."
        document.getElementById("doubleCk").style.color = "white"
    }
    else {
		document.getElementById("doubleCk").innerText = "비밀번호가 일치하지않습니다."
        document.getElementById("doubleCk").style.color = "rgb(229,9,20)"
	}
}
