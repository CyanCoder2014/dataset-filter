# dataset-filter
Dataset Filter and reports (Java 21 / Spring boot)




# TSV Import and Query Application

This is a Spring Boot application that imports data from a TSV file (uploaded via a REST API), stores it in an in-memory H2 database, and provides endpoints for querying the data. It is built with **Java 21**, **Spring Boot**, and uses minimal dependencies for easy deployment.

---

## Features

- Upload and process TSV files via REST API.
- Store the parsed data in an H2 in-memory database.
- Perform queries to filter data by name or age.
- Minimal setup and dependencies for lightweight deployment.

---

## Requirements

- **Java 21**
- **Maven** for building the project

---

## Getting Started

### Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>
```

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

### 1. **Upload TSV File**

**Endpoint:**  
`POST /people/import`

**Description:**  
Uploads and imports a TSV file containing the data. The first row of the file should contain headers.

**Request Example (cURL):**
```bash
curl -X POST -F 'file=@/path/to/your-file.tsv' http://localhost:8080/people/import
```

**Sample TSV File:**
```text
name	age
John Doe	30
Jane Smith	25
```

**Response Example:**
```json
{
  "message": "Data imported successfully!"
}
```

---

### 2. **Get All People**

**Endpoint:**  
`GET /people`

**Description:**  
Fetches all the people stored in the database.

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "age": 25
  }
]
```

---

### 3. **Filter by Name**

**Endpoint:**  
`GET /people/by-name`

**Query Parameter:**
- `name`: The name or substring to filter.

**Request Example:**
```bash
GET /people/by-name?name=John
```

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30
  }
]
```

---

### 4. **Filter by Age**

**Endpoint:**  
`GET /people/by-age`

**Query Parameter:**
- `age`: The minimum age to filter.

**Request Example:**
```bash
GET /people/by-age?age=25
```

**Response Example:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "age": 30
  },
  {
    "id": 2,
    "name": "Jane Smith",
    "age": 25
  }
]
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

## Project Structure

```
src/
├── main/
│   ├── java/com/example/tsvapp/
│   │   ├── controller/PersonController.java
│   │   ├── service/TsvImportService.java
│   │   ├── model/Person.java
│   │   ├── repository/PersonRepository.java
│   └── resources/
│       ├── application.properties
│       └── data/sample.tsv (optional sample file)
└── test/
    ├── java/com/example/tsvapp/
    │   ├── TsvAppApplicationTests.java
```

---

## Future Enhancements

- Add validation for TSV file format and content.
- Support pagination and sorting in query endpoints.
- Extend filtering options with advanced query parameters.

---

## License

This project is open-source and available under the [MIT License](LICENSE).

---

## Contributing

Feel free to open issues or submit pull requests for improvements and bug fixes. Contributions are welcome!
