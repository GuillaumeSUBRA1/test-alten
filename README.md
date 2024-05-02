le back end a été configuré pour java 17.

avant de lancer le back-end, créez le conteneur docker pour la base de données postgresql avec la commande suivante : docker run -d --name alten -p 5432:5432 -e POSTGRES_PASSWORD=alten -e POSTGRES_USER=alten postgres
