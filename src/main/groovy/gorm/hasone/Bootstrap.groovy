package gorm.hasone;

import groovy.sql.Sql;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class Bootstrap implements ApplicationEventListener<ServerStartupEvent> {

    @Inject
    DataSource dataSource;

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {

        runSQLScript();
    }

    private void runSQLScript() {

        Sql sql = new Sql(dataSource)
        sql.execute("drop table a_parent;")
        sql.execute("drop table a_child;")
        sql.execute("""
          
            CREATE TABLE a_parent (
                 id varchar(39) NOT NULL,
                 version bigint(20) NOT NULL,
                 parent_description varchar(255) DEFAULT NULL,
                 PRIMARY KEY (id)
            ) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
            
            CREATE TABLE a_child (
                  id varchar(39) NOT NULL,
                  version bigint(20) NOT NULL,
                  description varchar(255) DEFAULT NULL,
                  parent_id varchar(255) NOT NULL,
                  PRIMARY KEY (id),
                  CONSTRAINT FK4EB6E1696BDFA16 FOREIGN KEY (parent_id) REFERENCES a_parent (id)
            ) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
            
            SET FOREIGN_KEY_CHECKS=0;
            
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1000', 0, 'Parent 1000');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1001', 0, 'Parent 1001');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1002', 0, 'Parent 1002');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1003', 0, 'Parent 1003');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1004', 0, 'Parent 1004');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1005', 0, 'Parent 1005');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1006', 0, 'Parent 1006');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1007', 0, 'Parent 1007');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1008', 0, 'Parent 1008');
            INSERT INTO a_parent(id, version, parent_description) VALUES ('1009', 0, 'Parent 1009');
            
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2000', 0, 'Child 2000', '1000');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2001', 0, 'Child 2001', '1001');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2002', 0, 'Child 2002', '1002');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2003', 0, 'Child 2003', '1003');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2004', 0, 'Child 2004', '1004');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2005', 0, 'Child 2005', '1005');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2006', 0, 'Child 2006', '1006');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2007', 0, 'Child 2007', '1007');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2008', 0, 'Child 2008', '1008');
            INSERT INTO a_child(id, version, description, parent_id) VALUES ('2009', 0, 'Child 2009', '1009');
            
            SET FOREIGN_KEY_CHECKS=1;
                
        """)
    }
}
