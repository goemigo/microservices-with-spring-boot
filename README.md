# Currency Conversion Microservices

Welcome to the Currency Conversion Microservices Project repository! This project demonstrates the implementation of two microservices, the Currency Exchange Service and the Currency Conversion Service, using Java Spring Boot as the framework. These microservices allow users to perform currency conversion by sending API requests to the services. The project is containerized using Docker and hosted on Kubernetes (GKE) for efficient deployment and scalability.

## Project Overview

The Currency Conversion Microservices Project consists of two main microservices:

1. **Currency Exchange Service:** This microservice provides the current exchange rate between different currencies. Users can request the exchange rate for a specific currency pair by sending an API request.

2. **Currency Conversion Service:** This microservice enables users to convert an amount from one currency to another based on the exchange rate provided by the Currency Exchange Service. Users can send a conversion request with the source and target currencies along with the amount to be converted.

## Features

- **Containerization with Docker:** Both microservices are containerized as Docker images, ensuring consistency and portability across different environments.

- **Automatic Horizontal Scaling with Kubernetes (GKE):** Kubernetes is used to manage and orchestrate the deployment of microservices. Automatic horizontal scaling is configured to trigger when CPU utilization exceeds 70%, ensuring high performance during increased traffic.

- **Zero Downtime Deployment:** Liveness and readiness probes are configured to monitor the health of the microservices. This ensures uninterrupted service availability even during updates or maintenance, minimizing downtime.

