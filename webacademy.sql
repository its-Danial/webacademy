-- ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';
-- SELECT VERSION(); 

-- CREATE DATABASE web_academyDB;
use web_academyDB;

SELECT * FROM student;
SELECT * FROM student_sequence;
SELECT * FROM teacher;
SELECT * FROM teacher_sequence;
SELECT * FROM course;
SELECT * FROM course_lecture;
SELECT * FROM category;	
SELECT * FROM category_topics;
SELECT * FROM course_category_mapping;
SELECT * FROM student_course_mapping;
SELECT * FROM shopping_cart;
SELECT * FROM cart_course_mapping;
SELECT * FROM student_progress;


INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (1, "hardyhenritgb@gmail.com", "Hardy Henri", "ejTkOtKi", "Kaito");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (2, "kenny1212@gmail.com", "Kenny Soeharto", "ed5jbc3K", "Kairi");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (3, "marco.zhang@gmail.com", "Marco Zhang", "0ZH0PY86", "Marky");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (4, "stephcurry55@gmail.com", "Stephan Curry", "0NTgZ3ju", "Steph");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (5, "smithleonardo98@gmail.com", "Leonardo Smith", "dcS5IGgF", "Leo");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (6, "angelina1234@gmail.com", "Angela William", "Ue2N8uFD", "Angelina");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (7, "melvern6734@gmail.com", "Melvern Kumar", "AXdd43qO", "Velmar");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (8, "marcus.tarzan@gmail.com", "Marcus Tarzan", "wTvGqz2o", "Tarzan");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (9, "renborenbo1212@gmail.com", "Ronaldo Tsing", "6m9jJpRe", "Renbo");
INSERT INTO student (student_id, email_address, full_name, `password`, username) VALUES (10, "jake.kaiten@gmail.com", "Jake Kaiten", "fDELJ5vc", "Jack");
UPDATE student_sequence SET next_val = 11; 


INSERT INTO shopping_cart VALUES(1);
INSERT INTO shopping_cart VALUES(2);
INSERT INTO shopping_cart VALUES(3);
INSERT INTO shopping_cart VALUES(4);
INSERT INTO shopping_cart VALUES(5);
INSERT INTO shopping_cart VALUES(6);
INSERT INTO shopping_cart VALUES(7);
INSERT INTO shopping_cart VALUES(8);
INSERT INTO shopping_cart VALUES(9);
INSERT INTO shopping_cart VALUES(10);

INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (10, "https://img-c.udemycdn.com/user/200_H/10260436_946b_6.jpg", "Avinash Jain is currently a senior at UC Berkeley majoring in Electrical Engineering and Computer Science. He's the CEO and Founder of TheCodex, an online educational platform focused on bringing the best programming content to hundreds of thousands of students around the world.", "avinash.jain@gmail.com", "Avinash Jain", "P23qOZ8H", "The Codex");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (1, "https://img-c.udemycdn.com/user/200_H/599932_71aa_5.jpg", "Tim's been a professional software developer for close to 40 years.  During his career, he has worked for major companies such as Fujitsu, Mitsubishi, and Saab. His video courses are used to train developers in major companies such as Mercedes-Benz, Paypal, VW, Pitney Bowes, IBM, and T-Mobile just to name a few (via the Udemy for Business program). What makes Tim unique is his professional programming career - many instructors have never programmed professionally, let alone had a distinguished professional development career like Tim.", "timbuchalka12@gmail.com", "Tim Buchalka", "SPd5wd8I", "Tim");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (2, "https://img-c.udemycdn.com/user/200_H/6772884_fcfc_2.jpg", "Edwin Diaz is a software and web technologies engineer, a life coach trainer who is also a serial entrepreneur with multiple online businesses, ranging from online jewelry shops, affiliate websites, application development and consultations services, personal online schools, etc. With over one million students, and clients growing by the thousands a day, Mr. Diaz lets the numbers speak for themselves.", "edwindiaz@gmail.com", "Edwin Diaz", "uWdjLaDs", "Coding Faculty Solutions");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (3, "https://img-c.udemycdn.com/user/200_H/8735380_e11b_4.jpg", "Bharath Thippireddy is an Entrepreneur, Software Architect and Public Speaker who has trained 500000 + students across the planet. He is Oracle Certified Developer, Web Component Developer, Business Component Developer, Web Services Developer.", "bharath.thippireddy@gmail.com", "Bharath Thippireddy", "6lLQS5Sy", "Bharath");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (4, "https://img-c.udemycdn.com/user/200_H/9685726_67e7_4.jpg", "Jose Marcial Portilla has a BS and MS in Mechanical Engineering from Santa Clara University and years of experience as a professional instructor and trainer for Data Science, Machine Learning and Python Programming. He has publications and patents in various fields such as microfluidics, materials science, and data science. Over the course of his career he has developed a skill set in analyzing data and he hopes to use his experience in teaching and data science to help other people learn the power of programming, the ability to analyze data, and the skills needed to present the data in clear and beautiful visualizations. ", "joseportilla43@gmail.com", "Jose Portilla", "TaNYjUDe", "Portilla");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (5, "https://img-c.udemycdn.com/user/200_H/54081036_f1d2_2.jpg", "Shubham is a software developer with a passion for teaching. He has worked with many funded startups, self projects, and as a top-rated freelancer on marketplaces. Shubham has taught programming and digital marketing to over 20,000 students online and offline as an Instructor.", "shubhamsarda@gmail.com", "Shubham Sarda", "EcHrhpAa", "Sarda");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (6, "https://img-c.udemycdn.com/user/200_H/7799204_2091_5.jpg", "Hi, I'm Jonas! I have been identified as one of Udemy's Top Instructors and all my premium courses have earned the best-selling status for outstanding performance and student satisfaction. I'm a full-stack web developer and designer with a passion for building beautiful things from scratch. I've been building websites and apps since 2010 and also have a Master's degree in Engineering.", "jonas.schmedtmann12@gmail.com", "Jonas Schmedtmann", "p0cTfONW", "Jonas");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (7, "https://img-c.udemycdn.com/user/200_H/2467626_f2e0_3.jpg", "Newly married in Cleveland Ohio, Tony is primarily focused these days on trying to be a good husband. While inexperienced at that, he's quite experienced in all things web. Tony has been programming since he was 12 years old, and got into web sites and web application development at 16. After graduating with a Computer Science degree from Case Western Reserve University, Tony continued with that interest as a Microsoft certified software application developer and architect, database designer, and user interface designer. ", "anthonyalicea55@gmail.com", "Anthony Alicea", "rChLHcBQ", "Anthony");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (8, "https://img-c.udemycdn.com/user/200_H/14788334_9734.jpg", "I've been in the IT industry for over 25 years. Today, I specialize mainly in Java, the most successful and widely known programming language in use today. I also specialize with the Spring Framework, which the most popular open source application framework for building enterprise class applications on the Java platform. Just some of the organizations I've worked with include Visa, Kohls, Federal Home Loan Bank, and Belk Department Stores.", "johnthompson@gmail.com", "John Thompson", "ziE9MzIW", "Spring Ahead Code Academy");
INSERT INTO teacher (teacher_id, avatar_picture_url, bio_text, email_address, full_name, `password`, username) VALUES (9, "https://img-c.udemycdn.com/user/200_H/5487312_0554.jpg", "Stephen Grider has been building complex Javascript front ends for top corporations in the San Francisco Bay Area.  With an innate ability to simplify complex topics, Stephen has been mentoring engineers beginning their careers in software development for years, and has now expanded that experience onto Udemy, authoring the highest rated React course. He teaches on Udemy to share the knowledge he has gained with other software engineers.  Invest in yourself by learning from Stephen's published courses.", "stephen.grider@gmail.com", "Stephen Grider", "g2CDpiMN", "Stephen");
UPDATE teacher_sequence SET next_val = 11;

INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(10, "https://i3.ytimg.com/vi/QXeEoD0pB3E/maxresdefault.jpg",
"Do you want to become a programmer? Do you want to learn how to create games, automate your browser, visualize data, and much more?
If you’re looking to learn Python for the very first time or need a quick brush-up, this is the course for you!
Python has rapidly become one of the most popular programming languages around the world. Compared to other languages such as Java or C++, Python consistently outranks and outperforms these languages in demand from businesses and job availability. 
The average Python developer makes over $100,000 - this number is only going to grow in the coming years.
The best part? Python is one of the easiest coding languages to learn right now. It doesn’t matter if you have no programming experience or are unfamiliar with the syntax of Python. 
By the time you finish this course, you'll be an absolute pro at programming!
This course will cover all the basics and several advanced concepts of Python. We’ll go over:
- The fundamentals of Python programming
- Writing and Reading to Files
- Automation of Word and Excel Files
- Web scraping with BeautifulSoup4
- Browser automation with Selenium
- Data Analysis and Visualization with MatPlotLib
- Regex parsing and Task Management
- GUI and Gaming with Tkinter
- And much more!
If you read the above list and are feeling a bit confused, don’t worry! As an instructor and student on Udemy for almost 4 years, I know what it’s like to be overwhelmed with boring and mundane.
 I promise you’ll have a blast learning the ins and outs of python. I’ve successfully taught over 200,000+ students from over 200 countries jumpstart their programming journeys through my courses. ",
 "https://www.youtube.com/watch?v=hEgO047GxaQ ", 20, 
 "Learn A-Z everything about Python, from the basics, to advanced topics like Python GUI, Python Data Analysis, and more!", 
 "Create their own Python Programs, Become an experienced Python Programmer, Parse the Web and Create their own Games", 3.5, 
 "2022-06-29 12:49:47.216000", "Learn Python: The Complete Python Programming Course", 10);

INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(1, "https://i3.ytimg.com/vi/nVOhOGBYHo0/maxresdefault.jpg", 
"You’ve just stumbled upon the most complete, in-depth Java programming course online. With close to 600,000 students enrolled and over one hundred and forty thousand reviews (with tens of thousands of those 5-star) to date, 
these comprehensive java tutorials cover everything you’ll ever need.Whether you want to:
- build the skills you need to get your first Java programming job
- move to a more senior software developer position
- pass the oracle java certification exam
- or just learn java to be able to create your own java apps quickly.
...this complete Java Masterclass is the course you need to do all of this, and more.
N.B. Java 17 support coming soon, read on below...
Are you aiming to get your first Java Programming job but struggling to find out what skills employers want and which course will give you those skills?
This course is designed to give you the Java skills you need to get a job as a Java developer.  By the end of the course, you will understand Java extremely well and be able to build your own Java apps and be productive as a software developer.
Lots of students have been successful in getting their first job or promotion after going through the course.
Here is just one example of a student who lost her job and despite having never coded in her life previously, got a full-time software developer position in just a few months after starting this course.  
She didn't even complete the course! 'Three months ago I lost my job, came to a turning point in my life, and finally made the drastic decision to completely change course.   I decided to switch career paths and go into coding. My husband found and gave me your Complete Java Masterclass at Udemy as a gift,
 and I wholeheartedly dove into it as a lifeline. Following your course has been absolutely enjoyable (still working on it, not yet finished), and has been a great way of keeping on course, dedicated and motivated.  Yesterday, three months after starting the course, and honestly to my surprise, I received (and accepted!) 
 a job offer as a full-time developer. I wanted to just drop you a line to say thank you for doing this work, for being such a dedicated teacher, and for putting all this knowledge available out there in such an approachable way. It has, literally, been life-changing. With gratitude,  Laura'
The course is a whopping 80 hours long.  Perhaps you have looked at the size of the course and are feeling a little overwhelmed at the prospect of finding time to complete it.   Maybe you are wondering if you need to go through it all?
Firstly, Laura's story above shows that you do not have to complete the entire course - she was yet to complete the course when she accepted her developer job offer.
Secondly, the course is designed as a one-stop shop for Java.
The core java material you need to learn java development is covered in the first seven sections (around 14 hours in total).  The Java Basics are covered in those sections. The rest of the course covers intermediate, advanced, and optional material you do not technically need to go through.
For example section 13 is a whopping 10 hours just by itself and is aimed at those students who want to build desktop applications with graphical user interfaces.  JavaFX (which is the technology used in this section) is something that most java developers will rarely or never need to work on.  So you could skip that section entirely.  But if you are one of the few that need to build user interfaces, then the content is there and ready for you.   And there are other sections you can completely avoid if you wish.
If you want to know absolutely everything about Java, then you can go through the entire course if you wish, but it's not necessary to do so if you are just looking to learn the essential information to get a java developer position.
Why would you choose to learn Java?
The reality is that there is a lot of computer languages out there.  It's in the hundreds.  Why would you choose the Java language?
The number one reason is its popularity.  According to many official websites that track the popularity of languages, Java is either #1 or in the top 3.  Popularity means more companies and their staff are using it, so there are more career opportunities available for you if you are skilled in the language.
The last thing you want to do is pick a language that is not in mainstream use.  Java came out in the 1990s and is still very popular today.
What version of Java should you learn?
Generally speaking, you would want to learn the very latest version of a computer programming language, but that's not the case with Java.
Oracle, the owner of Java release many versions of Java.  Some are released and expire in six months, with no future updates or support.  Other versions have long-term support, for many years.
You can probably see why learning a version of Java that has expired makes no sense, and is likely a waste of time.
A company using Java technology (big or small) is not going to use a version of Java that has no updates or support.  They will stick to stable, well-supported versions of Java that get updates.
Right now, in July 21 the version of Java that offers this long-term support (LTS) is Java 11 - It's being fully supported until at least 2025 and likely will be extended from there.
As such, you want to learn the version of Java that your future employer will use, and that's Java 11.
The next LTS version of Java is Java 17, scheduled for release in September 2021.   The course will be updated, and the updates made available to you free once Java 17 is live.  The course will also be updated in the future as new LTS versions are announced by Oracle.
BOTTOM LINE: You will learn the RIGHT VERSION of JAVA in this course!  Right meaning the right version to maximize your future Java potential with clients or Employers. ", "https://www.youtube.com/watch?v=nVOhOGBYHo0",
20, "Learn OOP, SOLID principles with Java examples. Implement backend part for online store by the end of the course",
"Setting up Java and Maven, Maven Fundamentals, and Maven Lifecycles", "3.5", "2019-12-11 14:59:07.216000", "Java Programming OOP Course", "3");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(2, "https://i3.ytimg.com/vi/YYXdXT2l-Gg/maxresdefault.jpg",
"This python for beginners course is geared to students who want to know how python works and also to those totally new to programming.
The python language has very simple syntax(way to write it) to learn and it is one of the most powerful languages to learn since it can used for a variety of things.
Here are some:
- Data analysis
- Game development
- Visualization
- Web development
- Robotics
- and more....
Jobs in this field are really lucrative and knowing this language will give you an edge when finding a job and making a lot more money than other developers; python developers are not as many as in other languages since people think is hard. 
Python is super easy to learn but very powerful since it contains many possibilities.
Python is growing faster and faster everyday and it has surpassed many other languages over the years for a lot of reasons, which you will find out soon enough.",
 "https://www.youtube.com/watch?v=YYXdXT2l-Gg", 20, 
 "How to become a Python 3 Developer and get hired! Build 12+ projects, learn Web Development, Machine Learning + more!", 
 "Core skill to understand any programming language, and phyton language.", 4.8, 
 "2020-04-11 01:00:12.216000", "Python for Beginners: Learn Programming from Scratch", "2");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(3, "https://i3.ytimg.com/vi/CD6MJ9pEn2k/maxresdefault.jpg",
"In this Python Beyond the Basics - Object-Oriented Programming training course, expert author David Blaikie will teach you how to design Python classes, and how to implement object-oriented programming concepts in Python. 
This course is designed for users that already have a basic working knowledge of Python.
You will start by learning about classes, including defining a class, class attributes, and working with class and instance data. From there, David will teach you about inheritance and polymorphism. 
This video tutorial also covers advanced features, such as implementing core syntax, subclassing built-ins, and new style classes. You will also learn about exceptions and object serialization. 
Finally, David will teach you about efficiency and testing, including debugging, logging, and benchmarking.
Once you have completed this computer based training course, you will be fully capable of designing your own Python classes, as well as implementing object-oriented programming concepts in Python.",
 "https://www.youtube.com/watch?v=CD6MJ9pEn2k", 39, 
 "Master the fundamentals of Python while working on various usecases in easy steps ", 
 "Design OOP with python, Apply OOP concepts to handle complexity, Handling errors", 3.9, 
 "2017-10-01 16:07:03.216000", "Python Programming: Object-Oriented Programming Python", "3");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(4, "https://i3.ytimg.com/vi/Z4D3M-NSN58/maxresdefault.jpg",
"Welcome to the Python and Django Web Development Course! In this course we cover everything you need to know to build a website using Python, Django, and many more web technologies!
Whether you want to change career paths, expand your current skill set, start your own entrepreneurial business, become a consultant, or just want to learn, this is the course for you!
We will teach you the latest technologies for building great web applications with Python 3 and Django! But we don't just teach that, we also teach the Front End technologies you need to know, including HTML, CSS, and Javascript. 
This course can be your one stop shop for everything you need! It will serve as a useful reference for many of your questions as you begin your journey in becoming a web developer!
This course is designed so that anyone can learn how to become a web developer. We teach you how to program by using HD Video Lectures, Walkthrough Code Projects, Exercises, Concept Presentation Slides, Downloadable Code Notes, Reading Assignments, and much more! 
Here is just a small sampling of the topics included in this course:
- HTML5
- CSS3
- Javascript
- jQuery
- Bootstrap 3 and 4
- Document Object Model
- Python
- Django Basics
- Django Templates
- Django Forms
- Django Admin Customization
- ORM
- Class Based Views
- REST APIs
- User Authentication
- and much,much more!
You will also get access to our online community of thousands of students, happy to help you out with any questions you may have! 
Any questions, feel free to send me a message here on Udemy and connect with me on LinkedIn, check out my profile for other courses.
We also have a 30-day money back guarantee, so you can try out the course for an entire month, risk-free!
Always keep learning!",
 "https://www.youtube.com/watch?v=Z4D3M-NSN58", 99, 
 "Learn to build websites with HTML , CSS , Bootstrap , Javascript , jQuery , Python 3 , and Django!", 
 "Create a website using Django, Learn HTML, Learn CSS, Understand basic Internet", 4.8, 
 "2018-12-21 15:04:56.216000", "Phyton and Django Web Development Course", "4");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(5, "https://i3.ytimg.com/vi/UmljXZIypDc/maxresdefault.jpg",
"Have you ever wanted to create a Web application but didn't know where to start? Have you previously tried to learn Django but got fed up with incomplete YouTube videos and poorly written tutorials? Or are you looking to move your code from Django 2 to Django 3?
THEN THIS IS THE COURSE FOR YOU!
In my Django course, I will walk you through the Django web framework from beginning to end! I'm a self-taught programmer so I know what it feels like to start from scratch. I care about your learning, but even more importantly... I care about you!
What is Django?
Django is an open-source web framework that is written in Python. It was created about twelve years ago, but new in 2020 we have Django 3 with a whole new set of features and capabilities!
Django is an amazing framework for web developers because it provides the infrastructure required for database-driven websites that have user authentication, content administration, contact forms, file uploads, and more. 
Instead of creating all of these features from scratch, you can use the Django framework and utilize these components that are already built, and focus your time on developing your web app instead.
If you're going to be working with Python, especially for web applications or web design, you'll want to learn the Django framework. It will save you a ton of time!
Contents and Overview
I believe we learn best by doing. So, throughout this course you'll be presented with coding quizzes and challenges in order for you to test what you just learned. This format will allow you to actually learn Django and not just follow along like a robot ;)
We will use Python in this course, so if you have never used Python before, we will start with a python refresher to get you up to speed (no other python experience required).
We will then dive into making three complete websites:

1 - Password Generator: A simple website to create a random password with several options. 
- You will learn how to:
- Install Django
- Create a new project
- Work with Django's URL routing
- Creating Templates
- Submit and handle HTML form data

2 - Personal Portfolio: Create your own portfolio to show to potential employers showing off your resume, previous projects, and a fully functional blog. You will learn how to:
- Add apps to your project
- Work with models and databases (including SQLite)
- Access the admin panel
- Create super users
- Make a responsive website with Bootstrap 4
- Work with static and media files
- Extending Templates
- Formating dates and purals

3 - Todo Woo: A website where a user can sign up for an account, and fully manage a todo list with the ability to create, edit, and delete. You will learn how to:
- Work with the authentication system (sign up, login, logout)
- Create virtual environments
- Establish model relationships
- Require login for certain pages
- Create a CRUD application (Create, Read, Update, Delete)
- Queries and filters
- Handling Errors

I will also walk you through Git, which is an awesome tool for developers that allows you to create multiple versions of your code. I'll explain why this is useful and help you understand why you should use it.
Additionally, I will show you how to take the projects that you made in this course and publish them live on the web through Python Anywhere. Like I said, I will take you from the very beginning to the very end!
Course material is regularly refreshed to include all of the newest updates and information. Additionally, I have made this course downloadable, so you can work through the class offline, making it as convenient as possible for you! 
Most instructors won't allow this, but I want you to be able to enjoy this course in whichever way is best for you :)
Don't waste your time scouring the internet and trying to piece together how to learn Django on your own. Invest in yourself, and allow me to teach you Django while having fun.",
 "https://www.youtube.com/watch?v=UmljXZIypDc", 20, 
 "Learn the entire technology stack to create beautiful and responsive websites with Python and Django!", 
 "Understand Django framework, Build fully functional websites, Understand Django basics.", 4.2, 
 "2021-02-14 00:15:46.216000", "Django and Python Full-Stack Developer", "5");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(6, "https://i3.ytimg.com/vi/TKYsuU86-DQ/maxresdefault.jpg",
"What if you knew exactly how to design and build a website like that, completely from scratch? How amazing would that be?
Well, I'm here to teach you HTML, CSS, and web design, all by building the stunning website that you just saw, step-by-step.
So, after finishing this course, you will know exactly how to build a beautiful, professional, and ready-to-launch website just like Omnifood, by following a 7-step process. And it will even look great on any computer, tablet, and smartphone.
But what if you want to build a completely different website? Well, no problem! I designed the course curriculum with exactly this goal: to enable you to design and build any website that you can think of, not just copy the course project.
So, in order to become a confident and independent developer, capable of building your own websites in the future, you will learn:
The fundamentals of modern and semantic HTML, CSS, and building layouts in a small separate project, which will prepare you for the main course project (www.omnifood.dev). This includes modern flexbox and CSS Grid!
How to design beautiful websites, by learning a web design framework I created just for this course. It consists of easy-to-use guidelines for design aspects like typography, colors, images, spacing, and more (this is like a small standalone course!).
How to use well-established website components and layout patterns in order to come up with professional-looking designs
How to make any website work on any mobile device, no matter the design and layout (responsive design)
How to use the 7 steps of building a professional website in practice: planning, sketching, designing, building, testing, optimizing, and launching
How to find and use free design assets such as images, fonts, and icons
Important developer skills such as reading documentation, fixing code errors on your own, and using professional web development tools
Does this sound like fun? Then join me and 200,000+ other developers and start building websites today!",
 "https://www.youtube.com/watch?v=TKYsuU86-DQ", 79, 
 "Learn modern HTML5, CSS3 and web design by building a stunning website for your portfolio! Includes flexbox and CSS Grid", 
 "Become a modern HTML and CSS developer, Design and build a real world project, A web design framework that easy to use and understand ", 4.5, 
 "2022-01-30 03:22:18.216000", "HTML and CSS for Beginner Course", "6");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(7, "https://i3.ytimg.com/vi/QXeEoD0pB3E/maxresdefault.jpg",
"JavaScript is THE most important programming language you need to learn as a web developer - and with this course, you make sure that you will not miss a single thing you have to know as a JavaScript developer!
This is the most comprehensive and modern course you can find on JavaScript - it's based on all my JavaScript knowledge AND teaching experience. 
It's both a complete guide, starting with the core basics of the language, as well as an extensive reference of the JavaScript language and environment, ensuring that both newcomers as well as experienced JavaScript developers get a lot out of this course!
It's a huge course because it's packed with important knowledge and helpful content. From the core basics, over advanced concepts and JavaScript specialties, all the way up to expert topics like performance optimization and testing - this course has it all. 
My goal was to create your go-to resource for the JavaScript language, which you can not just use for learning it but also as a resource you can come back to and look up important topics.
The course is based on my experience as a long-term JavaScript developer as well as a teacher with more than 1,500,000 students on WebAcademy as well as on my YouTube channel CoderLipi. 
It's packed with examples, demos, projects, assignments, quizzes and of course videos - all with the goal of giving you the best possible way of learning JavaScript.

What's in the course?
This course is obviously packed with content - I therefore strongly recommend that you check out the full course curriculum to get a clear idea of all the topics covered in the course. In general, here's what you'll find in the course:
- Modern JavaScript from the start: The JavaScript syntax changed over time - in this course, you'll learn the latest syntax from the start (you'll also learn about the old one though, so that you can work in ANY JS project)
- ALL the Basics: Variables, constants, functions, how scripts are loaded etc
- Arrays & Objects: We'll explore these very important data structures in great detail
- Control Structures: Understand how to run code conditionally and in loops
- A look behind the Scenes: How JavaScript engines work behind the scenes and what that means for us
- Deep dives into Core Concepts: ALL the special things about JavaScript function, different syntaxes
- Working with the DOM: How to manipulate web pages dynamically via JavaScript (including deep dives and different use-cases)
- Events in JavaScript: Learn how to listen to a broad variety of events (e.g. drag & drop) and execute appropriate code
- Classes & Object-oriented Programming: Learn how to work with classes, prototypes, the 'this' keyword, constructor functions and much more
- Asynchronous and Synchronous Programming: We'll explore callbacks, promises, async/ await and other important tools and language features to execute code correctly
- Http Requests: Learn how to send Http requests via JavaScript
- Tooling, Optimizations & Browser Support: Code splitting, producing small code and ensuring that scripts work in all browsers  - this matters and hence is covered in great detail
- Libraries & Frameworks: Learn about libraries like Axios or frameworks like React.js - why they matter and how to use them
- Node.js: Whilst focusing on the browser-side for the majority of the course (because the syntax is the same), we'll also have a dedicated section on Node.js to learn all about that JS host environment
- Security & Performance Optimizations: Of course security matters, so does performance - no surprise that both is covered in the course!
- Automated Testing: Testing manually is hard work and can be unreliable - in this course you'll also get an introduction into automated testing",
 "https://www.youtube.com/watch?v=hEgO047GxaQ", 49, 
 "The modern JavaScript course for everyone! Master JavaScript with projects, challenges and theory. Many courses in one!", 
 "Learn JavaScript from Scratch, All core JavaScript features and concepts, Object-Oriented Programming", 4.0, 
 "2021-07-26 04:56:29.216000", "Comple Java Script Course : From Zero to Hero !", "7");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(8, "https://i3.ytimg.com/vi/gq4S-ovWVlM/maxresdefault.jpg",
"In this course, you will learn the features of Spring, Spring Boot and Spring Modules - JDBC, AOP, Data JPA with hands-on step by step approach.
You will get introduced to Spring Boot, Unit Testing with JUnit and Mockito, talking to the database with Spring JDBC and JPA, Maven (dependencies management), Eclipse (IDE) and Tomcat Embedded Web Server. 
We will help you set up each one of these. You will learn about Spring step by step - in more than 100 steps. This course would be a perfect first step as an introduction to Spring.
You will learn about
- Basics of Spring Framework - Dependency Injection, IOC Container, Application Context and Bean Factory.
- Spring Annotations - @Autowired, @Component, @Service, @Repository, @Configuration, @Primary....
- Spring MVC in depth - DispatcherServlet , Model, Controllers and ViewResolver
- Spring Boot Starters - Spring Boot Starter Web, Starter Data Jpa, Starter Test
- Basics of Spring Boot, Spring AOP, Spring JDBC and JPA
- Basics of Eclipse, Maven, JUnit and Mockito
- Basic concept of a Web application step by step using JSP Servlets and Spring MVC
- Unit testing with JUnit and Mockito using XML and Java Spring Application Contexts",
 "https://www.youtube.com/watch?v=gq4S-ovWVlM", 119, 
 "Learn the magic of Java Spring Framework with Spring Boot, Spring JDBC, and Spring AOP!", 
 "Learn spring framework the modern way, Become a complete Spring Developer, Learn basic Spring Boot, Spring AOP, Spring JDBC, and JPA", 3.9, 
 "2017-05-15 12:30:17.216000", "Spring Framework Class", "8");
 
 INSERT INTO course (course_id, cover_image_url, `description`, preview_video_url, price, summary, what_you_learn, course_rating, created_at, title, teacher_id) 
