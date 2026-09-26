# Product Search API (Semantic Vector Search)

An AI-powered Semantic Product Search REST API built with **Spring Boot 4.1**, **Spring AI**, **Spring Data JPA**, and **PostgreSQL (pgvector)**.

## 🚀 Key Features
- **Semantic Similarity Search**: Performs cosine similarity search over product descriptions using vector embeddings instead of brittle exact keyword matches.
- **Dual Persistence**: Persists structured relational product data (ID, name, description, price) into PostgreSQL while storing vector embeddings and metadata in `pgvector`.
- **Top-K Retrieval**: Returns the most relevant products ranked by semantic proximity to the user's natural language search query.

## 🛠️ Tech Stack
- **Java 17**
- **Spring Boot 4.1**
- **Spring AI 2.0** (OpenAI & pgvector Store Starters)
- **Spring Data JPA / Hibernate**
- **PostgreSQL / pgvector**
- **Maven** & **Lombok**

## 📡 API Endpoints
- `POST /api/products` - Add a new product (saves to relational database and indexes embedding in vector store).
- `GET /api/products/search?query={search_text}` - Search products semantically via vector similarity.

## ⚙️ Configuration
Set your PostgreSQL and OpenAI credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/productdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.ai.openai.api-key=${OPENAI_API_KEY}
```

## 🏗️ Build and Run
```bash
./mvnw clean install
./mvnw spring-boot:run
```
