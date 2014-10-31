 INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('SOLR-4459','The Replication index move rather than copy optimization doesnt kick in when using NRTCachingDirectory or the rate limiting feature.','15/02/13 05:00:00','10/05/13 11:33:00', '16/02/13 02:27:00', 'Bug', 'Closed', 'Major', 'Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('SOLR-5098','Support adding field types to managed schema','31/07/13 21:27','10/09/14 20:08',
   '10/09/14 17:35','Sub-task', 'Resolved', 'Minor', 'Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('SOLR-2345','geodist support for RPT','16/07/13 18:18','24/07/13 18:26 ','24/07/13 18:26','New Feature','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('SOLR-4916','Add support to write and read Solr index files and transaction log files to and from HDFS.','22/07/13 20:56','25/07/13 01:52','25/07/13 01:52','Sub-task','Resolved','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('SOLR-2654','Directorys used by a SolrCore are now closed when they are no longer used.','20/09/12 18:47', '22/03/13 16:29', '01/10/12 17:06','Bug','Closed','Minor','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5518' ,'minor hunspell optimizations','11/03/14 03:36','12/03/14 13:50', null, 'Improvement','Open','Major', 'Unresolved');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-2510','add more tests, fix bugs found by test where misconfigured factories wouldnt error out until runtime','23/06/10 14:08','10/05/13 11:44','25/07/12 19:04','Task','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-3965','consolidate all api modules and fix packaging for 4.0','19/04/12 07:10','19/04/12 07:10', null, 'Improvement', 'Open', 'Major', 'Unresolved');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4984','Fix ThaiWordFilter, smartcn WordTokenFilter','07/05/13 17:13', '28/04/14 00:25','21/03/14 01:05','Bug','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-3069' ,'Lucene should have an entirely memory resident term dictionary','29/08/13 18:32','05/10/13 11:19','29/08/13 18:42','Bug','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-3753' ,'Restructure the Lucene build system','05/02/12 23:42', '10/05/13 11:44','15/02/12 22:30','Improvement','Closed','Minor','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5969' ,'move old postings back compat to backward-codecs, cleanup PBF related stuff, add segment headers, etc','06/10/14 10:05 ','06/10/14 23:11','06/10/14 23:11','Improvement','Resolved','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4236' ,'move all crazies into one place','10/12/12 14:52','30/01/14 17:01','14/03/13 21:20','Bug','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5166' ,'clear most nocommits, move ord/rord to solr (and speed them up), nuke old purging stuff','12/08/13 08:20', '14/05/14 06:51','15/08/13 18:05', 'Bug','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4848' ,'Use Java 7 NIO2-FileChannel instead of RandomAccessFile for NIOFSDirectory and MMapDirectory','20/03/13 19:01', '23/02/14 12:08', '29/03/13 17:48', 'Improvement', 'Resolved', 'Major', 'Wont Fix');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-3867' ,'Refactor RamUsageEstimator. CHANGES.txt will be added once backported to 3.x.','19/03/12 22:52', '10/05/13 11:44', '19/03/12 23:23', 'Bug', 'Closed', 'Major', 'Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5569' ,'*AtomicReader/AtomicReaderContext have been renamed to *LeafReader-LeafReaderContext','03/04/14 19:39 ', '24/09/14 10:30', '24/09/14 10:30', 'Improvement', 'Resolved','Blocker','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4975' ,'Add Replication module to Lucene','06/05/13 09:25','23/07/13 19:37', '07/05/13 06:54','Improvement','Closed','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4208' ,'makeQuery return ConstantScoreQuery, standardize makeDistanceValueSource behavior','27/06/12 12:27','21/09/12 05:59', '21/09/12 05:59', 'Bug','Resolved','Major','Wont Fix');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5214' ,'add FreeTextSuggester','15/09/13 14:36','02/10/13 19:00','02/10/13 16:31','Improvement','Resolved','Major','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-4752' ,'Preliminaries:- move useful assert*Equals from TestDuelingCodecs to LuceneTestCase,- rename sort to wrap in SortingAtomicReader to better suggest that the returned reader is a view.','20/03/13 16:26','10/05/13 11:33','21/03/13 17:14','Improvement','Closed','Minor','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-3930' ,'nuke jars from source tree and use ivy','27/03/12 23:17','10/05/13 11:42',
   '02/04/12 21:58','Task','Closed','Blocker','Fixed');

   INSERT INTO lusene_found_issues (bugid, summary, creationdate, commitdate, resolveddate, issueClassification, status, priority, resolution) values ('LUCENE-5399' ,'current state','14/01/14 10:31','16/03/14 13:02','16/01/14 19:02','Bug','Closed','Major','Fixed');