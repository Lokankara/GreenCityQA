# Searching Web Elements by XPath 
[Link](https://github.com/it-acad/taqc-sprint-searching-by-xpath-Lokankara)

## Task 1
1. Open the LoginModalTest class.
2. Analyze the changes compared to the previous implementation.
3. Change all necessary CSS selectors to XPaths, add the implementations of the missing tests. 
4. Verify the correctness of the execution.
5. Implement the specified negative login scenarios on the page.

## Task 2
Prerequisite for completing this task: being logged in.
In this task you need to do the following:

Find the "Гуртки" tab using
Navigate to the 2nd page
Find and open the card "IT освіта: курси 'ГРАНД'"
Find and click the "Залишити коментар" button
Write a comment, rate it, and click the "Надіслати" button
Implement different possible negative scenarios.
For locating all elements, use XPath.

## Task 3
Prerequisite for completing this task: being logged in.
"Navigate to the 'Особистий кабінет' settings
Find 'Редагувати профіль'
Change personal information and password
Write positive and negative tests
Use XPath for locating elements"

## Additional task (optional)
1. Parameterized Test Code where its possible.

| Last Name | First Name | Phone      | Password            | Confirm Password    | Expected XPaths (Name) | Error Messages(Name)  | Expected XPaths (pwd) | Error Messages (pwd) |
|-----------|------------|------------|---------------------|---------------------|------------------------|-----------------------|-----------------------|----------------------|
| ""        | ""         | ""         | ""                  | ""                  | [ 0, 1, 2, 3 ]         | [ 0, 5, 10, 15, 20 ]  | [ 0, 1, 2, 3 ]        | [ 0, 1, 3, 4 ]       |
| " "       | " "        | ""         | ""                  | ""                  | [ 0, 1 ]               | [ 1, 6 ]              | [ 0, 1 ]              | [ 0, 1 ]             |
| "!"       | "!"        | " "        | ""                  | ""                  | [ 0, 1 ]               | [ 2, 7 ]              | [ 0, 1 ]              | [ 0, 1 ]             |
| "1"       | "1"        | " "        | ""                  | ""                  | [ 0, 1 ]               | [ 3, 8 ]              | [ 0, 1 ]              | [ 0, 1 ]             |
| "a"*26    | "a"*26     | " "        | ""                  | ""                  | [ 0, 1 ]               | [ 4, 9 ]              | [ 0, 1 ]              | [ 0, 1 ]             |
| ""        | ""         | " "        | ""                  | ""                  | [ 2 ]                  | [ 10 ]                | [ 2 ]                 | [ 2 ]                |
| " "       | " "        | " "        | ""                  | ""                  | [ 2 ]                  | [ 11 ]                | [ 2 ]                 | [ 2 ]                |
| "a"       | "a"        | " "        | ""                  | ""                  | [ 2 ]                  | [ 14 ]                | [ 2 ]                 | [ 2 ]                |
| "1"       | "1"        | " "        | ""                  | ""                  | [ 2 ]                  | [ 12 ]                | [ 2 ]                 | [ 2 ]                |
| "a"       | "a"        | " "        | "a"                 | "a"                 | [ 2, 4 ]               | [ 12, 16 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "1"       | "1"        | " "        | "1"                 | "1"                 | [ 2, 4 ]               | [ 12, 13 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "!"       | "!"        | " "        | "!"                 | "!"                 | [ 2, 4 ]               | [ 12, 13 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "a"       | "a"        | " "        | "a"                 | "b"                 | [ 2, 4 ]               | [ 12, 17 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "12345678"| "12345678" | " "        | "12345678"          | "12345678"          | [ 2, 4 ]               | [ 12, 13 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "a"       | "a"        | " "        | "a"*26              | "a"*26              | [ 2, 4 ]               | [ 12, 18 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "12345678"| "12345678" | " "        | "12345678"          | "12345678"          | [ 2, 4 ]               | [ 12, 13 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
| "a"       | "a"        | " "        | "a"                 | "a"                 | [ 2, 4 ]               | [ 12, 16 ]            | [ 2, 3 ]              | [ 2, 3 ]             |
