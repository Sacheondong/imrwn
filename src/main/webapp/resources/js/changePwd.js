	//모든 조건 완성시 submit
		function changeCk(){
		    let user_pw = document.getElementById("user_pw").value;
		    let user_pwck = document.getElementById("user_pwck").value;
		 
		    if (!pwCheck(user_pw)){
		        
		        document.getElementById("pwBox").innerText = "비밀번호는 8자 이상 영문 대소문자, 숫자, 특수문자를 하나씩 포함해야합니다"
	
		    }
		    else if(!((user_pw) == (user_pwck))) {
				
			}
		    else {
		        document.querySelector("#signupForm").submit();
		    }
		}
	    function pwCk() {
	        let user_name = document.getElementById("user_pw").value;
	        
	        if(pwCheck(user_name)) {
	            document.getElementById("pwBox").innerText = ""
	        }
	    }
	    //비밀번호 양식
	    function pwCheck(user_pw){
	        var pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/;
	   
	        //비밀번호는 영문 대소문자 숫자 특수문자 하나씩 포함
	        return pwReg.test(user_pw);
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