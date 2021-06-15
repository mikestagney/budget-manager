# Budget Manager
Command line app to categorize, sort and save purchases.

## Things learned

Nesting collections - one linked array list to hold four linked hash maps.

Using streams to sort, sum and print the contents of hashmaps.

### Details

User options:

* Add income 
* Add purchase - enter name and price and select one of four categories to place it in
* Show list of purchases - list all or any from four categories
* Balance - total purchases subtracted from total income
* Save all to file
* Load from file
* Sort - three ways to sort: by all purchases, by category and by specific category 
* Exit the app

The directory contains two files: 

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
\>Red Fuji Apple\
Enter its price:\
\> 5.99\
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
\>6

Purchases were loaded!
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

All:\
Almond 250g $35.43\
Skate rental $30.00\
FIJI Natural Artesian Water $25.98\
Wrangler Men's Stretch Cargo Pant $19.97\
Sensodyne Pronamel Toothpaste $19.74\
Men's Dual Defense Crew Socks 12 Pairs $13.00\
LEGO DUPLO Town Farm Animals $10.10\
Chick-fil-A $10 Gift Card $10.00\
Cinema $8.73\
Gildan LT $8.61\
Hershey's milk chocolate bars $8.54\
Keystone Ground Beef $6.28\
Red Fuji Apple $5.99\
Eggs $3.99\
Milk $3.50\
Debt $3.50\
Great Value Broccoli Florets $1.00\
Total: $214.36
```
How do you want to sort?
1) Sort all purchases
2) Sort by type
3) Sort certain type
4) Back
```
\>2

Types:\
Food - $90.71\
Entertainment - $48.83\
Clothes - $41.58\
Other - $33.24\
Total sum: $214.36
```
How do you want to sort?
1) Sort all purchases
2) Sort by type
3) Sort certain type
4) Back
```
\>3
```
Choose the type of purchase
1) Food
2) Clothes
3) Entertainment
4) Other
5) Back
```
\>1

Food:\
Almond 250g $35.43\
FIJI Natural Artesian Water $25.98\
Hershey's milk chocolate bars $8.54\
Keystone Ground Bee $6.28\
Red Fuji Apple $5.99\
Eggs $3.99\
Milk $3.50\
Great Value Broccoli Florets $1.00\
Total sum: $90.71
