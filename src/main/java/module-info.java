module dwd.mybatis.jdk10test {
    requires spring.boot;
    requires spring.context;
    requires spring.boot.autoconfigure;
    requires mybatis;
    requires spring.jcl;
    requires java.sql;

    exports dwd.mybatisjdk10test.service to spring.beans, spring.context;

    //exports dwd.mybatisjdk10test.model to mybatis; //works if User.setId() is public
    opens dwd.mybatisjdk10test.model to mybatis;

    opens dwd.mybatisjdk10test.mapper;// to java.base, mybatis; //has to be open to all in order to work
    opens dwd.mybatisjdk10test to spring.core, spring.beans, spring.context, mybatis;

    opens db.migration;
}
