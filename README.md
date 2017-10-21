# hibernate-orm5-hibernate-enhance-maven-plugin-test
hibernate-enhance-maven-plugin bug?

Upgraded hibernate from 4.3.11 to 5.1.10 and migrated bytecode enhancement from deprecated ant task to the new maven pluging and the following happens

Setting enableLazyInitialization to true, test fails and setting enableLazyInitialization to false, test passes.

Exception is
"Detached entity passed to persist" on merge with CascadeType.ALL on OneToMany association.

Please use
<code>mvn clean test</code> to run the test.
