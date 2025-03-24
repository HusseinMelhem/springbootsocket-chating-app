# Chat Application

This is a simple real-time chat application built with Spring Boot on the backend and a plain HTML/JavaScript front-end using SockJS and STOMP for messaging. The application supports a public chat room where users can join, send messages, and see events (join, chat, leave) logged in a file.

## Features

- **Real-Time Messaging:**  
  Uses WebSocket with STOMP for instant communication between clients and server.

- **Public Chat Room:**  
  All users connect to a single public room.

- **Event Logging:**  
  Join, chat, and leave events are logged into a text file for persistence and historical review.

- **File-Based Chat Logs:**  
  Instead of a database, chat logs are saved to a text file, which is loaded when a new user connects.

## Technologies Used

- **Backend:**
  - Java 8+ and Spring Boot
  - Spring WebSocket (STOMP)
  - Maven for build and dependency management

- **Frontend:**
  - HTML, CSS, and Vanilla JavaScript
  - SockJS and STOMP.js for WebSocket communication

## Installation and Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven
- Git

### Backend Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/chat-application.git
Navigate to the Project Directory:

bash
Copy
cd chat-application
Build the Project:

bash
Copy
mvn clean install
Run the Application:

bash
Copy
mvn spring-boot:run
The server will start on http://localhost:8080.

Frontend Access
The frontend is served by the Spring Boot application. Simply open your browser and navigate to http://localhost:8080.

Usage
Join the Chat:
On the landing page, enter your username and click "Start Chatting" to join the public chat room.

Send Messages:
Type your message in the input field and click "Send" to broadcast it to all users.

Chat Log Persistence:
All messages, including join and leave events, are logged in a text file (e.g., chat-logs/public.txt). When a new user connects, the previous chat log is loaded and displayed in the same format as live messages.

Leave Event:
When you close the browser or navigate away, a leave event is sent to the server to notify other users.

Future Enhancements
Multiple Chat Rooms:
Allow users to select and join different chat rooms.

User Authentication:
Add login/signup functionality for a more personalized experience.

Improved UI/UX:
Enhance the front-end using frameworks like React and later extend it with React Native for mobile support.

Contributing
Contributions are welcome! Please fork the repository and submit pull requests for any improvements or new features.

License
This project is licensed under the MIT License.

yaml
Copy

---

Feel free to modify or extend this README to better suit your project details and future plans.
