# Text-Chat-Application
# Project Title

This Chat Application is build using Spring Framework. Programming languages used are Java, JSP, HTML, CSS and JQuery. For designing Bootstrap is also used.

# Functionalities
1. Chat with a friend (username show be known).
2. Chat Room (chat with everyone).
3. Share files with everyone.

# Project Setup and working

1. Download the full project, and import project into Eclipse IDE (with tomcat v8.0 set up).
2. SQL dump file has been provided giving the whole backup of database. 
    To import the database, follow: 
    1. Open the MySQL command line
    2. Type the path of your mysql bin directory and press Enter
    3. Paste your SQL file inside the bin folder of mysql server.
    4. Create a database in MySQL.
    5. Use that particular database where you want to import the SQL file.
    6. Type source databasefilename.sql and Enter
    7. Your SQL file upload successfully.
    If there is problem importing sql dump file, follow the link: https://stackoverflow.com/questions/17666249/how-to-import-an-sql-file-using-the-command-line-in-mysql
    (NOTE: Name of the database should be "chat". It is mandatory to load sql dump file, as web application wouldn't run if name of database or tables is changed.)
3. Once this is done, in eclipse, right click on project and run on server.
4. If the webpage opens in eclipse browser, copy the link to your default broswer (Opera, Mozilla, Chrome or Edge), and add "login" to the end of the link.
    For example: In my case, I open: "http://localhost:8050/ChatApplication/login" on my browser.
5. Login Page will appear. You can login using these 4 accounts:
    1. Username: rajat; Password: rajat
    2. Username: user1; Password: user1
    3. Username: user2; Password: user2
    4. Username: user3; Password: user3 or Create another account by clicking Sign Up.
    
6. Now once you login, you can either chat with your friend or chat room (where everybody can chat).
7. In chat with your friend, if your friend is not online, a message will be displayed that the person is not online, or else you can send messages to the person.
8. In Chat Room, you can send message and everyone online can see it or reply.
9. You can also share files with everyone, and can view others files (that have been shared). (Note: Size of file should be small)
10. Once you logout, you are offline. 

### Prerequisites

1. Eclipse Java EE IDE for Web Developers. (with Tomcat v8.0)
    Version: Oxygen Release (4.7.0)
2. MySQL Server 5.0
3. Web Browser: Opera, Microsoft Edge or Chrome.

