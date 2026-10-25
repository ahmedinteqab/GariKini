# 🚗 GariKini – Android Vehicle Marketplace

**GariKini** is a feature-rich Android vehicle marketplace application developed using **Java and XML**. The application provides a convenient platform for users to browse vehicles, explore detailed specifications, post vehicle advertisements, manage profiles, and connect directly with sellers.

The project focuses on a clean user interface, smooth navigation, and essential vehicle marketplace functionalities.

---

## ✨ Features

- **🎬 Animated Splash Screen** – Displays an animated app logo for 3 seconds when the application launches.
- **🔐 User Authentication** – Login and registration screens with form validation and password visibility toggles.
- **🏠 Home Feed** – A grid-based marketplace displaying vehicle listings with images, prices, locations, and conditions.
- **🚘 Vehicle Details** – View vehicle photos, descriptions, brands, models, model years, conditions, prices, and seller contact information.
- **➕ Add Vehicle Listing** – Create new advertisements by adding multiple images, vehicle information, pricing, and location details.
- **🔍 Search Functionality** – Search for vehicles and explore available listings.
- **📍 Location Selection** – Select districts and upazilas to organize vehicle listings by location.
- **🗂️ Category Navigation** – Browse vehicles through dedicated category sections.
- **💬 Chats Section** – Access the application's chat interface.
- **👤 Profile Management** – Access and manage the user profile interface.
- **✈️ Biman Ticket Section** – Includes a dedicated interface for Biman ticket-related functionality.
- **🔄 Dynamic Listing Updates** – Newly added vehicle listings can be reflected in the home feed during app usage.
- **🎨 Modern UI/UX** – Uses custom drawable resources, Material Components, and responsive XML layouts.

---


## 🏗️ Application Architecture

GariKini follows a **multi-activity architecture**, where individual activities handle different application features and communicate using Android Intents.

### Main Activities

| Activity | Description |
|---|---|
| `SplashActivity` | Displays the animated logo and handles the initial navigation flow. |
| `LoginActivity` | Provides the user login interface and form validation. |
| `RegisterActivity` | Allows users to access the registration flow. |
| `HomeActivity` | Displays the main marketplace feed with vehicle listings. |
| `AddPostActivity` | Provides a form for creating new vehicle advertisements. |
| `PostDetailsActivity` | Displays complete information about a selected vehicle. |
| `CategoryActivity` | Provides category-based vehicle navigation. |
| `SearchActivity` | Provides the vehicle search interface. |
| `LocationSelectorActivity` | Allows users to select their preferred location. |
| `ChatsActivity` | Provides the chat interface. |
| `BimanTicketActivity` | Displays the Biman ticket-related interface. |
| `ProfileActivity` | Provides the user profile interface. |

---

## 📂 Project Structure

```text
GariKini/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── garikini/
│           │               ├── SplashActivity.java
│           │               ├── LoginActivity.java
│           │               ├── RegisterActivity.java
│           │               ├── HomeActivity.java
│           │               ├── AddPostActivity.java
│           │               ├── PostDetailsActivity.java
│           │               ├── ListingAdapter.java
│           │               ├── CategoryActivity.java
│           │               ├── SearchActivity.java
│           │               ├── LocationSelectorActivity.java
│           │               ├── ChatsActivity.java
│           │               ├── BimanTicketActivity.java
│           │               └── ProfileActivity.java
│           │
│           └── res/
│               ├── layout/
│               ├── drawable/
│               ├── mipmap/
│               └── values/
│
├── README.md
└── build.gradle
```

*Note: This is a representative project structure. The actual files may vary depending on your implementation.*

---

## ⚙️ Key Technical Implementations

### 1. Activity-Based Navigation
Android Intents are used to navigate between activities and pass vehicle information from one screen to another.

### 2. Vehicle Listing Management
The application uses master and display lists to manage mock vehicle inventory and update the displayed listings when new posts are added.

### 3. Image Handling
Vehicle images are displayed using Android image resources and URI-based image selection. Read URI permissions are used when sharing selected images between activities.

### 4. Form Validation
Login, registration, and vehicle submission forms include input validation to improve usability and help prevent incomplete submissions.

### 5. Custom UI Components
Custom drawable resources and Material Components are used to create styled input fields, backgrounds, and other interface elements.

---

## 🚀 Getting Started

Follow these steps to run the project locally.

### Prerequisites

- Android Studio
- Android SDK
- Java development support for Android
- An Android emulator or physical Android device

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
```

**2. Open the project**

Open Android Studio and select **Open**, then choose the cloned GariKini project folder.

**3. Sync Gradle**

Allow Android Studio to download the required dependencies and complete the Gradle sync.

**4. Run the application**

Select an Android emulator or connect a physical Android device, then click **Run ▶**.

*Replace `YOUR-USERNAME` and `YOUR-REPOSITORY` with your actual GitHub username and repository name.*

---

## 📱 Application Workflow

```text
Splash Screen
     |
     v
Login / Registration
     |
     v
Home Marketplace
     |
     ├── Browse Vehicles
     ├── Search Vehicles
     ├── Explore Categories
     ├── Select Location
     ├── View Vehicle Details
     ├── Add New Listing
     ├── Chats
     ├── User Profile
     └── Biman Ticket Section
```

---

## 🎯 Project Objectives

- Develop an Android-based vehicle marketplace using Java and XML.
- Create a user-friendly interface for browsing and advertising vehicles.
- Implement multi-activity navigation and Intent-based data passing.
- Practice Android UI development and resource management.
- Build reusable layouts and listing components.
- Demonstrate vehicle listing workflows using sample data.

---

## 🔮 Future Improvements

- Integrate Firebase or a backend API for persistent vehicle listings.
- Implement database-backed authentication and user management.
- Add real-time chat between buyers and sellers.
- Introduce advanced filtering by brand, model, price, condition, and location.
- Add a favorites and saved-listings feature.
- Implement cloud-based image uploads.
- Add push notifications for new listings and messages.
- Improve security and data validation.

---

## ⚠️ Project Status

This project demonstrates the user interface and core workflows of an Android vehicle marketplace. Some sections use mock inventory or local in-memory data. Features such as persistent cloud storage, production authentication, and real-time messaging require additional backend integration unless implemented separately.

---

## 👨‍💻 Developer

**Developed by:** Inteqab Ahmed Rohan

**Project:** GariKini – Android Vehicle Marketplace

**Platform:** Android

**Language:** Java

**UI:** XML

---

## 📄 License

This project is intended for educational and portfolio purposes. Add a suitable open-source license, such as the MIT License, if you want others to reuse and modify the code under its terms.

---

⭐ **If you find this project interesting, consider giving the repository a star!**
