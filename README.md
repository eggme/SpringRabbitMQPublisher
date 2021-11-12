docker run -d --name rabbitmq -p 5672:5672 -p 8080:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=1234 rabbitmq:management
