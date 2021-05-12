# Budget Manager
Command line app to categorize, sort and save purchases.

## Things learned

Nesting collections - one linked arraylist to keep four linked hashmaps.

Using streams to sort, sum and print the contents of hashmaps.

### Details

User options:

* Add income 
* Add purchase - name and price and 4 categories to place them
* Show list of purchases - list all or from any of 4 categories
* Balance - total purchases subtracted from income
* Save to file
* Load from file
* Sort - 3 ways to sort: by all purchases, by types and by certain type 
* Exit the app

The directory contains 2 files: 

* Main.java - sets up and runs the command line menu
* Manager.java - class that holds all purchasing data and methods

Eleventh project created for JetBrains Academy Java Developer course - hard level project.

### Sample input and output:

```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
7) Analyze (Sort)
0) Exit
```
\>7
```
How do you want to sort?
1) Sort all purchases
2) Sort by type
3) Sort certain type
4) Back
```
\>1

The purchase list is empty!
```
How do you want to sort?
1) Sort all purchases
2) Sort by type
3) Sort certain type
4) Back
```
\>2

Types:\
Food - $0\
Entertainment - $0\
Clothes - $0\
Other - $0\
Total sum: $0

```
How do you want to sort?
1) Sort all purchases
2) Sort by type
3) Sort certain type
4) Back
```
\>4
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
7) Analyze (Sort)
0) Exit
```
\>2
```
Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
```
\>1

Enter purchase name:\
>Red Fuji Apple\
Enter its price:\
> 5.99\
Purchase was added!
```
Choose your action:
1) Add income
2) Add purchase
3) Show list of purchases
4) Balance
5) Save
6) Load
7) Analyze (Sort)
0) Exit
```

