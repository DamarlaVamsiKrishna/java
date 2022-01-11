let year =document.getElementById("year");

let presentYear=new Date().getFullYear();
year.textContent=presentYear;

let user_warning=document.getElementById("user-warning");
let form=document.getElementById("form");
let pass_warning=document.getElementById("pass-warning");
let floatingInput =document.getElementById("floatingInput");
let floatingPassword=document.getElementById("floatingPassword");

let loginid=document.getElementById("loginid");

let  keys = Object.keys(localStorage);
console.log(keys);
console.log(floatingInput.value);


loginid.addEventListener("click",(event)=>{
    event.preventDefault();
    if(floatingInput.value=="" || floatingInput.value==undefined){
        user_warning.textContent="*Username field is required";
       event.preventDefault();
    }
    if(floatingPassword.value=="" || floatingPassword.value==undefined){
        pass_warning.textContent="*Password field is required";
        event.preventDefault();
    }
    else if (floatingPassword.value.length<4){
        pass_warning.textContent="password atleast requires 5 characters";
        event.preventDefault();
    }
    console.log(floatingInput.value);

    if(floatingInput.value!="" && floatingPassword.value!=undefined && floatingInput.value!=undefined && floatingPassword.value!=""){
        event.preventDefault();
        keys.map((employee)=>{
            let each= localStorage.getItem(employee);
            let parse_obj=JSON.parse(each);
            if (parse_obj.username==floatingInput.value && parse_obj.password==floatingPassword.value){
                location.href ="http://127.0.0.1:5500/Assessment/home.html";
            }
        })
    }
    
})
