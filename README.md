# From CS 3220 to Senior Design Workshop

The example code used in the demo of the workshop can be found in this repository. Please go through the following steps if you want to run the project:


## Project Setup

1. Load project into Eclipse. To open a new project, go to `File > Open Projects from File System` and choose where you've cloned/downloaded this project.

2. Configure your MySQL Database login in the applications.properties file under `src/main/resources`. 

Things to change:
- spring.datasource.url
- spring.datasource.password
- spring.datasource.user

3. Go to `src/main/java/newHW3` and locate `NewHw3Application.java`. This is the file you must run to start the project, so right click on it and `Run As > Java Application`. 


## Project Features

Web Application:
- View all movies at `/index.html` or `/movies/list` (homepage)
- Add a movie at `/movies/add`
- View a movie's reviews at `/movies/list/{movie id}`
- Add a review to a movie at `/movies/add/{movie id}`

API:
- Get the list of all movies at `/api/movies`