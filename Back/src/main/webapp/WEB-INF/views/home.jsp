<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Thames Water API!
</h1>
Why should you do a sanity check at this point?<br/>
>><i>Because you are awesome!</i>
	<ol>
		<li>DMAs: <a href='http://localhost:8080/tw/dma'> http://localhost:8080/tw/dma</a></li>
		<li>Devices: <a href='http://localhost:8080/tw/dma/ZCOCKF06/devices'>http://localhost:8080/tw/dma/ZCOCKF06/devices</a></li>
		<li>Devices/ZCOCKF06/devices/readings: <a href='http://localhost:8080/tw/dma/ZCOCKF06/devices/readings'>http://localhost:8080/tw/dma/ZCOCKF06/devices/readings</a></li>
		<li>Catchments <a href='http://localhost:8080/tw/catchments'>http://localhost:8080/tw/catchments</a></li>
		<li>TreatmentWorks <a href='http://localhost:8080/tw/catchments/1/treatmentworks'>http://localhost:8080/tw/catchments/1/treatmentworks</a></li>
		<li>Level Monitors: <a href='http://localhost:8080/tw/catchments/1/levelmonitors '>http://localhost:8080/tw/catchments/1/levelmonitors</a></li>
		<li>Pumping Stations <a href='http://localhost:8080/tw/catchments/1/pumpingstations'>http://localhost:8080/tw/catchments/1/pumpingstations</a></li>
		<li>Connectivity</li>
		<li>Init leak : <a href='http://localhost:8080/tw/get/projections/leak'>http://107.23.22.159/tw/tw/get/projections/leak</a></li>
		<li>Leak Prediction</li>
	</ol>  


Curl<br/>
curl http://localhost:8080/tw/dma | python -mjson.tool<br/>
curl http://localhost:8080/tw/dma/ZCOCKF06/devices/readings | python -mjson.tool<br/>
curl http://localhost:8080/tw/catchments/1/levelmonitors | python -mjson.tool<br/>
curl http://localhost:8080/tw/get/projections/leak | python -mjson.tool<br/>
curl "http://localhost:8080/tw/catchments/1/pumpingstations" | python -mjson.tool
curl "http://localhost:8080/tw/catchments"


<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
