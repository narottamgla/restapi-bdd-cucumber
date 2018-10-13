Feature: Verify Geocoding and Reverse GeocodingAPI of Google 

Scenario: Verify Google Geocoding API with Valid data 
	Given The user have proper API key 
	And Have valid location address as "49 Bogart St, Brooklyn, NY 11206, USA" 
	When The user sents GET request to google Geocoding API with API key 
	Then API should return status as 200 
	And Response content type should be json 
	And Response should have result node 
	And Result should have status as "OK" 
	And Result should have formatted address as "49 Bogart St, Brooklyn, NY 11206, USA" 
	And Result should have address_components 
	And Result should have geometry 
	And Geo metry should have location lat as "40.7054058" 
	And Geo metry should have location lng as "-73.9335481" 
	And Geo metry should have location_type "ROOFTOP" 
	And Geo metry should view port northeast 
	And Geo metry should view port southwest 
	And Northeast should have lat as "40.7067251302915" 
	And Northeast should have lng as "-73.9322127697085" 
	And Southwest should have lat as "40.7040271697085" 
	And Southwest should have lng as "-73.9349107302915" 
	
	
Scenario: Verify Google Reverse Geocoding API with Valid data 
	Given The user have proper API key 
	And Have valid location lat as "40.7054058"
	And Have valid location lang as "-73.9335481"
	When The user sents GET request to google Reverse Geocoding API with API key 
	Then API should return status as 200 
	And Response content type should be json 
	And Response should have result node 
	And Result should have status as "OK" 
	And Result should have formatted address as "49 Bogart St #1g, Brooklyn, NY 11206, USA" 
	And Result should have address_components 
	And Result should have geometry 
	And Geo metry should have location lat as "40.7054058" 
	And Geo metry should have location lng as "-73.9335481" 
	And Geo metry should have location_type "ROOFTOP" 
	And Geo metry should view port northeast 
	And Geo metry should view port southwest 
	And Northeast should have lat as "40.7067547802915" 
	And Northeast should have lng as "-73.9321991197085" 
	And Southwest should have lat as "40.7040568197085" 
	And Southwest should have lng as "-73.9348970802915" 
	
	
    