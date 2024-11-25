# dataset-filter
Dataset Filter and reports (Java 21 / Spring boot)




# TSV Import and Query Application

This is a Spring Boot application that imports data from a TSV file (uploaded via a REST API), stores it in an in-memory H2 database, and provides endpoints for querying the data. It is built with **Java 21**, **Spring Boot**, and uses minimal dependencies for easy deployment.

---

## Features

- Import and process TSV files via REST API.
- Store the parsed data in an H2 in-memory database.
- Perform queries to filter data by name or age.
- Minimal setup and dependencies for lightweight deployment.

---

## Requirements

- **Java 21**
- **Maven** for building the project

---


### Build and Run the Application

1. **Build the project**:

   ```bash
   mvn clean install
   ```

2. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

3. Access the application at: `http://localhost:8080`.

---

## API Endpoints

### 1. **Sample Import TSV File: Titles **

**Endpoint:**  
`POST /api/v1/import/titles`

**Description:**  
Uploads and imports a TSV file containing the data. The first row of the file should contain headers.

**Request Example (cURL):**
```bash
curl --location 'localhost:8080/api/v1/import/titles' \
--form 'file=@"/Users/farid/Downloads/title.basics.tsv"' \
--form 'maxNumberOfRecords="1000"'
```


---

## H2 Database Access

The application uses an in-memory H2 database for simplicity. You can view the database schema and data using the H2 console:

1. Access the H2 console at: `http://localhost:8080/h2-console`.
2. Use the following credentials:
    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **Username:** `sa`
    - **Password:** (leave blank)

---
