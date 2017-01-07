// console.log("hello world");

//  var div = document.getElementById('id');
//
//  console.log(":childNodes:",div.childNodes);
//
//  var a = document.createElement('a');
//  a.innerText = 'bing';
// a.href = "http://www.bing.com";
//
// div.appendChild(a);

// var qwe = document.getElementById('parent2');
//
// var a
//
// qwe.addEventListener('click',function(a) {
//   console.log(parent2);
//   console.log(a.target);
// },false);
// qwe.addEventListener('click',function(a) {
//   console.log(parent2);
// },true);
//
// var qwr = document.getElementById('child2');
//
// qwr.addEventListener('click',function(a) {
//   console.log(child2);
//   console.log(a.target);
//   // a.stopPropagation();//断掉捕获事件
// a.preventDefault()//阻止默认动作
// },false);
//
// qwr.addEventListener('click',function(a) {
//   console.log(child2);
//   console.log(a.target);
// },true);
// var ert = document.getElementById('p2');
//
// ert.addEventListener('click',function(a) {
//   console.log(p2);
//   console.log(a.target);
// },false);
// ert.addEventListener('click',function(a) {
//   console.log(p2);
//   console.log(a.target);
// },true);

// var qwe = document.getElementById('usename');
// qwe.addEventListener('click',function() {
//   console.log(qwe);
// },true);



// var qwf = document.getElementById('button');
//
// qwf.addEventListener('click',function(a,b) {
// a = document.getElementById('name').value;
// b = document.getElementById('pass').value;
// console.log(a,b)
//
document.querySelector('#submit').addEventListener('click',function() {

var usename = document.querySelector('#usename').value;
var password = document.querySelector('#password').value;
console.log(usename,password);
if(!usename||!password) {
  document.querySelector('#err').innerText = "username is empty";
  return;
}else {
  document.querySelector('#err').innerText = "";
}

var http = new XMLHttpRequest();
http.onreadystatechange = function() {
  if (this.readtState == 4 && this.status == 200) {
    document.querySelector('#err').innerText = "succeed";
  }else{
    document.querySelector('#err').innerText = "failed";
  }
}

var payload = {
  usename:usename,
  password:password
};

http.open("post",'user',true);
http.setRequestHeader('content-type', 'application/json');
http.send(JSON.stringify(payload));

 },false);
