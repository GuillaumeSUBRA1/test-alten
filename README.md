avant de lancer le back-end, créez le conteneur decker pour la base de données post gresql avec la commande suivante

docker run -d --name alten -p 5432:5432 -e POSTGRES_PASSWORD=alten -e POSTGRES_USER=alten postgres
 
