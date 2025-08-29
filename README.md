# QR-Generator

### Android App to Generate QR Codes Dynamically

#### Screenshots

<img src="https://github.com/user-attachments/assets/2b3725c6-1e4f-43cf-8a89-0fe8ee9f2471" width="150" height="300" />
<img src="https://github.com/user-attachments/assets/1a6a78d0-7b39-4274-aacb-307dc7da4608" width="150" height="300" />
<img src="https://github.com/user-attachments/assets/0f67a2e6-fd65-42a6-a5e7-84bf984da68c" width="150" height="300" />
<img src="https://github.com/user-attachments/assets/bdf5b01a-f7ea-477f-9ace-5ffd3bd93f81" width="150" height="300" />

#### Shortlink & Redirect

<img src="https://github.com/user-attachments/assets/106e7a16-e6a7-49f5-af74-f5d3c3a88829" width="150" height="250" />
<img src="https://github.com/user-attachments/assets/c8358dc3-4a3a-4db2-9ef0-dd31329566b4" width="150" height="250" />
<img src="https://github.com/user-attachments/assets/0bc6c1b3-2354-4089-b996-71eae590be29" width="150" height="250" />
<img src="https://github.com/user-attachments/assets/a23699ec-0122-4755-a0c2-2c797007a545" width="150" height="250" />

---

## How to Use the App

1. **Open the app** on your Android device or emulator.  
2. **Enter the URL** you want the QR code to redirect to in the TextField.  
3. **Generate the QR code** by tapping the "Generate" button.  
4. The QR code will always point to the same shortlink. Updating the URL dynamically changes the redirection destination.  
5. **Scan the QR code** with any QR scanner to test it.

---

## Tools & Technologies Used

- **Language:** Kotlin – modern, type-safe language for Android development.  
- **IDE:** Android Studio – official IDE for Android development with full Gradle support.  
- **Libraries & SDKs:**  
  - **ZXing:** used for generating QR codes dynamically.  
  - **Firebase Firestore / Realtime Database:** for storing shortlink mappings and dynamic URL updates (if implemented).  
  - **GitHub Pages:** used to host shortlinks and handle redirection for QR codes.  
  - **Android Jetpack Components:** LiveData, ViewModel for managing UI state and data flow.  
  - **Dagger / Hilt (Dependency Injection):** for modular and testable architecture.  
- **Platform:** Android SDK – supports a wide range of devices and versions.  
- **Version Control:** Git & GitHub – for code management, versioning, and collaboration.  
- **Other Tools / Practices:**  
  - **Gradle:** for dependency management and build automation.  
  - **MVVM Architecture:** separates UI from business logic.  
  - **Clean Code Principles:** meaningful variable names, modularization, and readability. 

