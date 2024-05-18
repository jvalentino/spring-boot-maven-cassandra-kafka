CREATE KEYSPACE IF NOT EXISTS mykeyspace
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

CREATE TABLE mykeyspace.myentity (
    // Define your table columns here
    id UUID PRIMARY KEY,
    value TEXT
);