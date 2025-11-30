# 🚀 Running the Project (Java 21 + JavaFX 22)

This application is built using **Java 21** and **JavaFX 22**.  
Because JavaFX is **not bundled** with JDK 21, the JavaFX SDK must be downloaded and added manually.

Follow the instructions below to run the project correctly.

---

## ✅ Requirements

- **JDK 21**
- **JavaFX SDK 22.0.1**
- **IntelliJ IDEA**

Verify your Java version:

```
java -version
```

## 1. Download JavaFX SDK 22.0.1
JavaFX binaries are provided officially by Gluon (OpenJFX).
Download the SDK matching your architecture and you should now have:
```
javafx-sdk-22.0.1/
└── lib/
```
You will use the lib directory path in your run configuration.

##  2. Remove JavaFX From Maven Dependencies
This project uses the JavaFX SDK directly, not Maven.

Ensure your pom.xml does NOT contain:
```
<dependency>
<groupId>org.openjfx</groupId>
<artifactId>javafx-controls</artifactId>
<version>22.0.1</version>
</dependency>

<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-fxml</artifactId>
    <version>22.0.1</version>
</dependency>
```
Reload Maven after removing them.

## 3. Configure IntelliJ Run Configuration
1. Go to Run → Edit Configurations
2. Select or create an Application configuration named Main
3. Set Main class to:
```
   com.thereadingroom.ui.Main
```
4. In VM Options, paste (adjust path if needed):
```
--module-path /Users/username/Downloads/javafx-sdk-22.0.1/lib
--add-modules javafx.controls,javafx.fxml
```
5. Ensure JDK 21 is the selected Runtime JDK.

## 4. Build & Run
In IntelliJ:
```
Build → Rebuild Project
Run → Run 'Main'
```
The JavaFX login UI should now open successfully.

## 📁 Project Structure
```
src/
 └── main/
      ├── java/com/thereadingroom/...     # Application logic
      └── resources/fxml/                 # FXML screens (login.fxml, register.fxml, etc.)
```
