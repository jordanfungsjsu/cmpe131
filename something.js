
function submission(){
    let password =   
  document.forms["myForm"]["password"].value;
  if(password==""){
    alert("Please enter the password into the box")
  }
  else if(password=="frankbutt"){
    window.location.href="Transcript.html";
  }
  else{
    alert("Incorrect Password");
  }
}
function myFunction(){
    let project =document.getElementById("projects").value;
    console.log(project);
    if(project=="Project 1"){
        window.location.href="prj1.html";
    }
    else{
        window.location.href="prj2.hteml"
    }
}