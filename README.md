# bkn-traveler

$ docker pull postgres:12-alpine 

$ docker run -p 5433:5432 --name bkn-traveler-pg12 --network bkn-net -e POSTGRES_PASSWORD=Famo2369 -e POSTGRES_DB=db_bkn_traveler postgres:12-alpine
