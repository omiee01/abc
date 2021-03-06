<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Admin</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery1.js"></script>
 <!--initiate accordion-->    <script type="text/javascript">
        $(function() {
        
            var menu_ul = $('.menu > li > ul'),
                   menu_a  = $('.menu > li > a');
            
            menu_ul.hide();
        
            menu_a.click(function(e) {
                e.preventDefault();
                if(!$(this).hasClass('active')) {
                    menu_a.removeClass('active');
                    menu_ul.filter(':visible').slideUp('normal');
                    $(this).addClass('active').next().stop(true,true).slideDown('normal');
                } else {
                    $(this).removeClass('active');
                    $(this).next().stop(true,true).slideUp('normal');
                }
            });
        
        });
    </script>
    <!---------End script--------------------->
</head>

<body>
    <div class="container">
       <%@ include file="../includes/header.jsp" %>
           	<div class="subcontainer">
        	<div class="sidebar">
            	<div class="sidebar_upperbox">
                	
                </div>
			<%@ include file="../includes/sidebar.jsp" %>                
               <!-- <div class="sidebar_categorybox">Location Managent</div>-->
            </div>
            
            <!--------------End of sidebar------------------------>
            <div class="form_list_wrapper">
            	<div class="form_list_wrapper_header">State Management</div>
                <form:form action="${pageContext.request.contextPath}/admin/states/update" method="post" modelAttribute="state">
                <div class="form_list_wrapper_form">
               
                	<div class="form_list_wrapper_form_left">
                    	 <!-----------copy div for increasing labels------------------>
                    	<div class="form_list_wrapper_form_inputlabel">Country Name:</div>
                        <div class="form_list_wrapper_form_inputlabel">State Name:</div>
                          <!----------end-------------->
                    </div>
                     <!-----------copy div for increasing input------------------>
                     <div class="form_list_wrapper_form_input">
                     	<form:select path="country.countryId" name="scountry" class="form_list_wrapper_form_input_select_dropdown">
                        	<%-- <form:option value="0">Select</form:option> --%>
                        	<%-- <c:forEach var="country" items="${countries}"> --%>
	                        	<option  value="${countries.countryId}"/>${countries.countryName}</option>
                            
                        </form:select>
                     </div>
                     <div class="form_list_wrapper_form_input">
                     	<form:input path="stateName" name="stateName" />
                     	<form:hidden path="stateId" />
                     </div>
                     <div class="form_list_wrapper_form_input_btn">
                     		<input type="submit" value="ADD"  name="submit" class="form_list_wrapper_form_btn" />
                            <input type="reset" value="Clear"  name="submit" class="form_list_wrapper_form_btn1" />
                     </div>                    
                     <!----------end-------------->
                </div>
                </form:form>
  
            </div>
            
            <!--------------------Table code from here-------------------------------->
        </div>
        <%@ include file="../includes/footer.jsp" %>
    </div>
</body>
</html>

</html>