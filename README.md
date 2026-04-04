# 🧠 NLP Entity Extractor
A simple *Named Entity Recognition (NER)* application built using **Spring Boot** and **Stanford CoreNLP**, with a lightweight frontend for extracting entities like Person, City, Country, etc.

## 🚀 Features

* Extract named entities from text
* Supports multiple entity types:

    * 👤 Person
    * 🏙 City
    * 🌍 Country
    * 📍 State/Province
    * ✉️ Email
    * 🏷 Title

* Smart input preprocessing (capitalization handling)
* Clean and minimal frontend UI
* REST API-based architecture

## 🏗 Tech Stack

### Backend

* Java
* Spring Boot
* Stanford CoreNLP

### Frontend

* HTML, CSS, JavaScript (Vanilla)

## 📂 Project Structure

```text
├── mvnw
├── mvnw.cmd
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── nlp/
│   │   │           └── NLP/
│   │   │               ├── NlpApplication.java
│   │   │               ├── controller/
│   │   │               │   └── NERController.java
│   │   │               ├── core/
│   │   │               │   └── Pipeline.java
│   │   │               └── model/
│   │   │                   └── Type.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── nlp/
│                   └── NLP/
│                       └── NlpApplicationTests.java
└── .mvn/
    └── wrapper/
        └── maven-wrapper.properties
```

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/Himanshux19/NaturalLanguageProcessing.git
cd NLP
```

### 2️⃣ Run Backend

```bash
mvn clean install
mvn spring-boot:run
```

Backend will start at:

```text
http://localhost:8080
```

### 3️⃣ Run Frontend

* Open `index.html` directly
  OR
* Use Live Server (recommended)

## 🔗 API Endpoint

### POST `/api/v1/ner`

#### Query Parameter:

```text
type = PERSON | CITY | COUNTRY | STATE_OR_PROVINCE | EMAIL | TITLE
```

#### Request Body:

```text
Plain text input
```

#### Example:

```bash
curl -X POST "http://localhost:8080/api/v1/ner?type=PERSON" \
-H "Content-Type: text/plain" \
-d "Elon Musk lives in USA"
```

## 🧪 Example

### Input:

```text
elon musk met tim cook in usa
```

### Processed:

```text
Elon Musk Met Tim Cook In USA
```

### Output:

```text
Elon, Musk, Tim, Cook
```

## 🧠 How It Works

1. Input text is received via REST API
2. Text is preprocessed (capitalization normalization)
3. Stanford CoreNLP pipeline performs:

    * Tokenization
    * POS tagging
    * Named Entity Recognition
4. Entities are filtered based on selected type
5. Results are returned as a set


## ⚠️ Important Notes

* Backend expects:

```text
Content-Type: text/plain
```

* CORS is enabled for frontend:

```text
http://localhost:63342
```

* Proper capitalization improves NER accuracy

## 🔥 Future Improvements

* Highlight entities in UI
* Multi-entity detection (all types at once)
* Medical NLP integration (**Apache cTAKES** / BioBERT)
* True-casing using ML models
* Deployment (Render / AWS / Docker)


# 👨‍💻 Author

**Himanshu Singh**

[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?logo=github)](https://github.com/himanshux19)

## ⭐ Acknowledgements

* Stanford NLP Group
* Spring Boot Framework
