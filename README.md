# GitHub API Cache Task – Kotlin Console App

A modular Kotlin console application that interacts with the GitHub REST API to retrieve and cache user data.  
Built with Retrofit, custom dependency injection, and microkernel modularity.  
Supports efficient querying, in-memory caching, and search by username or repository name.

---

## 🚀 Features
- **Console-based interface** for GitHub user exploration  
- **Fetch user info** via GitHub REST API  
- **List cached users** with follower/following counts and public repos  
- **Search by username** from cached data  
- **Search by repository name** across cached users  
- **In-memory caching** to avoid redundant API calls  
- **Retrofit integration** for clean API communication  
- **Custom DI container** for lifecycle-safe dependency management  
- **Microkernel architecture** for modular feature injection  

---

## 🏗️ Architecture Overview
- **Microkernel**
  - Microkernel core with plug-in modules for API, cache, and search
- **API**
  - Retrofit client for GitHub API
  - Error handling and response parsing via Gson
- **Database**
  - In-memory store for user profiles and repositories
- **Controller**
  - Console menu with options:
    1. Get user info by username  
    2. List cached users  
    3. Search cached users by username  
    4. Search cached repos by name  
    5. Exit
    
---

## 🛠️ Technologies
- Kotlin  
- Retrofit  
- Gson  
- Custom DI container  
- Microkernel modularity  
- GitHub REST API  
