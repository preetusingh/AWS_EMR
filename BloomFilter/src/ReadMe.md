#Implementation of Bloom Filter using stackoverflow.com data in AWS Environment

Bloom filters are super efficient data structures that allow us to tell if an object is "probably in set" or "Definitely not in set". Bloom filter is a probabilistic data structure used to test whether a member is an element of a set. Bloom filters have a strong space advantage over other data structures such as a Java Set, in that each element uses the same amount of space, no matter its actual size.
 
##Bloom filter implementation consist of two phases :

##Trainging Phase : 
Hashing an object M times using either multiple hash functions or the same hash function with a different seed.
For each time an object is hashed the corresponding hash value in the N bit array is then marked as 1.

###Input
3 members of the set

11, 12, 14
    
One hash functions

(x+3) mod 4

An array of 4 elements

array[0]=0
array[1]=0
array[2]=0
array[3]=0
    
###Calculation

(11+3) mod 4 = 2 ==> means array[2] should be set to 1
(12+3) mod 4 = 3 ==> means array[3] should be set to 1
(14+3) mod 4 = 1 ==> means array[1] should be set to 1
    
###Output

array[0]=0
array[1]=1
array[2]=1
array[3]=1
    
##Lookup Phase

###Input
The output from the Training Phase

array[0]=0
array[1]=1
array[2]=1
array[3]=1
    
One hash functions

(x+3) mod 4
   
The numbers to be looked up

11, 12, 14, 16, 8, 9
    
###Calculation

(11+3) mod 4 = 2 ==> means 11 belongs to array[2] ==> 1
(12+3) mod 4 = 3 ==> means 12 belongs to array[3] ==> 1
(14+3) mod 4 = 1 ==> means 14 belongs to array[1] ==> 1
(16+3) mod 4 = 3 ==> means 16 belongs to array[3] ==> 1
 (8+3) mod 4 = 3 ==> means  8 belongs to array[3] ==> 1
 (9+3) mod 4 = 0 ==> means  9 belongs to array[0] ==> 0
    
###Output

11 ==> Probably in the set because array[2] is 1 ==> True Positive
12 ==> Probably in the set because array[3] is 1 ==> True Positive
14 ==> Probably in the set because array[1] is 1 ==> True Positive
16 ==> It is not in the input but the value of array[3] is 1 ==> False Positive
 8 ==> It is not in the input but the value of array[3] is 1 ==> False Positive
 9 ==> It is not in the set because array[0] is 0 ==> True negative
    


##Prerequisites
a. Download the below mentioned jars and configure into project build path
hadoop-common-2.7.0.jar
hadoop-core-0.20.2.jar
org.apache.commons.cli-1.2.0.jar
JRE System Library[JavaSE-1.7] or above

b. Download substantial amount of data from stackoverflow.com


##Project creation and execution

###Create the JAR file
Copy Training.java, LookUp.java and MRDPUtil.java in your Eclipse IDE.
Create Training.jar file using Training.java and LookUp.jar using LookUp.java and MRDPUtil.java

###Setting up an EC2 key pair
login AWS account, Go to Services and select EC2
In EC2, Click on Key Pairs, create a Key Pair and store it in your local machine.

###Creating S3 Bucket
Go to Services and select S3
In S3, Create bucket by providing bucket name and region where you want to create your bucket.
Click on created bucket and  create seven folders named as TrainingData, Logs, TrainingResults, TrainingJobs, LookUpData, LookUpJobs and LookUpResults
Now  upload appropriate files into the folders

a. Upload the Training.jar file into TrainingJobs folder and LookUp.jar in LookUpJobs folder

b. Upload the input text file into TrainingData folder 

###Creating Cluster 
Go to Services and Click on Elastic MapReduce in the AWS console management
Click on create cluster. Provide the cluster details 

a. Give the Cluster name and select the log folder

b. Select the key pair which we have created

c. After completing all the details click on Create cluster

d. The cluster will start within 10-15 minutes

e. In Steps, select the Custom JAR and click on Configure and provide the JAR location(Training.jar) and arguments details and save it

f. After completion go to the S3bucket and in TrainingResults folder we can see the output file

g. Now upload the outputfile in LookUpData folder as output of Training phase will be treated as input of LookUp phase

h. Again in Steps, select the Custom JAR and click on Configure and provide the JAR location(LookUp.jar) and arguments details and save it

i. After completion go to the S3bucket and in LookUpResults folder we can see the output file.

##Result
Right click on the output file and click on download and open the file with notepad. We can see our expected output.




