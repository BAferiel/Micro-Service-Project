# Docker Compose for Microservices with Keycloak and Gateway

This Docker Compose configuration sets up a microservices architecture using various interconnected services. Keycloak is integrated for authentication and authorization, while an API Gateway manages routing requests to the appropriate services.

## Services Overview

### Keycloak
- **Service Name**: keycloak
- **Description**: Open-source identity and access management solution for authentication and authorization.
- **Port**: 8080

### Gateway
- **Service Name**: gateway
- **Description**: API Gateway responsible for routing requests to respective microservices.
- **Port**: 8081

### Eureka (Service Registry)
- **Service Name**: serviceregistry
- **Description**: Eureka is utilized as a service registry for service discovery among microservices.
- **Port**: 8761

*Other Microservices:*
- **Reclamation**, **Review**, **Category**, **Service**, **Commande**, **Subscription**
    - These services handle specific functionalities and communicate through the Eureka service registry.
    - They are accessible via designated ports (`8082`, `8084`, `8085`, `8083`, `8088`, `8086` respectively).

### Payment Service
- **Service Name**: payment
- **Description**: Payment service connected to a MongoDB database.
- **Port**: 3000
- **Database URL**: `mongodb+srv://bahaeddine170:ebaiwDFSlXUMoCLb@cluster0.ag1fzjf.mongodb.net/test`

### Mongo Database
- **Service Name**: mongo
- **Description**: MongoDB used by the payment service.
- **Port**: 27017
- **Credentials**:
    - Username: bahaeddine170
    - Password: ebaiwDFSlXUMoCLb
    - Database: test

### MySQL Database
- **Service Name**: mysql
- **Description**: MySQL database with pre-configured settings.
- **Port**: 3306
- **Credentials**:
    - Root Password: root
    - User: admin
    - Password: admin

## Usage

1. Clone this repository.
2. Navigate to the root directory containing `docker-compose.yml`.
3. Run `docker-compose up` to start all services.

Access Keycloak at `localhost:8080` for authentication setup and utilize the Gateway (`localhost:8081`) to interact with various microservices.
