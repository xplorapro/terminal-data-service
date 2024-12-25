# terminal-data-service
Local RESTful CRUD APIs for Terminal dataset

**JSON Structure**

*{
    "airport": "LAX",
    "terminalNumber": 3,
    "passengerCount": 567890,
    "temperature": 21.45,
    "stats": {
      "avgWaitTime": 18.75,
      "satisfaction": 4.2,
      "occupancyRate": 82.5,
      "lastChecked": "2024-12-25T08:20:15Z",
      "isOpen": true
    },
    "gates": ["B1", "B2", "B3"]
  }*

The JSON represents data about an airport terminal, including:

* **Airport:** LAX (Los Angeles International Airport)
* **Terminal Number:** 3
* **Passenger Count:** 567,890
* **Temperature:** 21.45 degrees (likely Celsius)
* **Terminal Statistics:** 
    * Average wait time: 18.75 minutes
    * Customer satisfaction rating: 4.2 out of 5
    * Occupancy rate: 82.5%
    * Last data update: December 25, 2024, 8:20:15 AM 
    * Terminal is currently open
* **Gates:** B1, B2, and B3

Store and exchange information about a specific airport terminal.

