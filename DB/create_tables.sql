--just to lucene because it uses jira
CREATE TABLE lusene_found_issues  (
bugid varchar(30) not null,
status varchar(50),
resolution varchar(50),
summary varchar(500),
creationDate timestamp,
commitedDate timestamp,
resolvedDate timestamp,
issueClassification varchar(50),
priority varchar(50),
PRIMARY KEY (bugid)
);

GRANT ALL ON lusene_found_issues TO bugzilla 

--general table to bugzilla issuer tracker
CREATE TABLE httpdbugs (
  bugid int  NOT NULL,
  status varchar(20) NOT NULL,
  resolution varchar(50) NOT NULL,
  summary varchar(500) NOT NULL,
  creationDate TIMESTAMP,
  commitedDate TIMESTAMP,
  resolvedDate TIMESTAMP,
  product VARCHAR(40) NOT NULL,
  component VARCHAR(40) NOT NULL,
  assignee varchar(50),
  PRIMARY KEY  (bugid)
);

GRANT ALL ON httpdbugs TO bugzilla;