function checkWriteForm(){
  var subject = document.guestbookWriteForm.subject.value;
  var content = document.guestbookWriteForm.content.value;
  checkSubject(subject);
  checkContent(content);
  window.open(""
             ,"viewer"
             ,"width=300 height=100 left=500 top=100");
  document.guestbookWriteForm.action = "http://localhost:8080/guestbookServlet/GuestbookWriteServlet";
  document.guestbookWriteForm.target = "viewer";
  document.guestbookWriteForm.submit();
}

function checkSubject(subject){
  if(subject==""){
    alert("제목을 입력해주세요.");
    location.history(0);
  }
}

function checkContent(content){
  if(content==""){
    alert("내용을 입력해주세요.");
    location.history(0);
  }
}

function showList(){
  window.open(""
				  ,"viewer"
				  ,"width=480 height=380 left=500 top=100");
  document.guestbookWriteForm.action = "http://localhost:8080/guestbookServlet/GuestbookListServlet";
  document.guestbookWriteForm.target = "viewer";
  document.guestbookWriteForm.submit();
}
