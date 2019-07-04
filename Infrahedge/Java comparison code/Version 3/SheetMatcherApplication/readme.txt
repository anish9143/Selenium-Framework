Steps to run the Sheet Matcher Program-
1. Open SheetMatcher.cmd in Edit mode.
2. Change the path of bin in SheetMatcher.cmd as per your system.
	e.g. cd D:\Murex\Application and src folder\Version 3\SheetMatcherApplication\bin
The above path should point to the bin directory present in the same folder as SheetMatcher.cmd.
3. Open mappingsheet.properties and provide the path of DB file and UI file name as dbFileName and uiFileName respectively.
4. In the same sheet output file name has to be defined in outFileName.
5. Number of keys per sheet needs to be mentioned in the properties file.
	i.e. the entries should be - <Sheet_Name>.noOfKeys=<KeyCount> (VolatilityIP1Model.noOfKeys=3)
6. Run SheetMatcher.cmd.
7. Output file should get generated inside bin folder
