##

<p align="center">
  <img src="https://github.com/user-attachments/assets/65df00f8-c35d-4f52-9330-efa58f1c10cb" alt="Banner" width="600" />
</p>


## Overview

**MyLib** is a library management system developed in Java with Maven. The system is in Brazilian Portuguese, which is my native language. It provides a range of functionalities to streamline the management of books, magazines, employees, and clients. The system allows for efficient tracking of book and magazine loans and returns and provides detailed reports on library activities.

<p align="center">
  <img src="https://github.com/user-attachments/assets/a7e74d75-3b48-4785-ab04-c64189066778" alt="Login" width="300" style="display:inline-block;" />
  <img src="https://github.com/user-attachments/assets/eddf1c40-e1bb-4601-809d-880a5a2124a3" alt="Dashboard" width="500" style="display:inline-block;" />
</p>

## Features

- **Book and Magazine Management**: Add, edit, and remove books and magazines from the system.
- **Loan and Return Management**: Track the borrowing and returning of books and magazines.
- **Employee Management**: Register employees and assign roles.
- **Client Management**: Add and maintain client information.
- **Reporting**: Shows the actions performed in the system.


## Database

The system uses a cloud-based database managed via phpMyAdmin.
- **Important:** The code in this repository does not include a database connection. The full functionality of the system is available only through the executable provided in the releases.

## Want to take a test?

- **Download the Executable**: Go to the [releases page](https://github.com/JotaP07/MyLib/releases/tag/Dowload) and download the latest version of the executable `.jar` file.
- Use the provided test credentials to log in and test the system:
  - **Username:** tester
  - **Password:** 123
 
   <p align="left">
  <img src="https://github.com/user-attachments/assets/12a86ece-ee5c-4d01-942f-571de27585d6" alt="LoginTester" width="500" style="display:inline-block;" />
  </p>


## Getting Started

To clone and explore the MyLib project, please note that the code in this repository is designed primarily for educational purposes. The code provided does not include a database connection, so the system will not function fully if you only clone the repository. For complete functionality, use the executable provided in the releases section.

### **Prerequisites**

- **Java Development Kit (JDK) 17**: Ensure you have JDK 17 installed. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or [AdoptOpenJDK](https://adoptopenjdk.net/).
- **Maven**: Install Apache Maven to build and manage your project dependencies. You can download it from [Maven's official site](https://maven.apache.org/download.cgi).
- **IDE**: While you can use any Java IDE, I personally recommend NetBeans or IntelliJ IDEA for this project. **Furthermore, the IDE will facilitate your access and modification of the cloned code**

### **Clone the Repository**

1. Open a terminal or command prompt.
2. Clone the repository using the following command:

    ```bash
    git clone https://github.com/JotaP07/MyLib.git
    ```

3. Navigate into the project directory:

    ```bash
    cd MyLib
    ```

### **Build the Project**

1. Use Maven to build the project. Run the following command:

    ```bash
    mvn clean package
    ```

    This command will download dependencies, compile the code, and package it into a `.jar` file.

### **Run the Executable**

1. **Important Note**: The cloned code will not function completely as it does not include a database connection. To use the system with full functionality, you must use the pre-built executable `.jar` file available in the releases section. 

    - **Download the Executable**: Go to the [releases page](https://github.com/JotaP07/MyLib/releases/tag/Dowload) and download the latest version of the executable `.jar` file. Generally, the executable will have `with-dependencies` in its name to indicate that it includes all necessary dependencies.

2. After downloading, you can run the executable `.jar` file using the following command:

    ```bash
    cd target
    java -jar .\MyLib-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```

    Replace `myLib-with-dependencies.jar` with the name of the downloaded `.jar` file if it's different.

### **Configuration**

- **Database Configuration:** The code in this repository does not include a database connection. The full functionality of the system is available only through the executable provided in the releases.

### **Notes**

- The system is currently in Brazilian Portuguese. Future updates will include an option to change the language to English.
- Features under development include:
  - Permission blocking
  - Loan date
  - Expected return date
  - Actual return date
  - Supplier inclusion

If you encounter any issues or have questions, feel free to reach out.


## Contributing

I am open to suggestions and contributions. If you would like to add something to the code or provide feedback, please contact me directly.
<br><br>


<p align="center">
   💬 Send me a Message 🗨️
</p>
 <p align="center">
  <a href="https://www.linkedin.com/in/joão-pedro-canhete-34460b236/" target="_blank">
    <img src="https://user-images.githubusercontent.com/88904952/234979284-68c11d7f-1acc-4f0c-ac78-044e1037d7b0.png" alt="linkedin" height="50" width="50" />
  </a>
  <a href="mailto:jpcanhete.contact@gmail.com" target="_blank">
    <img src="https://github.com/Mo-Alsehli/Mo-Alsehli/assets/98949843/6d935082-a6bb-4f5d-be13-87b821d8421c" alt="gmail" height="50" width="50" />
  </a>
  <a href="https://www.instagram.com/joao.canhete/" target="_blank">
    <img src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="hridoyalhazard" height="50" width="50" />
  </a>
  <a href="https://discord.com/channels/jotapeee07" target="_blank">
    <img src="https://user-images.githubusercontent.com/88904952/234982627-019fd336-6248-453c-9b05-97c13fd1d207.png" alt="discord" height="50" width="50" />
  </a>
  <a href="https://x.com/JpDev_" target="_blank">
    <img alt="Vedant Jajoo Twitter" width="50" src="https://raw.githubusercontent.com/edent/SuperTinyIcons/099dc12b59179d07d534069bc8551718f786d91a/images/svg/twitter.svg" />
  </a>
</p>


