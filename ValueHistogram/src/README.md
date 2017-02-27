
#Implementation of Histogram to find the frequency of numbers occured in a file using AWS Environment


####Example
If file1 has following numbers

1   3  5  7  9  3  -4   4  5  6

1  20 25 24  3  5  6   4  2  4

1  22 35 24  3  5  6   4  5  7

1  20 28 34  2  5  6   4  8  9

1   3  5  7  9  3  4   4  5  6

1   3  5  7  9  3 67   4  5  6

1   3  5  7  9 78 54  94  5  6

1   3  5  7  9 99 98  54  5  6

1   3  5  7  9  3 64   4  5  6

1   3  5  7  9  -3  4   4  5  6
    
there is only one reduce task


then output will show the frequency of numbers done by the mapper and reducer as. 

1	10

2	2

3	14

4	12

5	18

6	10

7	8

8	1

9	8

20	2

22	1     

24	2

25	1

28	1

34	1

35	1

54	2

64	1

67	1

78	1

94	1

98	1

99	1



##Prerequisites

Download the below mentioned jars and configure into project build path

hadoop-common-2.7.0.jar

hadoop-core-0.20.2.jar

org.apache.commons.cli-1.2.0.jar

JRE System Library[JavaSE-1.7] or above


##Project creation and execution steps

Write Histogram program in Eclipse and export it into a jar named as ValueHistogram.jar.


####Setting up an EC2 key pair

login AWS account, Go to Services and select EC2 In EC2, Click on Key Pairs , create a Key Pair and store it in your local machine.

####Creating S3 Bucket

Go to Services and select S3. In S3, Create bucket by providing bucket name and region where you want to create your bucket. Click on created bucket and create four folders named as Data, Logs, Results and Jobs. Now upload appropriate files into the folders

a. Upload the WordCount.jar file into Jobs folder

b. Upload the file1.txt file into Data folder

####Creating Cluster

Go to Services and Click on Elastic MapReduce in the AWS console management. Click on create cluster. Provide the cluster details

a. Give the Cluster name and select the log folder

b. Select the key pair which we have created

c. After completing all the details click on Create cluster

d. The cluster will start within 10-15 minutes

e. In Steps, select the Custom JAR and click on Configure and provide the JAR location along with arguments details and save it

f. After completion go to the S3bucket and in Results folder we can see the output file.

##Result

Right click on the output file and click on download and open the file with notepad. We can see our expected output.
