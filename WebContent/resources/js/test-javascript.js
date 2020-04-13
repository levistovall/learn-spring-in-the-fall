      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
    	  var xmlhttp = new XMLHttpRequest();
    	  xmlhttp.open("GET", "getstudents");
    	  xmlhttp.onreadystatechange = function()
    	  {
    		  if(this.readyState == 4 && this.status ==200)
    		  {
        		  var studentsAsJsonObj = JSON.parse(this.responseText);

        		  var numTweens = 0;
        		  var numTeens = 0;
        		  var numYoungAdults = 0;
        		  var num25to40 = 0;
        		  var num40to65 = 0;
        		  var numSeniors = 0;
        		  
        		  var student;
        		  for(student in studentsAsJsonObj)
        		  {
        			  if(student.age < 13)
        			  {
        				  numTweens++;
        			  }
        			  else if(student.age < 18)
        			  {
        				  numTeens++;
        			  }
        			  else if(student.age < 25)
        			  {
        				  numYoungAdults++;
        			  }
        			  else if(student.age < 40)
        			  {
        				  num25to40++;
        			  }
        			  else if(student.age < 65)
        			  {
        				  num40to65++;
        			  }
        			  else
        			  {
        				  numSeniors++;
        			  }
        		  }
        		  
        		  var data = new google.visualization.DataTable();
        		  
        		  data.addColumn('string', 'Age Group');
        		  data.addColumn('number', 'Number of Students');
        		  
        		  data.addRows(
        				  [["Tweens", numTweens],
        				  ["Teens", numTeens],
        				  ["Young Adults", numYoungAdults],
        				  ["25 to 39", num25to40],
        				  ["40 to 64", num40to65],
        				  ["Seniors", numSeniors]]
        				  );

        		  
        		  // Set chart options
        		  var options = {
        				  'title':'Students By Age Group',
        				  'width':400,
        				  'height':300};

        		  // Instantiate and draw our chart, passing in some options.
        		  var chart = new google.visualization.PieChart(document.getElementById('barchart_material'));
        		  chart.draw(data, options);
    		  }
    	  }
      }