build:
	docker-compose build
	
up:
	docker-compose up -d
	
down:
	docker-compose down

compile: up
	docker exec -it tp-barman javac fr/epsi/binome/Program.java

exec: compile
	docker exec -it tp-barman java fr/epsi/binome/Program