# bkn-traveler


# Docker commands

* Database commands

$ docker pull postgres:12-alpine 

$ docker run -p 5433:5432 --name bkn-traveler-pg12 --network bkn-net -e POSTGRES_PASSWORD=Famo2369 -e POSTGRES_DB=db_bkn_traveler postgres:12-alpine


* Application commands

$ cd ../../bkn-traveler

$ ./mvnw clean package -DskipTests

$ docker build -t bkn-traveler:v1 .

$ docker run -P --network bkn-net bkn-traveler:v1