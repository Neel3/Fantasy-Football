# README

I used to manually enter the fantasy football league data into an excel file every week. After taking the introduction to programming class, learning the fundamentals of java, and a lot of research on my own time, I wrote this program to automate the process. All you have to do is copy and paste the page source of the fantasy football league site into notepad, save it as an HTML file, and this program will:

1) Import the html file
2) Filter the data
3) Sort the data
4) Output the data into the excel file (it outputs the data into a total sheet containing data from every week, and it also creates a new sheet in the workbook to output the data just for that week)

Pictures are shown below. I set up the excel sheet to automatically calculate the rest of the stats. The data is then imported into Tableau, where I use it for data analysis. This league is private, so I cannot directly access the site using JSoup. My next goal is to learn how to create a program with log in credentials in order to directly get the data from the site.


![Part of the HTML Source Code:](https://imgur.com/oMz192O.png "Part of the HTML Source Code:")


![Excel workbook before the program is run](https://imgur.com/ZTsFMQq.png "Excel workbook before the program is run")


![Excel workbook after the program is run](https://imgur.com/eG11fxy.png "Excel workbook after the program is run")


![New tab created for the weekly data](https://imgur.com/uKcO6ct.png "New tab created for the weekly data")