VALUES(9, "https://i3.ytimg.com/vi/QFaFIcGhPoM/maxresdefault.jpg",
"Congratulations!  You've found the most popular, most complete, and most up-to-date resource online for learning React!
Thousands of other engineers have learned React, and you can too.  This course uses a time-tested, battle-proven method to make sure you understand exactly how React work, and will get you a new job working as a software engineer or help you build that app you've always been dreaming about.
The difference between this course and all the others: you will understand the design patterns used by top companies to build massively popular web apps.
React is the most popular Javascript library of the last five years, and the job market is still hotter than ever.  Companies large and small can't hire engineers who understand React fast enough, and salaries for engineers are at an all time high.  It's a great time to learn React!

----------------------

What will you build?
This course features hundreds of videos with dozens of custom diagrams to help you understand how React work.  No prior experience with either is necessary. 
Through tireless, patient explanations and many interesting practical examples, you'll learn the fundamentals of building dynamic and live web apps using React.
Each topic included in this course is added incrementally, to make sure that you have a solid foundation of knowledge.  You'll find plenty of discussion added in to help you understand exactly when and where to use each feature of React.
My guarantee to you: there is no other course online that teaches more features of React.  This is the most comprehensive resource there is.

Below is a partial list of the topics you'll find in this course:
Master the fundamental features of React, including JSX, state, and props
From square one, understand how to build reusable components
Dive into the source code of React to understand how it works behind the scenes
Test your knowledge and hone your skills with numerous coding exercises
Integrate React with advanced browser features, even geolocation API's!
Use popular styling libraries to build beautiful apps
Master different techniques of deployment so you can show off the apps you build!
See different methods of building UI's through composition of components

Besides just React, you'll pick up countless other tidbits of knowledge, including ES2015 syntax, popular design patterns, even the clearest explanation of the keyword 'this' in Javascript that you'll ever hear.
This is the course I wanted to take when I first learned React: complete, up-to-date, and clear.",
 "https://www.youtube.com/watch?v=QFaFIcGhPoM", 99, 
 "Updated! Become a Senior React Developer. Build a massive E-commerce app!", 
 "Create dynamic web apps using React, Master the fundamental behind React, Programming skill needed for a software engineering job", 4.7, 
 "2018-08-27 11:16:08.216000", "Modern React Course", "9");
