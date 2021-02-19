# PollsService

<b>Technology used:</b><br/>
Java 11, Spring Boot, PostgeSQL, JPA & Hibernate, Docker

I have decided to use this stack because it is pretty common choice in web development, and a good one.
Performance wise, for this challenge the db choice could be H2 and the JPA layer could be skipped, but I've chosen not to do so because of readability and because it is much more often choice on real projects.

<b>Steps how I've approached the tasks:</b>

- project setup (spring initializr)
- added git repo to a project
- added starting folder structure
- setup docker-compose config
- added clean_start.sh for auto restart tasks
- added basic model, controller, repository and service
- added simplified poll_temp.json and mapper to a simplifed Poll entity
- added and expanded models and tested populating db from polls.json
- made changes so responses look consistent to polls.json
- added search polls by title
- added search polls created after a certain date
- refactoring
- added a couple of tests
- added a flag in the db if the db was populated (couldn't use preferences due to docker-compose down)
- wrote README.md

<b>Given more time I would add or change:</b>

- structure tests accordingly and write them for all scenarios
- add user authentication, signup, login and JWT auth for requests, without that I have threated all pools obtained from polls.json as they were from the same user
- add pagination, additional validations and additional exceptions
- add API docs

<b>How to run the application:</b>

- in root project folder run in terminal: chmod a+x clean_start.sh
- then run: ./clean_start.sh
- in order to restart without docker-compose down, if no changes were made: restart.sh

The postman collection can be found here:
https://www.getpostman.com/collections/b3e5acd4d5344c05c42a