# Patient Management System Microservices Architecture

## Project Architecture
This is a patient management system built on a microservices architecture with multiple services:

### 1. Patient Service
The core service responsible for managing patient information with:
- **API Layer**: RESTful endpoints for CRUD operations
- **Service Layer**: Business logic for patient management
- **Repository Layer**: Data access using Spring Data JPA
- **Model**: Entity classes representing patient data
- **DTO Layer**: Data transfer objects for API communication
- **Validation**: Input validation with custom error handling
- **Database**: Persistent storage for patient records
- **Integration**: Communicates with Billing Service via gRPC (when a patient is created a billing account is created for him)
- **Messaging**: Produces Kafka events when patient data changes

### 2. Billing Service
Handles billing operations with:
- **gRPC Server**: Implements service defined in protobuf
- **Service Layer**: Billing business logic
- **Data Store**: Billing information storage

### 3. Analytics Service
Processes and analyzes patient data events with:
- **Kafka Consumer**: Consumes patient events from Kafka
- **Protobuf**: Deserializes messages using Protocol Buffers
- **Analytics Logic**: Processes patient-related events

### 4. Auth Service
Manages authentication and authorization with:
- **Login Endpoint**: Authenticates users and issues JWT tokens
- **Validation Endpoint**: Validates JWT tokens
- **Security**: Password encoding with Spring Security
- **User Repository**: Manages user credentials
- **JWT Utility**: Generates and validates JWT tokens
- **Database**: Stores user account information

### 5. API Gateway
Acts as the entry point to all services:
- **Routing**: Routes requests to appropriate services
- **Security**: JWT validation filter
- **Request Processing**: Pre/post processing of requests
- **Error Handling**: Centralized error handling
- **Documentation**: API documentation aggregation

## Technical Implementation

### 1. Spring Boot & Jakarta EE
- Spring Boot as the foundation for all services
- Spring Data JPA for data access
- Spring Security for authentication
- Spring Cloud Gateway for API Gateway

### 2. Database Management
- JPA/Hibernate for ORM
- SQL initialization scripts
- H2 for development/testing
- PostgreSQL for production

### 3. API Development
- RESTful APIs following best practices
- OpenAPI/Swagger documentation
- Request validation with error handling
- Response DTOs for controlled data exposure

### 4. Inter-Service Communication
- **gRPC**:
    - Protocol Buffers (.proto files) for service definitions
    - Generated Java code for client/server implementation
    - Binary communication protocol for efficiency between the Patient and Billing services.

- **Kafka**:
    - Event-driven architecture
    - Topics for patient-related events
    - Protobuf serialization for messages
    - Producer configuration in Patient Service
    - Consumer implementation in Analytics Service

### 5. Authentication & Security
- VPC/internal network use
- JWT-based authentication flow
- Token generation and validation
- Passwords are stored encrypted.
- Role-based authorization
- Header-based token passing
- Custom security filters
  
### 6. Infrastructure as Code
- CloudFormation templates for AWS deployment infrastructure with LocalStack:
- Resource definitions for:
    - Networking (VPC, subnets)
    - Databases
    - Kafka clusters
    - ECS clusters and services
    - Load balancers
    - Health checks

### 7. Testing Strategy
- Unit tests for service components
- Integration tests across services  

## Service Workflows

### Patient Management Flow
1. API Gateway receives authenticated request
2. Request is routed to Patient Service
3. Patient Service processes CRUD operation
4. Database is updated with patient information 
5. Billing Service is notified via gRPC (if applicable) to create and store a billing account for that patient
6. Event is published to Kafka
7. Analytics Service consumes the event for processing

### Authentication Flow
1. Client sends credentials to Auth Service
2. Auth Service validates credentials
3. JWT token is generated and returned
4. Client includes token in subsequent requests
5. API Gateway validates token with Auth Service
6. Request proceeds to appropriate service if token is valid