UPDATE course_sequence SET next_val = 11;
 
-- nama category kalau perlu inspirasi liat website udemy, trus ke categories
-- ambil nama bagian kedua, yang ada web development, data science, mobile development, dst
INSERT INTO category (category_id, category_name) VALUES (1, "Data Science");
INSERT INTO category (category_id, category_name) VALUES (2, "Programming Language");
INSERT INTO category (category_id, category_name) VALUES (3, "Web Development");
UPDATE category_sequence SET next_val = 4;

-- satu category terdiri atas beberapa topic
-- topics juga liat dari udemy, contohnya kategori game development, topicnya ada unity, c#, dll
INSERT INTO category_topics (category_category_id, topics) VALUES (1, "Python");
INSERT INTO category_topics (category_category_id, topics) VALUES (1, "Django");
INSERT INTO category_topics (category_category_id, topics) VALUES (2, "Python");
INSERT INTO category_topics (category_category_id, topics) VALUES (2, "Java");
INSERT INTO category_topics (category_category_id, topics) VALUES (2, "HTML5");
INSERT INTO category_topics (category_category_id, topics) VALUES (2, "CSS");
INSERT INTO category_topics (category_category_id, topics) VALUES (2, "JavaScript");
INSERT INTO category_topics (category_category_id, topics) VALUES (3, "Spring");
INSERT INTO category_topics (category_category_id, topics) VALUES (3, "React");
INSERT INTO category_topics (category_category_id, topics) VALUES (3, "HTML5");
INSERT INTO category_topics (category_category_id, topics) VALUES (3, "CSS");
INSERT INTO category_topics (category_category_id, topics) VALUES (3, "JavaScript");

