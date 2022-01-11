let tableid=document.getElementById("tableid");

let date=new Date();
let year=document.getElementById("year");
year.textContent=date.getFullYear();

let showtime=document.getElementById("showtime");
let seconds=document.getElementById("seconds");

function sec(){
    seconds.innerHTML=new Date().getSeconds();
}
setInterval(sec,1000)

let current_date=`Date :${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()} 
Time : ${ date.getHours()}:${date.getMinutes()}:`
showtime.innerHTML=current_date;


let buttonIds=[];
var editButton;

function createRow(employee,i){
    let tr=document.createElement("tr"); 
    tableid.appendChild(tr);                
    tr.classList.add("tabledata");
    
    let slno= document.createElement("td");  
    let id= document.createElement("td");
    let name= document.createElement("td");
    let department= document.createElement("td");
    let skill= document.createElement("td");
    let salary= document.createElement("td");
    editButton =document.createElement("button");

    editButton.textContent="Edit";
    editButton.classList.add("editBtn")
    editButton.setAttribute("id","button"+i);
    buttonIds.push(editButton.id)
    
    
    tr.appendChild(slno);          
    tr.appendChild(id);
    tr.appendChild(name);
    tr.appendChild(department);
    tr.appendChild(skill);
    tr.appendChild(salary);

    tr.appendChild(editButton);

    slno.textContent=i;        
    id.textContent=employee.Eid;
    name.textContent=employee.name;
    department.textContent=employee.department;
    skill.textContent=employee.skill;
    salary.textContent=employee.salary;
}


let  keys = Object.keys(localStorage);
let i=1;
for (let id of keys){
    let stringified_object=localStorage.getItem(id);
    let parsed_object=JSON.parse(stringified_object);

    if(parsed_object.department==undefined && parsed_object.salary==undefined){
        
    }else{ 
        createRow(parsed_object,i);
        i=i+1;
    }
}
console.log(buttonIds);

addEventListener

for (btn of buttonIds){
    /*btn.addEventListener("click",(event)=>{
        console.log(btn);
    })*/
    console.log(btn)
}