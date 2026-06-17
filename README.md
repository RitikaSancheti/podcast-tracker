# 🎙️ Podcast Tracker

A full-stack podcast playlist manager built with **Java Spring Boot**, **Thymeleaf**, and an **H2 in-memory database**. Track your favourite podcasts, the streaming services they're available on, sort them your way, and manage everything from a single clean page.

![Podcast Tracker Screenshot](https://raw.githubusercontent.com/RitikaSancheti/podcast-tracker/main/screenshot.png)

---

## ✨ Features

- ➕ **Add** podcasts with title, year of release, star rating, and a direct link
- ✏️ **Edit** any existing podcast's details
- 🗑️ **Delete** podcasts you no longer want to track
- 🎛️ **Multi-streaming service support** — attach multiple services (Spotify, Apple, YouTube, etc.) to a single podcast
- 🔃 **Sort** your podcast list by:
  - 📅 Year (ascending)
  - ⭐ Rating (descending)
  - ⭐ + 🔤 Rating & Title combined
  - 🔄 Default order
- 💾 **H2 in-memory database** with pre-loaded seed data (3 podcasts ready to go on startup)
- 🖥️ **Single-page Thymeleaf UI** — clean, intuitive, no page jumping

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 25 |
| Framework | Spring Boot |
| Frontend | Thymeleaf |
| Database | H2 (in-memory) |
| ORM | Spring Data JPA |
| Build Tool | Maven |

---

## 📁 Project Structure

```
podcast-tracker/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/podcasttracker/
│       │       ├── controller/       # MVC Controllers
│       │       ├── model/            # Podcast & StreamingService POJOs (Entities)
│       │       ├── repository/       # JPA Repositories
│       │       └── bootstrap/        # Seed data on startup
│       └── resources/
│           ├── templates/            # Thymeleaf HTML page(s)
│           ├── static/               # CSS / JS
│           └── application.properties
├── pom.xml
└── screenshot.png
```

---

## 🚀 How to Open & Run in Eclipse

### Prerequisites
Make sure you have the following installed:
- ✅ [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- ✅ [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/) *(important — not the basic Eclipse)*
- ✅ Git *(optional, for cloning)*

---

### Step 1 — Get the Project

**Option A — Clone with Git**
```bash
git clone https://github.com/RitikaSancheti/podcast-tracker.git
```

**Option B — Download as ZIP**
1. Go to the repo on GitHub
2. Click **Code → Download ZIP**
3. Extract the ZIP to a folder on your computer

---

### Step 2 — Import into Eclipse

1. Open **Eclipse**
2. Go to **File → Import**
3. Select **Maven → Existing Maven Projects** → click **Next**
4. Click **Browse** and navigate to the folder where you cloned/extracted the project
5. You should see `pom.xml` appear in the list — check the checkbox
6. Click **Finish**

> ⏳ Eclipse will take a moment to download dependencies from Maven. Wait for the progress bar at the bottom to complete.

---

### Step 3 — Run the Application

1. In the **Project Explorer**, expand the project
2. Navigate to `src/main/java` → find the main class (ends in `Application.java`)
3. **Right-click** on it → **Run As → Spring Boot App**
4. Watch the Console tab — when you see:
   ```
   Tomcat started on port(s): 8080
   ```
   ...the app is running! ✅

---

### Step 4 — Open in Browser

Open your browser and go to:
```
http://localhost:8080
```

You'll see the Podcast Playlists page with seed data already loaded! 🎉

---

## 🗄️ H2 Database Console (Optional)

You can inspect the database directly in your browser while the app is running:

```
http://localhost:8080/h2-console
```

| Field | Value |
|---|---|
| JDBC URL | `jdbc:h2:mem:testdb` |
| Username | `sa` |
| Password | *(leave blank)* |

---

## 🌱 Seed Data

On startup, the app automatically loads **4 podcasts** so you're never staring at an empty screen:

| Podcast | Year | Rating | Streaming Services |
|---|---|---|---|
| Stuff You Should Know | 2008 | ⭐ 4.8 | iHeartRadio, Spotify |
| The Daily | 2017 | ⭐ 4.9 | Apple, Spotify |
| The Joe Rogan Experience | 2009 | ⭐ 4.8 | Spotify, YouTube |
| True Crime Garage | 2015 | ⭐ 4.7 | Apple, Spotify |

---

## 🙋‍♀️ Author

**Ritika Sancheti**
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=flat-square&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ritikasancheti30/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=github&logoColor=white)](https://github.com/RitikaSancheti)

---

<div align="center">
<sub>Built with ☕ Java & Spring Boot · Sheridan College</sub>
</div>
