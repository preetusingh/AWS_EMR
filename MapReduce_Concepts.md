
#MapReduce
It is a framework that can be used for processing data that resides on hundreds of computers.It does not provide a general solution to what many are calling “big data".

#####A MapReduce design pattern is a template for solving a common and general data manipulation problem with MapReduce. It includes 2 tasks:

###Map task
####Record reader
The purpose of the record reader is to parse the data into records, but not parse the record itself.
It passes the data to the mapper in the form of a key/value pair. Usually,the key in this context is positional information
the value is the chunk of data that composes a record.
####Mapper
In the mapper, user-provided code is executed on each key/value pair from the record reader to produce zero or more new key/value pairs, called the intermediate pairs.
####Combiner
The combiner, an optional localized reducer, can group data in the map phase.
A combiner is not guaranteed to execute, so it cannot be a part of the overall algorithm.
####Partitioner
The partitioner takes the intermediate key/value pairs from the mapper (or combiner if it is being used) and splits them up into shards, one shard per reducer. 
The partitioner can be customized in some more advanced patterns, such as sorting. However, changing the partitioner is rarely necessary.
The partitioned data is written to the local file system for each map task.

###Reduce Task
####Shuffle and Sort
The individual data pieces are sorted to group equivalent keys together so that their values can be iterated over easily in the reduce task.
This phase is not customizable and the framework handles everything automatically.
The only control a developer has is how the keys are sorted and grouped by specifying a custom Comparator object.
####Reducer
The function is passed the key and an iterator over all of the values associated with that key.
The data can be aggregated, filtered, and combined.
Once the reduce function is done, it sends zero or more key/value pair to the final step, the output format.
####Output Format
The output format translates the final key/value pair from the reduce function and writes it out to a file in HDFS by a record writer.
By default, the format will
separate the key and value with a tab and
separate records with a newline character.
