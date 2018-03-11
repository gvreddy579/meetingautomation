<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
 <head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Meeting Auto-Man</title>
<script type="text/javascript">

function Delete_Row(row_no)
 {
 
 var del_row = document.getElementById("no_of_floors_table");
  var table_length = parseInt(del_row.rows.length)-1;
  document.getElementById("table_length").value=table_length;
  
  

var msg="Do You Want Delete Selected Row";
					var accept=confirm(msg);
					if(accept) {	
						del_row.deleteRow(row_no); 
						
						 
						
		
					} else {
						return false;
					}


return false; 
  
 

 }
 
 
    function add_row()
    {
     
   // var no_of_lands=parseInt(document.getElementById("no_of_lands").value);
     var main = document.getElementById("no_of_floors_table");
    var no_of_lands= parseInt(main.rows.length);
     
  
       var main_length = parseInt(main.rows.length)-1; 
      
     
     for(var s=main_length;s<no_of_lands;s++)
     {
   
     
     tbl = document.getElementById("no_of_floors_table");
              
                var lastRow = tbl.rows.length; 
                alert(lastRow);
                 var row = tbl.insertRow(lastRow);
 		 
                var cel;
                var el;
                var colId=0;
                var colNum=0;
                var textNode;
 				    
                cel = row.insertCell(colNum++);
                cel.style.textAlign = 'left'; 
                var el = document.createTextNode((lastRow)+"");
                cel.appendChild(el);
                colId++;
               
                              
                
                     cel = row.insertCell(colNum++);
                cel.className = "tdField";
                cel.style.textAlign = 'left';
                var el = document.createElement('input');
                el.setAttribute('name','beanProperties(registration_'+(lastRow)+')');
                el.setAttribute('id','registration_'+(lastRow));
                 el.setAttribute('maxlength','10');
                el.align = 'left';
                el.className="form-control";
                cel.appendChild(el);
                colId++;
                
                
                
                cel = row.insertCell(colNum++);
                cel.className = "tdField";
                cel.style.textAlign = 'left';
                var el = document.createElement('input');
                el.setAttribute('name','beanProperties(test_'+(lastRow)+')');
                el.setAttribute('id','test_'+(lastRow));
                 el.setAttribute('maxlength','10');
                el.align = 'left';
                el.className="form-control";
                cel.appendChild(el);
                colId++;
                    
                
                
                  cel = row.insertCell(colNum++);
                cel.className = "tdField";
                cel.style.textAlign = 'left';
         //       var el = document.createElement('select');
         		var el = document.createElement('input');
                el.setAttribute('name','beanProperties(test_2_'+(lastRow)+')');
                el.setAttribute('id','test_2_'+(lastRow));
                 el.setAttribute('maxlength','10');
         //        el.setAttribute("onchange","retrieveOptions(this,'','mandal_code','test_6_"+lastRow+"');");
                el.align = 'left';
                el.className="form-control";
            /*     for(var i=0;i< document.getElementById('test_2_1').options.length;i++) {
		   			el.options[i] = new Option(document.getElementById('test_2_1').options[i].text,document.getElementById('test_2_1').options[i].value);
				} */
                cel.appendChild(el);
                colId++;  
                
                
                
                   cel = row.insertCell(colNum++);
                cel.className = "tdField";
                cel.style.textAlign = 'left';
                var el = document.createElement('input');
                el.setAttribute('name','beanProperties(test_3_'+(lastRow)+')');
                el.setAttribute('id','test_3_'+(lastRow));
                 el.setAttribute('maxlength','10');
                el.align = 'left';
                el.className="form-control";
                cel.appendChild(el);
                colId++;  
                
                 
     }
     
                                      
    
    }
       
