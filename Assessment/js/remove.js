let navbar_text=document.querySelector(".navbar-text");

let date=new Date();

let seconds=document.getElementById("seconds");

function sec(){
    seconds.innerHTML=new Date().getSeconds();
}
setInterval(sec,1000)

let current_date=`Date :${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()} Time : ${ date.getHours()}:${date.getMinutes()}:`
navbar_text.innerHTML=current_date;

let year=document.getElementById("year");

year.textContent=date.getFullYear();


let removestatus=document.getElementById("removestatus");
let removeEmp=document.getElementById("removeEmp");
let idfrominput=document.getElementById("idfrominput");

removeEmp.onclick=function(){
    let  keys = Object.keys(localStorage);

    for (let id of keys){
        if(idfrominput.value===id){
            localStorage.removeItem(id);
            removestatus.textContent="Employee is deleted successfully";
            removestatus.style.color="green";
        }
    }
}