-- buat cocokin course mana, categorynya apa
-- rata" satu course, satu category sih, tapi bisa jadi 1 course ada lebih dari 1 category
INSERT INTO course_category_mapping(course_id, category_id) VALUES (10, 1);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (10, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (1, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (2, 1);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (2, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (3, 1);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (3, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (4, 1);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (4, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (4, 3);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (5, 1);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (5, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (5, 3);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (6, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (6, 3);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (7, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (7, 3);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (8, 2);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (8, 3);
INSERT INTO course_category_mapping(course_id, category_id) VALUES (9, 3);

-- buat cocokin student mana masuk course mana, agak logika aja deh,
-- mungkin ad course yg ga ad student, beberapa ada student,
INSERT INTO student_course_mapping(course_id, student_id) VALUES (1, 3);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (1, 6);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (1, 10);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (2, 1);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (2, 3);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (3, 4);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (3, 5);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (4, 7);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (5, 3);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (5, 4);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (5, 6);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (6, 9);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (7, 5);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (7, 10);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (8, 3);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (8, 4);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (8, 9);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (9, 7);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (10, 1);
INSERT INTO student_course_mapping(course_id, student_id) VALUES (10, 8);

INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (1,0,2,0,5,1);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (2,0,10,0,5,1);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (3,0,1,0,5,3);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (4,0,2,0,5,3);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (5,0,5,0,5,3);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (6,0,8,0,5,3);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (7,0,3,0,5,4);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (8,0,5,0,5,4);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (9,0,8,0,5,4);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (10,0,3,0,5,5);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (11,0,7,0,5,5);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (12,0,1,0,5,6);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (13,0,5,0,5,6);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (14,0,4,0,5,7);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (15,0,9,0,5,7);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (16,0,10,0,5,8);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (17,0,6,0,5,9);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (18,0,8,0,5,9);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (19,0,1,0,5,10);
INSERT INTO student_progress (student_progress_id, completed_lectures, course_id, liked, total_lectures, student_id) VALUES (20,0,7,0,5,10);
UPDATE progress_sequence SET next_val = 21;

-- Buat 5 course lecture untuk masing" course. Jadi total ada 50
-- Course lecture itu kyk video ttg satu topik coursenya
-- misalnya Coursenya Java, lecture pertama, introduction, kedua, data types, dst..
-- is completed selalu false, duration sesuai video dan formatnya HH:MM:SS, urlnya harus video youtube asli dan masuk akal
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(1, "Java Programming: Introduction to Java Programming
Topics discussed:
1. About Java.
2. Java Language Specification.
3. API.
4. Editions of Java.
5. IDE.", "00:06:03", "https://www.youtube.com/watch?v=mG4NLNZ37y4", "Introduction to Java Programming", 1);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(2, "Java Programming: The Anatomy of Java Program
Topics discussed:
1. Classes & Objects.
2. Methods.
3. Naming Conventions.
4. Java Program Structure.
5. Packages.", "00:12:39", "https://www.youtube.com/watch?v=vsxYucdzimA", "Anatomy of Java Program", 1);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(3, "Java Programming: Displaying Messages in Java
Topics discussed:
1. Strings in Java.
2. println() & print() methods in Java.
3. System Class in Java.", "00:08:37", "https://www.youtube.com/watch?v=ifirpBZLeCk", "Displaying Messages in Java", 1);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(4, "Java Programming: Displaying Numbers in Java
Topics discussed:
1. Numbers in Java.
2. Some Arithmetic Operators.
3. Printing some values.", "00:02:50", "https://www.youtube.com/watch?v=UFMqdnUh4nI", "Displaying Numbers in Java", 1);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(5, "Java Programming: Creating, Compiling, and Executing a Java Program
Topics discussed:
1. Creating a Java program using a simple text editor.
2. Compiling the Java program using the Command Window.
3. Running the Java program using the Command Window.
4. What happens exactly when we compile and run our Java program.", "00:10:24", "https://www.youtube.com/watch?v=6rHySk9Kcuo", "Creating, Compiling, & Executing a Java Program", 1);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(6, "In this Python Beginner Tutorial, we will begin learning about the string data type. 
Strings allow us to work with textual data in Python.
 We will be going over different ways to format strings, 
 and also a lot of useful string methods. Let's get started.", "00:21:11", "https://www.youtube.com/watch?v=k9TUPpGqYTo", "Strings-Working with Textual Data", 2);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(7, "In this Python Beginner Tutorial, we will begin learning about integers and floats. 
Integers and Floats allow us to work with numeric data in Python. 
We will be learning how to perform basic arithmetic, as well as how to compare numeric values. 
Let's get started.", "00:11:54", "https://www.youtube.com/watch?v=khKv-8q7YmY", "Integers and Floats-Working with Numeric Data", 2);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(8, "In this Python Beginner Tutorial, we will begin learning about Lists, Tuples, and Sets in Python. 
Lists and Tuples allow us to work with sequential data, and Sets allow us to work with unordered unique values. 
We will go over most of the methods, learn when to use which data type, and also the performance benefits of each type as well. Let's get started.", "00:29:04", "https://www.youtube.com/watch?v=W8KRzm-HUcc", "Lists, Tuples, and Sets", 2);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(9, "In this Python Beginner Tutorial, we will begin learning about dictionaries. Dictionaries allow us to work with key-value pairs in Python.
 We will go over dictionary methods, how to add and remove values, and also how to loop through the key-value pairs. Let's get started.", "00:09:58", "https://www.youtube.com/watch?v=daefaLgNkw0", "Dictionaries-Working with Key-Value Pairs", 2);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(10, "In this Python Beginner Tutorial, we will begin learning about if, elif, and else conditionals in Python. 
We will also be learning about Booleans and what evaluates to True and False. Let's get started.", "00:09:24", "https://www.youtube.com/watch?v=DZwmZ8Usvnk", "Conditionals and Booleans - If, Else, and Elif Statements", 2);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(11, "This is the lesson number 0 of the lesson series on Object Oriented Programming (OOP) in Python. It will be a complete course with the aim is to cover almost everything needed in Object Oriented Programming.
In this lesson we will create our fist class. We will study about the constructor in a class and will see the use of special method __init__. 
We will have little discussion on the type of methods or functions inside a class. Those are instance methods, class methods and static methods. We will start with creating instance method.", "00:11:30", "https://www.youtube.com/watch?v=ffLWzihP7p0", "Creating Our First Class | [OOP in Python]", 3);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(12, "This is the lesson number 03 of the lesson series on Object Oriented Programming (OOP) in Python. It will be a complete course with the aim is to cover almost everything needed in Object Oriented Programming.
In this lesson we will talk about the class level attributes. We will see how different objects or instances can access class level attributes.", "00:04:53", "https://www.youtube.com/watch?v=BY79_hqVDEM", "Class Level Attributes | [OOP in Python]", 3);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(13, "This is the lesson number 04 of the lesson series on Object Oriented Programming (OOP) in Python. It will be a complete course with the aim is to cover almost everything needed in Object Oriented Programming.
In this lesson we will study about a special attribute names as __dict__ which is associated with each object we create from a class and with the class as well. It contains the information of different attributes of that object or class. 
It is a Dictionary with keys as the names of the different attributes and dictionary values as values of those attributes. This attribute can be very helpful for debugging purposes. We will also see other help statements for class and object.", "00:10:53", "https://www.youtube.com/watch?v=Kg49m8OPRew", "Attribute __dict__ | [OOP in Python]", 3);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(14, "This is the lesson number 05 of the lesson series on Object Oriented Programming (OOP) in Python. It will be a complete course with the aim is to cover almost everything needed in Object Oriented Programming.
In this lesson we will have two tasks followed by their solution. The aim is that you use the skills learnt so far to solve these tasks.", "00:12:53", "https://www.youtube.com/watch?v=Gp39OACDOUs", "Task 1 & 2 | [OOP in Python]", 3);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(15, "This is the lesson number 06 of the lesson series on Object Oriented Programming (OOP) in Python. It will be a complete course with the aim is to cover almost everything needed in Object Oriented Programming.
In this lesson we will see the use of two special methods; __str__ and __repr__ to represent the object of the class.", "00:06:20", "https://www.youtube.com/watch?v=ePLiBhz7A38", "__str__ and __repr__ | [OOP in Python]", 3);




INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(16, "This django database tutorial will show you how to create and use a SQLite3 database. We will create relationships between tables and learn how to add and remove items from the sqlite database", 
"00:22:48", "https://www.youtube.com/watch?v=UxTwFMZ4r5k", "SQLite3 DataBase Tutorial", 4);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(17, "This django tutorial will cover the django admin dashboard. The admin page/dashbaord is a place where you can view valuable information about your site, specifically your database tables and models.", 
"00:09:18", "https://www.youtube.com/watch?v=dTXyCGVmjL8", "Admin Dashboard", 4);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(18, "This django template tutorial will talk about how to create scalable dynamic html to display on your web pages. I will discuss template inheritance, blocks and code embedded in your templates.", 
"00:27:51", "https://www.youtube.com/watch?v=b0CgA_Ap_Mc", "Templates & Custom HTML", 4);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(19, "This python django tutorial covers how to create simple forms that can be used to update a database. It will also discuss the different kinds of form actions like POST and GET and when you should be using each.", 
"00:21:55", "https://www.youtube.com/watch?v=vM9mcWr1RMg", "Simple Forms", 4);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(20, "This is a django forms tutorial that discusses how to create complex dynamic forms. In this tutorial we step away from djangos prebuilt form layout and create our own. We discuss the difference between POST and GET and how to get information from out HTML in our python code.", 
"00:14:32", "https://www.youtube.com/watch?v=9jDEnSm4nt8", "Custom Forms", 4);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(21, "In this Python Django Tutorial, we will be creating a blog application within our Django project. We will also learn how to create URL patterns that are handled by our application views. Let's get started...", 
"00:20:26", "https://www.youtube.com/watch?v=a48xeeo5Vnk", "Full-Featured Web App Part 2 - Applications and Routes", 5);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(22, "In this Python Django Tutorial, we will be learning how to use templates to return more complex HTML to the browser. We'll also see how we can pass variables to our templates as context. Let's get started...", 
"00:45:44", "https://www.youtube.com/watch?v=qDwdMDQ8oX4", "Full-Featured Web App Part 3 - Templates", 5);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(23, "In this Python Django Tutorial, we will be learning how to access the Django Admin Page for our application. The Administration Page is a great way to see what data is currently in our application, and also gives us a nice GUI for creating or modifying that data. Let's get started...", 
"00:08:59", "https://www.youtube.com/watch?v=1PkNiYlkkjo", "Full-Featured Web App Part 4 - Admin Page", 5);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(24, "In this Python Django Tutorial, we will be creating database tables for our application using Django models. We will also see how we can use the Django ORM to query the database and filter through results. Let's get started...", 
"00:38:46", "https://www.youtube.com/watch?v=aHC3uTkT9r8", "Full-Featured Web App Part 5 - Database and Migrations", 5);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(25, "In this Python Django Tutorial, we will be learning how to use forms and validate user input by creating a user registration page. We will also learn how to install and use Crispy Form so that our forms match the modern style of our application. Let's get started...", 
"00:45:55", "https://www.youtube.com/watch?v=q4jPR-M0TAQ", "Full-Featured Web App Part 6 - User Registration", 5);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(26, "HTML tutorial for beginners! This is the first HTML tutorial in this series on learning HTML and CSS. Learn how to create a website using HTML and CSS, which are programming languages used to markup websites.", 
"00:08:43", "https://www.youtube.com/watch?v=pm5OVxpul48", "How to Get Started With HTML & CSS", 6);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(27, "Let's create our first HTML project and document - Learn HTML and CSS. In this HTML tutorial, we will be getting started with HTML, and create an HTML document which will end up becoming our front page. 
The front page will be set up using HTML5, and will be the file we use in this course for most of our lessons.", 
"00:10:59", "https://www.youtube.com/watch?v=bupWPZdXqIA", "Let's Create Our First HTML Project and Document", 6);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(28, "Learn about HTML elements and attributes - HTML and CSS tutorial. In this HTML tutorial you will learn about HTML elements and attributes, which are the HTML tags we used in the previous episode. 
There are many HTML elements available which we will cover later in this HTML course, as we start building our first website.", 
"00:05:38", "https://www.youtube.com/watch?v=XXrpsQqAlIQ", "Learn About HTML Elements and Attributes", 6);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(29, "Learn to create titles and text using HTML - HTML and CSS tutorial. In this lesson you will learn how to create titles and text using HTML. To do this we will learn about the HTML paragraph element, and the HTML header elements.", 
"00:07:11", "https://www.youtube.com/watch?v=8bZ4RPjOPYE&t=8s", "Learn to Create Titles and Text Using HTML", 6);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(30, "We use boxes in websites | Learn HTML and CSS | HTML tutorial. In this HTML tutorial you will learn about the grouping of content inside websites. In HTML when we make layouts, we use boxes to help place the page content.", 
"00:07:03", "https://www.youtube.com/watch?v=1YO_5jXC-bo", "We Use Boxes in Websites", 6);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(31, "See how to install Node and Visual Studio Code, and learn why you need each. Watch as Bob writes a first tiny line of code to make sure that the installation is ready.", 
"00:12:18", "https://www.youtube.com/watch?v=sEGC-adSKXo&t=1s", "Development Environment Setting", 7);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(32, "See bob using some important basic JavaScript syntax for building a simple website. This is the basic for HTTP request, HTTP response and also applications that could also access file system", 
"00:13:19", "https://www.youtube.com/watch?v=KXxXr0RxGDE", "Basic JavaScript Syntax", 7);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(33, "Learn what variables are and how to declare, initialize, set, and get values from them.
javascript variables - javascript variables & data types | javascript tutorial for beginners.", 
"00:14:37", "https://www.youtube.com/watch?v=plOo5hNVQJU", "JavaScript Variables", 7);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(34, "JavaScript data types - JavaScript  data types tutorial.
In this chapter, you will learn about JavaScript  data types with examples
Understanding JavaScript Data Types and Variables For a list of JavaScript data types check the MDN site here", 
"00:05:44", "https://www.youtube.com/watch?v=yjE_xXL26qA", "JavaScript Data Types", 7);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(35, "Sometimes you need to explicitly convert the data type of a value into a different data type. Sometimes JavaScript will do this automatically for you. Bob explains how and why this happens.
javascript type conversion - javascript type conversion - hindi. How Does JavaScript Type Coercion Work", 
"00:08:55", "https://www.youtube.com/watch?v=jfQyMPzPTjY", "JavaScript Type Conversion", 7);



INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(36, "In this video we will see how to make a new React project and how to make a basic 'Hello World'  folder", 
"00:04:53", "https://www.youtube.com/watch?v=9hb_0TZ_MVI", "Hello World", 9);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(37, "In this video we will se what kind of files that are usually used to make a new project, the structure of the folders, and what is inside each file", 
"00:05:34", "https://www.youtube.com/watch?v=9VIiLJL0H4Y&t=5s", "Folder Structure", 9);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(38, "In this video we will see what is the Components of a good react UI, and a simple explanation of each components", 
"00:04:58", "https://www.youtube.com/watch?v=Y2hgEGPzTZY", "Components", 9);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(39, "In this video we will see Functional Components, which is a JavaScript function that accepts an input of properties and return HTML that describes the UI", 
"00:06:32", "https://www.youtube.com/watch?v=Cla1WwguArA", "Functional Components", 9);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(40, "In this video we will talk about Class Components, which is similiar to Functional Components but a Class Components can maintain a private internal state", 
"00:06:21", "youtube.com/watch?v=lnV34uLEzis", "Class Components", 9);


INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(41, "In this tutorial, we'll understand the concept of Dependency Injection.", 
"00:14:51", "https://www.youtube.com/watch?v=GB8k2-Egfv0", "Understanding Dependency Injection", 8);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(42, "In this tutorial, we'll learn how to set up our Eclipse development environment to write Spring code.", 
"00:03:47", "https://www.youtube.com/watch?v=Z5gubdHLJIc", "Setting Up", 8);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(43, "In this tutorial, we'll discuss the role of Spring as a bean container. We'll also have a quick discussion on the Factory pattern, and I'll introduce you to the Spring Bean Factory object.", 
"00:06:52", "https://www.youtube.com/watch?v=xlWwMSu5I70", "Understanding Spring Bean Factory", 8);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(44, "In this tutorial, we'll write code to implement the BeanFactory concept that we learnt in our previous tutorial. We'll write a Spring XML to configure a Spring bean. Then we'll use the BeanFactory to instantiate our bean in the Spring container.",
"00:11:21", "https://www.youtube.com/watch?v=7c6ZTF6cF88", "Writing Code Using the Bean Factory", 8);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(45, "We'll first replace the BeanFactory with the more powerful ApplicationContext. We'll then make Spring initialize a property of an object by specifying the value in the configuration XML.", 
"00:07:36", "https://www.youtube.com/watch?v=ZxLaEovze3M", "ApplicationContext and Property Initialization", 8);

INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(46, "In this video we will see :
- What is python
- Why to learn it
- Why it is so useful", "00:04:13", "https://www.youtube.com/watch?v=hEgO047GxaQ", "Introduction to Python", 10);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(47, "In this video we will see :
- Download and install Python interpreter
- Download and install PyCharm IDE
- Simple code in command prompt
- Create project in PyCharm", "00:08:32", "https://www.youtube.com/watch?v=mbryl4MZJms", "Python Installation | PyCharm", 10);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(48, "In this video we will see :
- Why do we code
- Arithmetic operations
- Printing raw string", "00:14:48", "https://www.youtube.com/watch?v=DWgzHbglNIo&t=5s", "Getting Started with Python", 10);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(49, "In this video we will see :
- What is variable
- Why do we need them
- How to assign value to variable
- Fetching value 
- String value to variable
- Finding length of string", "00:10:21", "https://www.youtube.com/watch?v=TqPzwenhMj0", "Variables in Python", 10);
INSERT INTO course_lecture(course_lecture_id, course_lecture_description, lecture_duration, lecture_url, title, course_id)
VALUES(50, "
In this video we will see :
- Working with List
- What is list
- How to use list
- append, insert, remove, pop, delete, function
- Inbuilt functions of List : min, max, sum
- sort function", "00:10:41", "https://www.youtube.com/watch?v=6rHySk9Kcuo", "List in Python", 10);
UPDATE course_lecture_sequence SET next_val = 51;