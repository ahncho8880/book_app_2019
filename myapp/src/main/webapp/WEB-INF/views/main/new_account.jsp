<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width", initial-scale="1">
   <title>회원가입</title>
   <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.css">
   <link rel="stylesheet" href="resources/bootstrap/css/custom.css">
   
<style type="text/css">

.col-md-6{
   margin:auto;
}

.form .form-control {
    background: #f7f7f7 none repeat scroll 0 0;
    border: 1px solid #d4d4d4;
    font-size: 14px;
}


</style>

<script type="text/javascript">

   var count =0;

   function formCheck() {
      
      var mID = document.getElementById('mID');
      var mPasswd = document.getElementById('mPasswd');
      var mPasswd_c = document.getElementById('mPasswd_c');
      var mName = document.getElementById('mName');


      if (mID.value == '' || mID.value == null) {
         alert('ID를 입력하세요');
         focus.mID;
         return false;
      }else if (mPasswd.value == '' || mPasswd.value == null) {
         alert('비밀번호를 입력하세요');
         focus.mPasswd;
         return false;
      }else if (mPasswd.value != mPasswd_c.value){
         alert("비밀번호와 비밀번호 확인란이 다릅니다.");
         focus.mPasswd; 
         return false;
      }else if (mName.value == '' || mName.value == null) {
         alert('이름을 입력하세요');
         focus.mName;
         return false;
      }else{
         save();
      }
   }

   
   function save() {
      alert("회원가입이 완료되었습니다.");
      var str3 = document.getElementById('finish');
      str3.submit();
   }


</script>
   
   
</head>
<body>

   <%@include file="navi.jsp" %>

   <br><br><br>
   
   <!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
   <!------ Include the above in your HEAD tag ---------->

   <div class="container" id="wrap" style="background:white">
      <div class="row">
         <div class="col-md-6 col-md-offset-3">
            <form action="join" onsubmit="return false;" method="post" id="finish" accept-charset="utf-8" class="form"
               role="form">
               <h2 style="font-size:18px; text-align:center; margin: 8px 0 30px 0;">NewAccount</h2>
               <h4></h4>


               <input type="text" name="mID" id="mID" value=""
                  class="form-control input-lg" placeholder="Id" /><input
                  type="password" name="mPasswd" id="mPasswd" value="" class="form-control input-lg"
                  placeholder="Password" /><input type="password" name="mPasswd_c" id="mPasswd_c"
                  value="" class="form-control input-lg" placeholder="Repeat Password" /></br>
               <input type="text" name="mName" id="mName" value="" class="form-control input-lg"
                  placeholder="Name" /> <label>Birthday</label>
               <div class="row">
                  <div class="col-xs-4 col-md-4">
                     <select name="month" class="form-control input-lg">
                        <option value="01">1월</option>
                        <option value="02">2월</option>
                        <option value="03">3월</option>
                        <option value="04">4월</option>
                        <option value="05">5월</option>
                        <option value="06">6월</option>
                        <option value="07">7월</option>
                        <option value="08">8월</option>
                        <option value="09">9월</option>
                        <option value="10">10월</option>
                        <option value="11">11월</option>
                        <option value="12">12월</option>
                     </select>
                  </div>
                  <div class="col-xs-4 col-md-4">
                     <select name="day" class="form-control input-lg">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                     </select>
                  </div>
                  <div class="col-xs-4 col-md-4">
                     <select name="year" class="form-control input-lg">
                        <option value="1935">1935</option>
                        <option value="1936">1936</option>
                        <option value="1937">1937</option>
                        <option value="1938">1938</option>
                        <option value="1939">1939</option>
                        <option value="1940">1940</option>
                        <option value="1941">1941</option>
                        <option value="1942">1942</option>
                        <option value="1943">1943</option>
                        <option value="1944">1944</option>
                        <option value="1945">1945</option>
                        <option value="1946">1946</option>
                        <option value="1947">1947</option>
                        <option value="1948">1948</option>
                        <option value="1949">1949</option>
                        <option value="1950">1950</option>
                        <option value="1951">1951</option>
                        <option value="1952">1952</option>
                        <option value="1953">1953</option>
                        <option value="1954">1954</option>
                        <option value="1955">1955</option>
                        <option value="1956">1956</option>
                        <option value="1957">1957</option>
                        <option value="1958">1958</option>
                        <option value="1959">1959</option>
                        <option value="1960">1960</option>
                        <option value="1961">1961</option>
                        <option value="1962">1962</option>
                        <option value="1963">1963</option>
                        <option value="1964">1964</option>
                        <option value="1965">1965</option>
                        <option value="1966">1966</option>
                        <option value="1967">1967</option>
                        <option value="1968">1968</option>
                        <option value="1969">1969</option>
                        <option value="1970">1970</option>
                        <option value="1971">1971</option>
                        <option value="1972">1972</option>
                        <option value="1973">1973</option>
                        <option value="1974">1974</option>
                        <option value="1975">1975</option>
                        <option value="1976">1976</option>
                        <option value="1977">1977</option>
                        <option value="1978">1978</option>
                        <option value="1979">1979</option>
                        <option value="1980">1980</option>
                        <option value="1981">1981</option>
                        <option value="1982">1982</option>
                        <option value="1983">1983</option>
                        <option value="1984">1984</option>
                        <option value="1985">1985</option>
                        <option value="1986">1986</option>
                        <option value="1987">1987</option>
                        <option value="1988">1988</option>
                        <option value="1989">1989</option>
                        <option value="1990">1990</option>
                        <option value="1991">1991</option>
                        <option value="1992">1992</option>
                        <option value="1993">1993</option>
                        <option value="1994">1994</option>
                        <option value="1995">1995</option>
                        <option value="1996">1996</option>
                        <option value="1997">1997</option>
                        <option value="1998">1998</option>
                        <option value="1999">1999</option>
                        <option value="2000">2000</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                        <option value="2009">2009</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                     </select>
                  </div>
               </div>
             <!--   <label>Gender : </label> <label class="radio-inline"> <input
                  type="radio" name="성별" value="M" id=남성 /> Male
               </label> <label class="radio-inline"> <input type="radio" name="성별"
                  value="F" id=여성 /> Female
               </label>  -->
               <button class="btn btn-lg btn-primary btn-block signup-btn" style="background:#f0ad4e; text-shadow:none;
                  font-size:18px; border:solid #fff 1px;" onclick="formCheck();">Create Account</button>
            </form>
         </div>
      </div>
   </div>
   
   
   <br><br><br>
   
      <%@include file="newFooter.jsp"%>
   
</body>
 <script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.js"></script>
</html>