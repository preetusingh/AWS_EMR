
#WordCount

WordCount is a simple application that counts the number of occurrences of each word in a given input set.

####Example
If file1 has 3 lines

the quick brown fox

the fox ate the mouse

how now brown cow
    
there is only one reduce task

then output will show the word count done by the mapper and reducer as. 

ate,1
brown,2
cow,1
fox,2
how,1
mouse,1
now,1
quick,1
the,3


##Prerequisites

Download the below mentioned jars and configure into project build path

hadoop-common-2.7.0.jar

hadoop-core-0.20.2.jar

org.apache.commons.cli-1.2.0.jar

JRE System Library[JavaSE-1.7] or above


###Project creation and execution steps

Write WordCount program in Eclipse and export it into a jar named as WordCount.jar.


####Setting up an EC2 key pair

login AWS account, Go to Services and select EC2 In EC2, Click on Key Pairs , create a Key Pair and store it in your local machine.

####Creating S3 Bucket

Go to Services and select S3. In S3, Create bucket by providing bucket name and region where you want to create your bucket. Click on created bucket and create seven folders named as Data, Logs, Results and Jobs. Now upload appropriate files into the folders

a. Upload the PiValue.jar file into Jobs folder

b. Upload the PiCalculationInput.txt file into Data folder

####Creating Cluster

Go to Services and Click on Elastic MapReduce in the AWS console management. Click on create cluster. Provide the cluster details

a. Give the Cluster name and select the log folder

b. Select the key pair which we have created

c. After completing all the details click on Create cluster

d. The cluster will start within 10-15 minutes

e. In Steps, select the Custom JAR and click on Configure and provide the JAR location along with arguments details and save it

f. After completion go to the S3bucket and in Results folder we can see the output file.

###Result

Right click on the output file and click on download and open the file with notepad.We can see our expected output.
