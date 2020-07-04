<%-- 
    Document   : admin_main
    Created on : May 15, 2020, 4:15:00 PM
    Author     : Zafrul Hasan Nasim
--%>

<html>
    
    <head>
        <link href="css/admin_main_css.css" rel="stylesheet"> 
    </head>
    <body>
        
        <div class="header">
		<div class="logo">
			<h1 class="welcome" > Online Classroom </h1>
				
			</a>
		</div>
        </div>
	
        
<div class="container dashboard">
		<h1>Welcome To Admin Panel</h1>
		<div class="stats">
			<a href="courselist_controller?email=${email}&name=${name}" class="first">
				
				<span>See All course's</span>
			</a>
                    <a href="add_course.jsp?email=${email}&name=${name}">
				
				<span>Add new course</span>
			</a>
			<a href="courselist_controller_2?email=${email}&name=${name}">
				
				<span>Classwork and Attendance</span>
			</a>
                    
		</div>
		<br><br><br>
		
	</div>
        <h1 style="color: white;"> ${email}</h1>
    </body>
</html>