</script>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="js/bootstrap-daterangepicker/daterangepicker.css" />
        
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <section id="container" >
  <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="home.jsp" class="logo"><b>Meeting Auto-Man</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                       <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending feedback forms</p>
                            </li>
                            <li>
                                <a href="index.html#">                                    
                                        <div class="desc"><a href="">Feedback for PT Rajasekhar/Sravan feedback</a></div>
                                        <!-- <div class="percent">40%</div> -->
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="desc"><a href="">Weekly Status feedback</a></div>
                                </a>
                            </li>
                            <li>
                               <a href="index.html#">
                                    <div class="desc"><a href="">Discussion Rajasekhar/Vijay</a></div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="desc"><a href="">Weekly Status feedback</a></div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
       <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
     <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="profile.html"><img src="img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered">Rajasekhara Reddy</h5>
              	  	
                  <li class="mt">
                      <a class="active" href="home.jsp">
                          <i class="fa fa-dashboard"></i>
                          <span>My Plan</span>
                      </a>
                  </li>

                 <!--  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-desktop"></i>
                          <span>UI Elements</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="general.html">General</a></li>
                          <li><a  href="buttons.html">Buttons</a></li>
                          <li><a  href="panels.html">Panels</a></li>
                      </ul>
                  </li>

                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-cogs"></i>
                          <span>Components</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="calendar.html">Calendar</a></li>
                          <li><a  href="gallery.html">Gallery</a></li>
                          <li><a  href="todo_list.html">Todo List</a></li>
                      </ul>
                  </li> -->
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-book"></i>
                          <span>Create Meeting</span>
                      </a>
                      <ul class="sub">
                          <li><a class="active"  href="CreateMeeting.jsp">Planned Meeting</a></li>
                          <li><a  href="bot.jsp">Urgent Meeting</a></li>                         
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="Overview meetings.jsp" >
                          <i class="fa fa-tasks"></i>
                          <span>Overview Meetings</span>
                      </a>
                  </li>
                  <!-- <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class="fa fa-th"></i>
                          <span>Data Tables</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="basic_table.html">Basic Table</a></li>
                          <li><a  href="responsive_table.html">Responsive Table</a></li>
                      </ul>
                  </li> -->
                   

              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
          	<h3><i class="fa fa-angle-right"></i> Create/Plan a Meeting</h3>
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	 
          	
          	<!-- INLINE FORM ELELEMNTS -->
          	<div class="row mt">
          		<div class="col-lg-12">
          			<div class="form-panel">
                  	    
                      <form class="form-inline" role="form">
                          <div class="form-group">
                              <label class="sr-only" numeric>From</label>
                              <input type="email" class="form-control" numeric placeholder="From time">
                          </div>
                          <div class="form-group">
                              <label class="sr-only" numeric>To</label>
                              <input type="email" class="form-control" numeric placeholder="To time">
                          </div>
                          <div class="form-group">
                              <label class="sr-only" for="exampleInputPassword2">Title</label>
                              <input type="password" class="form-control"  placeholder="Title of meeting">
                          </div>
                           <div class="form-group">
                              <label class="sr-only" for="exampleInputPassword2">Participants</label>
                              <input type="password" class="form-control"  placeholder="Participants emp_id">
                          </div>
                          <button type="submit" class="btn btn-theme">Create</button>
                      </form>
          			</div><!-- /form-panel -->
          		</div><!-- /col-lg-12 -->
          	</div><!-- /row -->
          	
           
          	<!-- CUSTOM TOGGLES -->
          		<div class="col-lg-12">
          			<div class="form-panel">
                  	  <h4 class="mb"> Do you want to plan any bulk meetings?</h4>
                            
                                  <div class="switch switch-square"
                                       data-on-label="<i class=' fa fa-check'></i>"
                                       data-off-label="<i class='fa fa-times'></i>">
                                      <input type="checkbox"  onchange="showMe('div1', this)" />
                                  </div>
                              </div>
                               
                          </div>
 
 
  <div id="div1" style="display:none; font-size: 16px;padding: 5px;">
 <div> If you want to book a bulk meetings, Please download the template and fill it properly and upload your file here..
 <a href="Bulk Meeting Template.xlsx">Bulk Meeting Template</a></div>
 <div>
 	<div class="fileupload fileupload-new" data-provides="fileupload">
    <span class="btn btn-primary btn-file"><span class="fileupload-new">Select file</span>
       <input type="file" /></span>
    <span class="fileupload-preview"></span>
    <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
  </div>
 </div>
 
 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
<table id="table" class="table table-condensed table-bordered table-striped table-responsive " border="1">
																	
									<tr>
									
							 		<td >
		<input type="button" value="Add Meeting" onclick="add_row()" class="btn btn-primary pull-left" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="Delete Meeting" onclick="removeRowFromTable();" class="btn btn-danger pull-right" />
		</td>
		
		</tr>	</table>
									 <tr>
									 <th colspan="12">
									 									 
									 <table border="1" width="100%" id="no_of_floors_table" class="tablee">
									 <tr>
									 <th >S.No</th>
									 <th>From</th>
									 <th>TO</th>
									 <th>Title </th>
									 
									 
									 <th>Participants</th>  
									  
									 </tr>
									 <logic:present name="land_det">
									 <logic:iterate id="land_det"  name="land_det" indexId="j">
									 <tr>
									 <td >${j+1} </td>
									  
									 
									 <td><html:text property="beanProperties(registration_${j+1})" styleClass="form-control" styleId="registration_${j+1}" value="${land_det.reg_no}"></html:text></td>
					 					<td><html:text property="beanProperties(test_${j+1})"   styleClass="form-control" styleId="test_${j+1}"   value="${land_det.reg_date}"></html:text></td>
										<td><html:text property="beanProperties(test_2_${j+1})" styleClass="form-control" styleId="test_2_${j+1}"  value="${land_det.rev_div}"></html:text></td>
										<td><html:text property="beanProperties(test_3_${j+1})" styleClass="form-control" styleId="test_3_${j+1}"  value="${land_det.survey_no}"></html:text></td>
										  
									 </logic:iterate>
									 
									 </logic:present>
									  
       </table>
       </th>
       </tr>
       </div>
  
</div> 



          	
		</section> 
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              TEAM DECIMAL - Version #101
              <a href="form_component.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	
	<script type="text/javascript" src="js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>	
      
      
<script>
function showMe (it, box) {
  var vis = (box.checked) ? "block" : "none";
  document.getElementById(it).style.display = vis;
}
</script>
      
                          
</body>
</html>
